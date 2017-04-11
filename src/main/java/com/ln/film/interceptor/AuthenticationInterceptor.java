/**
 * 
 */
package com.ln.film.interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ln.film.annotation.Login;
import com.ln.film.model.Role;
import com.ln.film.model.Users;
import com.ln.film.model.transients.AccessLevel;
import com.ln.film.service.LoginService;
import com.ln.film.service.UserService;
import com.ln.film.utils.CookieUtils;
import com.ln.film.utils.SharedConstants;


/**
 *
 */
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
    private static Log LOG = LogFactory.getLog(AuthenticationInterceptor.class);

    @Autowired
    private CookieUtils cookieUtils;
    
    @Autowired
    private LoginService loginService;

    @Autowired
    private UserService userService;
    

    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        LOG.info("AuthenticationInterceptor: Pre-handle, request URI is:"
                + request.getRequestURI());
        checkCookie(request, response);
        if (handler instanceof HandlerMethod) {
            HandlerMethod hmethod = (HandlerMethod) handler;
            initAttribute(hmethod, request, response);
            if (!checkLogin(hmethod, request, response)) {
                return false;
            }
        }
        return true;
    }

    private void checkCookie(HttpServletRequest request,
            HttpServletResponse response) {
        try {
            // 判断是否有登录用户，无登录用户尝试从Cookie登录
            Users user = (Users) request.getSession().getAttribute(
                    SharedConstants.SESSION_USER_KEY);
            LOG.info("user in session is:" + user);
            if (user == null) {
                Cookie cookie = cookieUtils.getCookie(request,
                        SharedConstants.USER_COOKIE_KEY);
                LOG.info("cookie object is:" + cookie);
                if (cookie != null) {
                    String userCookie = cookie.getValue();
                    user = loginService.loginByCookie(userCookie);
                    if (user != null) {
                        request.getSession().setAttribute(
                                SharedConstants.SESSION_USER_KEY, user);
                        request.getSession().setAttribute(
                                SharedConstants.SESSION_HASLOGIN_KEY, true);
                        // renew the cookie
                        cookieUtils.removeCookie(response,
                                SharedConstants.USER_COOKIE_KEY);
                        cookieUtils.setCookie(response,
                                SharedConstants.USER_COOKIE_KEY, userCookie,
                                SharedConstants.COOKIE_EXPIRE_TIME);
                    }
                }
            } else {
                request.getSession().setAttribute(
                        SharedConstants.SESSION_HASLOGIN_KEY, true);
            }
            Role role = (Role) request.getSession().getAttribute(
                    SharedConstants.SESSION_ROLE_KEY);
            if (role == null && user != null) {
                role = userService.getUserRole(user);
                request.getSession().setAttribute(
                        SharedConstants.SESSION_ROLE_KEY, role);
            }
        } catch (Exception ex) {
            LOG.error("read user from cookie failed. error is:"
                    + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * 初始化request Attribute属性
     * 
     * @param request
     * @param response
     */
    private void initAttribute(HandlerMethod hmethod,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String partner = request.getParameter("partner");
        if (StringUtils.isNotEmpty(partner)) {
            // 退出浏览器 parnter失效
            cookieUtils.setCookieWithPrefix(response, "partner", partner, -1);
            request.setAttribute("partner", partner);
        } else {
            partner = cookieUtils.getCookieValueWithPrefix(request, "partner");
            if (StringUtils.isNotEmpty(partner)) {
                request.setAttribute("partner", partner);
            } else {
                request.setAttribute("partner", "");
            }
        }

        LOG.info("Partner is " + partner);

        String userAgent = request.getHeader("User-Agent");
        if (userAgent != null
                && userAgent.toLowerCase().indexOf("micromessenger") != -1) {
            request.setAttribute("isWechat", true);
        } else {
            request.setAttribute("isWechat", false);
        }

        boolean isMobile = false;
        if (userAgent != null && userAgent.indexOf("Mobile") > -1) {
            isMobile = true;
        }
        request.setAttribute("isMobile", isMobile);
    }

    private boolean checkLogin(HandlerMethod hmethod,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Method method = hmethod.getMethod();
        // 用户登录
        Login login = hmethod.getBean().getClass().getAnnotation(Login.class);
        if (login == null || !login.required()) {
            login = method.getAnnotation(Login.class);
        }
        if (login != null && login.required()) {
            LOG.info("login required.");
            Users user = (Users) request.getSession().getAttribute(
                    SharedConstants.SESSION_USER_KEY);
            Role role = (Role) request.getSession().getAttribute(
                    SharedConstants.SESSION_ROLE_KEY);

            boolean isMobile = (Boolean) request.getAttribute("isMobile");
            boolean isJson = method.getAnnotation(ResponseBody.class) != null;
            if (user == null || role == null) {
                LOG.info("AuthenticationInterceptor: recirecting "
                        + request.getRequestURI() + " to /account/login");
                LOG.debug("###request uri is:" + request.getRequestURI());
                if (user == null) {
                    error400(request, response, isMobile, isJson);
                    return false;
                }
            } else {
                String targetUri = getTargetUri(method);
                boolean isPost = getIsPost(method);
                LOG.info("target uri is:" + targetUri + ", isPost? " + isPost);
                if (StringUtils.isEmpty(targetUri)) {
                    targetUri = request.getRequestURI();
                }
                Boolean allowed = null;
                if (allowed == null) {
                    int pageLevel = login.level();
                    allowed = role.getAccessLevel() >= pageLevel;
                }
                if (!allowed) {
                    error401(role, response, isMobile, isJson);
                    return false;
                }
            }
        }
        LOG.info("AuthenticationInterceptor: Pass the interceptor, no recirection.");

        return true;
    }

    private String getTargetUri(Method method) {
        String result = "";
        try {
            RequestMapping clsMapping = method.getDeclaringClass()
                    .getAnnotation(RequestMapping.class);
            if (clsMapping != null && clsMapping.value() != null
                    && clsMapping.value().length > 0) {
                result = clsMapping.value()[0];
            }
            RequestMapping reqMapping = method
                    .getAnnotation(RequestMapping.class);
            if (reqMapping != null && reqMapping.value() != null
                    && reqMapping.value().length > 0) {
                result = result + reqMapping.value()[0];
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    private boolean getIsPost(Method method) {
        RequestMapping rm = method.getAnnotation(RequestMapping.class);
        boolean isPost = false;
        if (rm != null && rm.method().length > 0) {
            isPost = (rm.method()[0] == RequestMethod.POST);
        }
        return isPost;
    }

    private void error400(HttpServletRequest request,
            HttpServletResponse response, boolean isMobile, boolean isJson)
            throws IOException {
        LOG.debug("error 400, isMobile:" + isMobile + ", isJson:" + isJson);
        // user in session is empty
        StringBuilder builder = new StringBuilder(request.getRequestURL()
                .toString());
        String qs = request.getQueryString();
        if (!StringUtils.isEmpty(qs)) {
            builder.append("?");
            builder.append(qs);
        }
        if (isJson) {
            String redirctUrl = "/login";
            JSONObject obj = new JSONObject();
            obj.put("code", 400);
            obj.put("msg", "Invalidate Request, please login.");
            if (!isMobile) {
                redirctUrl = "/login";
            }
            obj.put("url", redirctUrl);
            String returnurl = request.getHeader("referer"); // Yes, with the
                                                             // legendary
                                                             // misspelling.
            LOG.debug("returnurl is:" + returnurl);
            obj.put("returnurl", returnurl);
            PrintWriter write = response.getWriter();
            write.write(obj.toString());
            write.flush();
        } else {
            String returnurl = URLEncoder.encode(builder.toString(), "UTF-8");
            LOG.debug(returnurl);
            if (isMobile) {
                response.sendRedirect(String.format("/login?returnurl=%s",
                        returnurl));
            } else {
                response.sendRedirect(String.format("/login?returnurl=%s",
                        returnurl));
            }
        }
    }

    private void error401(Role role, HttpServletResponse response,
            boolean isMobile, boolean isJson) throws IOException {
        // user level smaller than the page level
        String redirctUrl = "/";
        switch (role.getAccessLevel()) {
        case AccessLevel.ADMIN_GENERAL:
            break;
        case AccessLevel.SUPERVISOR:
            break;
        case AccessLevel.USER:
            redirctUrl = "/";
            break;
        default:
            break;
        }
        if (isJson) {
            JSONObject obj = new JSONObject();
            obj.put("code", 401);
            obj.put("message", "Unauthorized Request");
            obj.put("url", redirctUrl);
            PrintWriter write = response.getWriter();
            write.write(obj.toString());
            write.flush();
        } else {
            response.sendRedirect(redirctUrl);
        }
    }
}
