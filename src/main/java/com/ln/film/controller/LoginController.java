package com.ln.film.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ln.film.annotation.Login;
import com.ln.film.exception.authentication.AuthenticationException;
import com.ln.film.form.LoginForm;
import com.ln.film.model.AjaxResult;
import com.ln.film.model.Role;
import com.ln.film.model.Users;
import com.ln.film.model.transients.AccessLevel;
import com.ln.film.service.LoginService;
import com.ln.film.service.UserService;
import com.ln.film.utils.AuthenticationHelper;
import com.ln.film.validator.LoginValidator;


/**
 * 
 */
@Controller
public class LoginController extends AbstractController {

    @Autowired
    private LoginValidator loginValidator;
    
    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showForm(@ModelAttribute(FORM_ATTR_NAME) LoginForm form) {
        try {
            if (!StringUtils.isEmpty(form.getReturnurl())) {
                form.setReturnurl(URLEncoder.encode(form.getReturnurl(),
                        "utf-8"));
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "login-form";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request,
            HttpServletResponse response, HttpSession session,
            @ModelAttribute(FORM_ATTR_NAME) LoginForm form,BindingResult result) {
        logger.debug("login, form is:" + form);
        loginValidator.validate(form, result);
        if (result.hasErrors()) {
            return "login-form";
        }

        try {
            Users user = loginService.login(form.getUsername(),
                    form.getPassword(), request.getRemoteAddr());
            AuthenticationHelper.putAuthentication(session, user);

            Role role = userService.getUserRole(user);
            AuthenticationHelper.putAuthenticatedUserRole(session, role);
//            loginService.saveLoginCookie(response, user);
        } catch (AuthenticationException e) {
            logger.error("authentication failed!" + e.getMessage());
            result.reject("form.login.error.username.password.not.match");
            logger.debug("login has errors. result:" + result);
            return "login-form";
        }

        return redirectTo("/login/success?returnurl=" + form.getReturnurl());
    }

    @RequestMapping(value = "/login.ajax", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult ajaxLogin(HttpServletRequest request,
            HttpServletResponse response, HttpSession session, String username,
            String password) {

        try {
            Users user = loginService.login(username, password,
                    request.getRemoteAddr());
            AuthenticationHelper.putAuthentication(session, user);
//            int noReadCount = messageService.getMessageCount(user.getId(),
//                    MessageType.ALL, MessageStatus.SENT);
//            request.getSession().setAttribute("noReadCount", noReadCount);
            Role role = userService.getUserRole(user);
            AuthenticationHelper.putAuthenticatedUserRole(session, role);
            session.setMaxInactiveInterval(900);

//            loginService.saveLoginCookie(response, user);
            return new AjaxResult(AjaxResult.SUCCESS,
                    request.getHeader("Referer"));

        } catch (AuthenticationException e) {
            logger.debug("Wrong password...");
            return new AjaxResult(AjaxResult.FAIL, "wrong pw");
        }
    }

    @RequestMapping(value = "/login/success")
    @Login
    public String showSuccess(
            Model model,
            @RequestParam(value = "returnurl", required = false) String returnurl,
            HttpSession session) {
        logger.info("login success, return url is:" + returnurl);
        model.addAttribute("returnurl", returnurl);
        Role role = AuthenticationHelper.getAuthenticatedUserRole(session);
        logger.info("role is:" + role);
        	return "login-success";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session, HttpServletResponse response) {
        AuthenticationHelper.removeAuthentication(session);
        loginService.removeLoginCookie(response);
        return redirectTo("/logout/success");
    }

    @RequestMapping(value = "/logout/success")
    public String showLogoutSuccess() {

        return "logout-success";
    }

    @RequestMapping(value = "/usermanagelogin", method = RequestMethod.GET)
    public String showUsermanageLoginForm(@ModelAttribute(FORM_ATTR_NAME) LoginForm form) {
        try {
            if (!StringUtils.isEmpty(form.getReturnurl())) {
                form.setReturnurl(URLEncoder.encode(form.getReturnurl(), "utf-8"));
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "usermanage/usermanage-login";
    }
    
    @RequestMapping(value = "/usermanagelogin", method = RequestMethod.POST)
    public String usermanagelogin(HttpServletRequest request, HttpSession session,
                        @ModelAttribute(FORM_ATTR_NAME) LoginForm form, BindingResult result) {
        logger.debug("login, form is:" + form);
        loginValidator.validate(form, result);
        if (result.hasErrors()) {
            return "login-form";
        }

        try {
            Users user = loginService.login(form.getUsername(), form.getPassword(), request.getRemoteAddr());
            Role role = userService.getUserRole(user);
            if(role.getAccessLevel()>=AccessLevel.ADMIN_GENERAL){
            	AuthenticationHelper.putAuthentication(session, user);
            	AuthenticationHelper.putAuthenticatedUserRole(session, role);
            	return redirectTo("/usermanage/showmanage");
            }else{
            	return "login-form";
            }
        } catch (AuthenticationException e) {
            logger.error("authentication failed!" + e.getMessage());
            result.reject("form.login.error.username.password.not.match");
            logger.debug("login has errors. result:" + result);
            return "login-form";
        }
    }
}
