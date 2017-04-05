package com.ln.film;

import java.util.regex.Pattern;

/**
 * Constant class for regex.
 * 
 */
public class RegConstants {
    public static final String REGEX_USERNAME = "^[a-zA-Z][a-zA-Z0-9_]{4,15}$";
    public static final Pattern PATTERN__USERNAME = Pattern.compile(REGEX_USERNAME);
    public static final String REGEX_ID_CARD_NO = "^(\\d{15}$|^\\d{18}$|^\\d{17}(\\d|X|x))$";
    public static final Pattern PATTERN_ID_CARD_NO = Pattern.compile(REGEX_ID_CARD_NO);
    public static final String REGEX_EMAIL = "^([a-zA-Z0-9]+[_|\\-|\\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\\-|\\.]?)*[a-zA-Z0-9]+\\.[a-zA-Z]{2,3}$";
    public static final Pattern PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    public static final String REGEX_MOBILE_PHONE = "^((1[3,5,8][0-9])|(14[5,7])|(17[0,1,6,7,8]))\\d{8}$";
    public static final Pattern PATTERN_MOBILE_PHONE = Pattern.compile(REGEX_MOBILE_PHONE);
}
