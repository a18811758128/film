package com.ln.film.form;

/**
 * Form bean for user reset its account password
 */
public class PasswordResetForm extends CaptchaControllerForm {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "PasswordResetForm{" +
                "email='" + email + '\'' +
                '}';
    }
}
