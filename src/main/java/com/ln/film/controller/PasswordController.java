package com.ln.film.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ln.film.annotation.Login;
import com.ln.film.exception.authentication.BadCredentialException;
import com.ln.film.form.PasswordResetForm;
import com.ln.film.form.PasswordUpdateForm;
import com.ln.film.model.Users;
import com.ln.film.service.LoginService;
import com.ln.film.service.PasswordService;
import com.ln.film.utils.AuthenticationHelper;
import com.ln.film.validator.PasswordResetValidator;
import com.ln.film.validator.PasswordUpdateValidator;


/**
 * Controller for user to manage its account password
 * 
 */
@Controller
@RequestMapping(value = "/password")
public class PasswordController extends AbstractController {

    @Autowired
    private PasswordService passwordService;

    @Autowired
    private PasswordUpdateValidator updateValidator;

    @Autowired
    private PasswordResetValidator resetValidator;
    
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/update")
    @Login
    public String showUpdateForm(@ModelAttribute(FORM_ATTR_NAME) PasswordUpdateForm form) {

        return "password-update-form";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @Login
    public String update(HttpServletRequest request,
                         @ModelAttribute(FORM_ATTR_NAME) PasswordUpdateForm form, BindingResult result,HttpServletResponse response) {
        updateValidator.validate(form, result);
        if (result.hasErrors()) {
            return "password-update-form";
        }

        Users user = AuthenticationHelper.getAuthentication(request.getSession());
        try {
            passwordService.update(user, form.getOldPassword(), form.getPassword());
            loginService.removeLoginCookie(response);
        } catch (BadCredentialException e) {
            result.rejectValue("oldPassword", "form.password.update.error.old.password.bad");
            return "password-update-form";
        }

        return redirectTo("/password/update/success");
    }

    @RequestMapping(value = "/update/success")
    @Login
    public String showUpdateSuccess() {
        return "password-update-success";
    }

    @RequestMapping(value = "/relogin")
    @Login
    public String reLogin(HttpSession session) {
        // logout after password is updated
        session.removeAttribute("user");
        session.setAttribute("hasLogin", false);
        return redirectTo("/login");
    }

    @RequestMapping(value = "/forget")
    public String showResetForm(@ModelAttribute(FORM_ATTR_NAME) PasswordResetForm form) {

        return "password-reset-form";
    }

    @RequestMapping(value = "/reset", method = RequestMethod.POST)
    public String reset(HttpServletRequest request,
                        @ModelAttribute(FORM_ATTR_NAME) PasswordResetForm form, BindingResult result) {
        resetValidator.validate(form, result);
        if (result.hasErrors()) {
            return "password-reset-form";
        }

        try {
            passwordService.reset(form.getEmail(), request.getRemoteAddr());
        } catch (Exception e) {
            result.rejectValue("email", "form.password.reset.error.email.no.user", new String[]{form.getEmail()}, null);
            return "password-reset-form";
        }

        return redirectTo("/password/reset/success");
    }

    @RequestMapping(value = "/reset//success")
    public String showResetSuccess() {

        return "password-reset-success";
    }
}
