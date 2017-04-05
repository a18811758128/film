package com.ln.film.form;

/**
 * Form bean for user register
 */
public class RegisterForm extends CaptchaControllerForm {
    private String pName;
    private String pPassword;
    private String pConfirmPassword;
    private String pCPhone;
    private String pRName;
    private String pCNumber;
    private String pMail;
    private boolean pAcceptRule;

    /**
     * @return the pName
     */
    public String getpName() {
        return pName;
    }

    /**
     * @param pName
     *            the pName to set
     */
    public void setpName(String pName) {
        this.pName = pName;
    }

    /**
     * @return the pPassword
     */
    public String getpPassword() {
        return pPassword;
    }

    /**
     * @param pPassword
     *            the pPassword to set
     */
    public void setpPassword(String pPassword) {
        this.pPassword = pPassword;
    }

    /**
     * @return the pConfirmPassword
     */
    public String getpConfirmPassword() {
        return pConfirmPassword;
    }

    /**
     * @param pConfirmPassword
     *            the pConfirmPassword to set
     */
    public void setpConfirmPassword(String pConfirmPassword) {
        this.pConfirmPassword = pConfirmPassword;
    }

    /**
     * @return the pCPhone
     */
    public String getpCPhone() {
        return pCPhone;
    }

    /**
     * @param pCPhone
     *            the pCPhone to set
     */
    public void setpCPhone(String pCPhone) {
        this.pCPhone = pCPhone;
    }

    /**
     * @return the pRName
     */
    public String getpRName() {
        return pRName;
    }

    /**
     * @param pRName
     *            the pRName to set
     */
    public void setpRName(String pRName) {
        this.pRName = pRName;
    }

    /**
     * @return the pCNumber
     */
    public String getpCNumber() {
        return pCNumber;
    }

    /**
     * @param pCNumber
     *            the pCNumber to set
     */
    public void setpCNumber(String pCNumber) {
        this.pCNumber = pCNumber;
    }

    /**
     * @return the pMail
     */
    public String getpMail() {
        return pMail;
    }

    /**
     * @param pMail
     *            the pMail to set
     */
    public void setpMail(String pMail) {
        this.pMail = pMail;
    }

    /**
     * @return the pAcceptRule
     */
    public boolean ispAcceptRule() {
        return pAcceptRule;
    }

    /**
     * @param pAcceptRule
     *            the pAcceptRule to set
     */
    public void setpAcceptRule(boolean pAcceptRule) {
        this.pAcceptRule = pAcceptRule;
    }

	@Override
    public String toString() {
        return "RegisterForm{" + "username='" + pName + '\'' + ", password='"
                + pPassword + '\'' + ", password2='" + pConfirmPassword + '\''
                + ", mobile='" + pCPhone + '\'' + ", realName='" + pRName
                + '\'' + ", idCardNo='" + pCNumber + '\'' + ", email='" + pMail
                + '\'' + ", termsAccepted=" + pAcceptRule + '}';
    }
}
