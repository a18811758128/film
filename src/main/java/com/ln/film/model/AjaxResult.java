package com.ln.film.model;

import java.io.Serializable;

/**
 
 */

public class AjaxResult implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final int SUCCESS = 200;
    public static final int INPUT_ERROR = -1;
    public static final int FAIL = -2;
    public static final int AUTHENTICATION_ERROR = 403;
    public static final int SYSTEM_ERROR = 500;
    private int code;
    private String message;
    private Object data;

    public AjaxResult(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public AjaxResult(int code) {
        this(code, "success", null);
    }

    public AjaxResult(int code, String message) {
        this(code, message, null);
    }

    public AjaxResult(Object data) {
        this(SUCCESS, null, data);
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
