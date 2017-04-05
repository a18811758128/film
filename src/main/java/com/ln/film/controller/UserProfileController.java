package com.ln.film.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ln.film.annotation.Login;
import com.ln.film.form.ProfileUpdateForm;
import com.ln.film.model.AjaxResult;
import com.ln.film.model.Role;
import com.ln.film.model.Users;
import com.ln.film.service.EmailService;
import com.ln.film.service.UserService;
import com.ln.film.utils.AuthenticationHelper;
import com.ln.film.validator.UserProfileUpdateValidator;


/**
 *
 */

@Controller
@Login
public class UserProfileController extends AbstractController {

    public static String AVATAR_ROOT = "/upload/avatar-dir/";
    public static String AVATAR_DEFAULT = "/assert/images/user_avatar.png";

    @Autowired
    private UserService userService;

    @Autowired
    private UserProfileUpdateValidator updateValidator;

//    @Autowired
//    private EmailUpdateValidator emailUpdateValidator;
//
//    @Autowired
//    private MobileUpdateValidator mobileUpdateValidator;

    @Autowired
    private EmailService emailService;

    @RequestMapping(value = "/profile")
    public String viewHome(HttpSession session, ModelMap model) {
    	if (session == null || null == session.getAttribute("hasLogin") || session.getAttribute("user") == null) {
			logger.info("没有登录, 重定向至登陆页");
			return "redirect:/login";
		}
        Users user = (Users) session.getAttribute("user");
        logger.info("访问个人中心");
        if (StringUtils.isEmpty(user.getUphoto())) {
            user.setUphoto(AVATAR_DEFAULT);
        }
        model.put("user", user);

        return "user-profile";
    }

    @RequestMapping(value = "/settings", method = RequestMethod.GET)
    public String showProfileUpdateForm(HttpSession session, Model uiModel,
            @ModelAttribute(FORM_ATTR_NAME) ProfileUpdateForm form) {
        logger.info("用户信息与安全设置页面");
        if (session == null || null == session.getAttribute("hasLogin") || session.getAttribute("user") == null) {
			logger.info("没有登录, 重定向至登陆页");
			return "redirect:/login";
		}
        Users user = AuthenticationHelper.getAuthentication(session);
        if (StringUtils.isEmpty(user.getUphoto())) {
            user.setUphoto(AVATAR_DEFAULT);
        }
        form.setUsex(user.getUsex());
        form.setUbirth(user.getUbirth());
        form.setUqq(user.getUqq());

        uiModel.addAttribute("user", user);
        Role role=AuthenticationHelper.getAuthenticatedUserRole(session);
        uiModel.addAttribute("role", role);
        return "user-profile-info";
    }

