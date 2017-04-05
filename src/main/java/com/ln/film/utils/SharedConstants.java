/**
 * 
 */
package com.ln.film.utils;

/**
 * 
 *
 */
public class SharedConstants {
    /**
     * cookie for user auto-login
     */
    public static final String USER_COOKIE_KEY = MyTools.MD5("UserCookie");
    /**
     * cookie expire time, in seconds
     */
    public static final int COOKIE_EXPIRE_TIME = 3600;

    public static final String SESSION_HASLOGIN_KEY = "hasLogin";

    public static final String SESSION_USER_KEY = "user";

    public static final String SESSION_ROLE_KEY = "role";

    public static final int DEFAULT_DOWNLOAD_TIMES_LIMIT = 30;

    public static final String EMAIL_TASK_VERIFY = "VERIFY";

    public static final String EMAIL_TASK_RESET_PWD = "RESET_PWD";

    public static final long MILS_ONE_DAY = 1000L * 3600 * 24;

    public static final String PERSONAL_MEDIA_TAG = "Personal";

    public static final String TIMESTAMP_PARAM_NAME = "ts";

    public static final int TIMESTAMP_TORLERRANCE = 1000 * 60 * 5; // 5 minutes

    public static final String ERROR_SIGN_TIMESTAMP_EMPTY = "请求时间戳为空，请重试";

    public static final String ERROR_SIGN_CLIENT_NOT_FOUND = "client not found";

    public static final String ERROR_SIGN_TIMESTAMP_EXPIRED = "本机时间错误，请先调整时间";
}
