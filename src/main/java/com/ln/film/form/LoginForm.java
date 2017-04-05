package com.ln.film.form;

/**
 * Form bean for user authentication
 */
public class LoginForm extends CaptchaControllerForm {
    private String username;
    private String password;
    private String returnurl;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the returnurl
     */
    public String getReturnurl() {
        return returnurl;
    }

    /**
     * @param returnurl the returnurl to set
     */
    public void setReturnurl(String returnurl) {
        this.returnurl = returnurl;
    }

    @Override
    public String toString() {
        return "LoginForm{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", returnurl='" + returnurl + "'" +
                '}';
    }
}