    @RequestMapping(value = "/settings", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult updateProfile(HttpSession session,
            @ModelAttribute(FORM_ATTR_NAME) ProfileUpdateForm form,
            BindingResult result) {
        if (session == null || null == session.getAttribute("hasLogin")
                || session.getAttribute("user") == null) {
            logger.info("没有登录, 重定向至登陆页");
            return new AjaxResult(AjaxResult.FAIL, "login");
        }
        AjaxResult ajaxResult = new AjaxResult(AjaxResult.FAIL);
        updateValidator.validate(form, result);
        if (result.hasErrors()) {
            return ajaxResult;
        }

        Users user = AuthenticationHelper.getAuthentication(session);
        user.setUsex(form.getUsex());
        user.setUbirth(form.getUbirth());
        user.setUqq(form.getUqq());
        ajaxResult.setCode(AjaxResult.SUCCESS);

        userService.saveUser(user);

        return ajaxResult;
    }


//    // ------------- mobile
//    @RequestMapping(value = "/profile/mobile")
//    public String showMobileUpdateForm(HttpServletRequest request,
//            @ModelAttribute(FORM_ATTR_NAME) MobileUpdateForm form) {
//        logger.info("update user mobile...");
//        User user = AuthenticationHelper
//                .getAuthentication(request.getSession());
//        logger.info("user is:" + user);
//        if (user != null && Boolean.TRUE.equals(user.getMobileActivated())) {
//            return redirectTo("/profile/mobile/updated");
//        } else if (user != null) {
//            form.setMobile(user.getMobile());
//        }
//        return "profile-mobile-update-form";
//    }

//    @RequestMapping(value = "/profile/mobile", method = RequestMethod.POST)
//    public String updateMobile(HttpServletRequest request,
//            @ModelAttribute(FORM_ATTR_NAME) MobileUpdateForm form,
//            BindingResult result) {
//        logger.info("do update mobile...");
//        mobileUpdateValidator.validate(form, result);
//        if (result.hasErrors()) {
//            return "profile-mobile-update-form";
//        }
//
//        User user = AuthenticationHelper
//                .getAuthentication(request.getSession());
//        logger.info("user in session is:" + user);
//        if (Boolean.TRUE.equals(user.getMobileActivated())) {
//            return redirectTo("/profile/mobile/updated");
//        } else if (!smsService.checkVerifyCode(form.getMobile(), form.getCode())) {
//            result.rejectValue("code", "form.mobile.update.error.code.bad");
//            return "profile-mobile-update-form";
//        }
//
//        // verify duplication
//        if (!form.getMobile().equals(user.getMobile())) {
//            // currently do not allow duplication mobile number,
//            // no matter whether it's activated or not
//            User mobileUser = userService.findByMobile(form.getMobile(), false);
//            if (mobileUser != null) {
//                result.rejectValue("mobile",
//                        "form.mobile.update.error.mobile.duplicated",
//                        new String[] { form.getMobile() }, null);
//                return "profile-mobile-update-form";
//            }
//        }
//
//        // persist to database
//        user.setMobile(form.getMobile());
//        user.setMobileActivated(true);
//        userService.saveUser(user);
//
//        return redirectTo("/profile/mobile/updated");
//    }
//
//    @RequestMapping(value = "/profile/mobile/updated")
//    public String showMobileUpdated(HttpServletRequest request) {
//        User user = AuthenticationHelper
//                .getAuthentication(request.getSession());
//        request.setAttribute("user", user);
//        return "profile-mobile-updated";
//    }
//
//    // ------------- email
//    @RequestMapping(value = "/profile/email")
//    public String showEmailUpdateForm(HttpServletRequest request,
//            @ModelAttribute(FORM_ATTR_NAME) EmailUpdateForm form) {
//        User user = AuthenticationHelper
//                .getAuthentication(request.getSession());
//        if (Boolean.TRUE.equals(user.getEmailActivated())) {
//            return redirectTo("/profile/email/bound");
//        }
//        form.setEmail(user.getEmail());
//        return "profile-email-update-form";
//    }
//
//    @RequestMapping(value = "/profile/email", method = RequestMethod.POST)
//    public String updateEmail(HttpServletRequest request,
//            @ModelAttribute(FORM_ATTR_NAME) EmailUpdateForm form,
//            BindingResult result) {
//        emailUpdateValidator.validate(form, result);
//        if (result.hasErrors()) {
//            return "profile-email-update-form";
//        }
//
//        User user = AuthenticationHelper
//                .getAuthentication(request.getSession());
//        // verify duplication
//        if (Boolean.TRUE.equals(user.getEmailActivated())) {
//            return redirectTo("/profile/email/bound");
//        } else if (!form.getEmail().equals(user.getEmail())) {
//            User emailUser = userService.findByEmail(form.getEmail(), true);
//            if (emailUser != null) {
//                result.rejectValue("email",
//                        "form.email.update.error.duplicated",
//                        new String[] { form.getEmail() }, null);
//                return "profile-email-update-form";
//            }
//        }
//
//        // persist to database
//        user.setEmail(form.getEmail());
//        userService.saveUser(user);
//        request.setAttribute("email", form.getEmail());
//
//        // send verification email
//        emailService.sendVerifyEmail(user);
//
//        return "profile-email-verification-sent";
//    }


    @RequestMapping(value = "/profile/avatar")
    public String changeAvatarPage(HttpServletRequest request,HttpSession session) {
    	if (session == null || null == session.getAttribute("hasLogin") || session.getAttribute("user") == null) {
			logger.info("没有登录, 重定向至登陆页");
			return "redirect:/login";
		}
        Users user = AuthenticationHelper
                .getAuthentication(request.getSession());
        request.setAttribute("user", user);
        return "user-profile-avatar";
    }

    @RequestMapping(value = "/avatar/set", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult ajaxAvatarSet(Model uiModel,
            HttpServletRequest request, HttpServletResponse response,
            HttpSession session,
            @RequestParam(value = "file", required = true) MultipartFile file) {
        logger.info("do upload, file:" + file.getOriginalFilename());

        if (session == null || null == session.getAttribute("hasLogin")
                || session.getAttribute("user") == null) {
            logger.info("没有登录, 重定向至登陆页");
            return new AjaxResult(AjaxResult.FAIL, "login");
        }
        Users user = (Users) session.getAttribute("user");
        if (user == null) {
            logger.info("用户为空, 重定向至登陆页");
            return new AjaxResult(AjaxResult.FAIL, "login");
        }
        if (!file.isEmpty()) {
            try {
            	String originalName = file.getOriginalFilename();
				String extension = originalName.substring(originalName
						.lastIndexOf('.'));
				String uuid = UUID.randomUUID().toString();
				String filenewName = uuid + extension;
				String path=session.getServletContext().getRealPath(AVATAR_ROOT+filenewName);
				logger.info("存放路径为："+path);
				File dir = new File(path);
				if (!dir.exists()) {
					dir.mkdirs();
				}
				file.transferTo(dir);
                logger.info("avatar name is:" + filenewName);
                user.setUphoto(AVATAR_ROOT+filenewName);
                userService.saveUser(user);
            } catch (IOException | RuntimeException e) {
                e.printStackTrace();
                return new AjaxResult(AjaxResult.FAIL, e.getLocalizedMessage());
            }
        } else {
            return new AjaxResult(AjaxResult.FAIL, "file is empty!");
        }
        return new AjaxResult(AjaxResult.SUCCESS);
    }
}
