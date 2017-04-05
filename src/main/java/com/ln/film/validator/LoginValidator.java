package com.ln.film.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import com.ln.film.form.LoginForm;


/**
 * Form validator for user authentication
 */
@Component
public class LoginValidator extends FormValidator<LoginForm> {

    @Override
    public void validate(LoginForm form, Errors errors) {
        if (StringUtils.isEmpty(form.getUsername())) {
            errors.rejectValue("username", "form.login.error.username.empty");
        }

        if (StringUtils.isEmpty(form.getPassword())) {
            errors.rejectValue("password", "form.login.error.password.empty");
        }
    }
}
