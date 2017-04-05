/**
 * 
 */
package com.ln.film.model.transients;

/**
 * 
 *
 */
public class AccessLevel {

    public static final int ANONYMOUS = 0;

    public static final int USER = 1;

    public static final int ADMIN_GENERAL = 4096;

    public static final int DEVELOPER = 16384;

    public static final int SUPERVISOR = 32768;
}
