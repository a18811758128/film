package com.ln.film.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

import com.ln.film.RegConstants;
import com.ln.film.form.PasswordResetForm;

/**
 * Form validator for user authentication
 */
@Component
public class PasswordResetValidator extends FormValidator<PasswordResetForm> {

    @Override
    public void validate(PasswordResetForm form, Errors errors) {
        if (StringUtils.isEmpty(form.getEmail())) {
            errors.rejectValue("email", "form.password.reset.error.email.empty");
        } else if (!RegConstants.PATTERN_EMAIL.matcher(form.getEmail()).matches()) {
            errors.rejectValue("email", "form.password.reset.error.email.pattern");
        }
    }
}
