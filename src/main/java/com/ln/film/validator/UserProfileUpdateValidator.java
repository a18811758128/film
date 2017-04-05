package com.ln.film.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.ln.film.form.ProfileUpdateForm;

/**
 * Form validator for user profile update
 */
@Component
public class UserProfileUpdateValidator extends FormValidator<ProfileUpdateForm> {


    @Override
    public void validate(ProfileUpdateForm form, Errors errors) {
        // todo: add validation details
    }
}
