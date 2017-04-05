package com.ln.film.form;

public abstract class CaptchaControllerForm extends ControllerForm {
    private String captcha;

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
