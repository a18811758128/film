package com.ln.film.form;

/**
 * Form bean for user update its account password
 */
public class PasswordUpdateForm extends CaptchaControllerForm {
    private String oldPassword;
    private String password;
    private String password2;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    @Override
    public String toString() {
        return "PasswordUpdateForm{" +
                "oldPassword='" + oldPassword + '\'' +
                ", password='" + password + '\'' +
                ", password2='" + password2 + '\'' +
                '}';
    }
}
