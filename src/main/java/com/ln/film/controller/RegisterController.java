package com.ln.film.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ln.film.exception.user.UserEmailDuplicatedException;
import com.ln.film.exception.user.UserMobileDuplicatedException;
import com.ln.film.exception.user.UsernameDuplicatedException;
import com.ln.film.form.RegisterForm;
import com.ln.film.model.Users;
import com.ln.film.service.RegisterService;
import com.ln.film.validator.RegisterValidator;


/**
 * 
 */
@Controller
public class RegisterController extends AbstractController {

    @Autowired
    private RegisterValidator registerValidator;

    @Autowired
    private RegisterService registerService;


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showForm(@ModelAttribute(FORM_ATTR_NAME) RegisterForm form) {

        return "register-form";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(HttpServletRequest request,
            @ModelAttribute(FORM_ATTR_NAME) RegisterForm form,ModelMap map,
            BindingResult result) {
        logger.debug("register individual, form is:" + form);
        registerValidator.validate(form, result);
        if (result.hasErrors()) {
            logger.debug("register form has errors. result:" + result);
            return "register-form";
        }

        try {
            Users user = registerService.register(form.getpName(),
                    form.getpPassword(), form.getpCPhone(), form.getpRName(),
                    form.getpCNumber(), form.getpMail(),
                    request.getRemoteAddr());

        } catch (UsernameDuplicatedException e) {
            logger.warn("Failed to register.", e);
            result.rejectValue("pName","form.register.error.username.duplicated",
                    new String[] { form.getpName() }, null);
            return "register-form";
        } catch (UserEmailDuplicatedException e) {
            logger.warn("Failed to register.", e);
            result.rejectValue("pMail", "form.register.error.email.duplicated",
                    new String[] { form.getpMail() }, null);
            return "register-form";
        } catch (UserMobileDuplicatedException e) {
            logger.warn("Failed to register.", e);
            result.rejectValue("pCPhone",
                    "form.register.error.mobile.duplicated",
                    new String[] { form.getpCPhone() }, null);
            return "register-form";
        }

        return redirectTo("/register/success");
    }

    @RequestMapping(value = "/register/success")
    public String showSuccess() {

        return "register-success";
    }

}
