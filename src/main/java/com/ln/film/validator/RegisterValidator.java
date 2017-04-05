package com.ln.film.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

import com.ln.film.RegConstants;
import com.ln.film.form.RegisterForm;


/**
 * Form validator for user register
 */
@Component
public class RegisterValidator extends FormValidator<RegisterForm> {

    @Override
    public void validate(RegisterForm form, Errors errors) {
        if (StringUtils.isEmpty(form.getpName())) {
            errors.rejectValue("pName", "form.register.error.username.empty");
        }
        if (StringUtils.isEmpty(form.getpPassword())) {
            errors.rejectValue("pPassword", "form.register.error.password.empty");
        } else if (!form.getpPassword().equals(form.getpConfirmPassword())) {
            errors.rejectValue("pConfirmPassword", "form.register.error.password2.not.match");
        }

        if (StringUtils.hasText(form.getpCPhone())
                && !RegConstants.PATTERN_MOBILE_PHONE.matcher(form.getpCPhone()).matches()) {
            errors.rejectValue("pCPhone", "form.register.error.mobile.pattern");
        }

        if (StringUtils.isEmpty(form.getpRName())) {
            errors.rejectValue("pRName", "form.register.error.real.name.empty");
        } else if (form.getpRName().length() < 1 || form.getpRName().length() > 10) {
            errors.rejectValue("pRName", "form.register.error.real.name.pattern");
        }
        if (StringUtils.isEmpty(form.getpCNumber())) {
            errors.rejectValue("pCNumber", "form.register.error.id.card.no.empty");
        } else if (!RegConstants.PATTERN_ID_CARD_NO.matcher(form.getpCNumber()).matches()) {
            errors.rejectValue("pCNumber", "form.register.error.id.card.no.pattern");
        }

        if (StringUtils.isEmpty(form.getpMail())) {
            errors.rejectValue("pMail", "form.register.error.email.empty");
        } else if (!RegConstants.PATTERN_EMAIL.matcher(form.getpMail()).matches()) {
            errors.rejectValue("pMail", "form.register.error.email.pattern");
        }

        if (!form.ispAcceptRule()) {
            errors.rejectValue("pAcceptRule", "form.register.error.terms.not.accepted");
        }
    }
}
