package com.ln.film.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

import com.ln.film.form.PasswordUpdateForm;


/**
 * Form validator for user update its password
 */
@Component
public class PasswordUpdateValidator extends FormValidator<PasswordUpdateForm> {

    @Override
    public void validate(PasswordUpdateForm form, Errors errors) {
        if (StringUtils.isEmpty(form.getOldPassword())) {
            errors.rejectValue("oldPassword", "form.password.update.error.old.password.empty");
        }
        if (StringUtils.isEmpty(form.getPassword())) {
            errors.rejectValue("oldPassword", "form.password.update.error.password.empty");
        }
        if (StringUtils.isEmpty(form.getPassword2())) {
            errors.rejectValue("oldPassword", "form.password.update.error.password2.empty");
        } else if (!form.getPassword().equals(form.getPassword2())) {
            errors.rejectValue("oldPassword", "form.password.update.error.password2.not.match");
        }
    }
}
