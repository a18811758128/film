package com.ln.film.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.ln.film.form.ControllerForm;

/**
 * Abstract form validator
 */
public abstract class FormValidator<T extends ControllerForm> implements Validator {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public boolean supports(Class<?> clazz) {
        return this.getClass().isAssignableFrom(clazz);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void validate(Object target, Errors errors) {
        validate((T) target, errors);
    }

    public abstract void validate(T form, Errors errors);
}