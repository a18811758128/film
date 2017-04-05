package com.ln.film.utils;


import javax.servlet.http.HttpSession;

import com.ln.film.model.Role;
import com.ln.film.model.Users;

/**
 * 
 */
public final class AuthenticationHelper {

    public static boolean isAuthenticated(HttpSession session) {
        return getAuthentication(session) == null;
    }

    public static Users getAuthentication(HttpSession session) {
        return (Users) session.getAttribute(SharedConstants.SESSION_USER_KEY);
    }

    public static void putAuthentication(HttpSession session, Users user) {
        session.setAttribute(SharedConstants.SESSION_HASLOGIN_KEY, true);
        session.setAttribute(SharedConstants.SESSION_USER_KEY, user);
    }

    public static void putAuthenticatedUserRole(HttpSession session, Role role) {
        session.setAttribute(SharedConstants.SESSION_ROLE_KEY, role);
    }

    public static Role getAuthenticatedUserRole(HttpSession session) {
        return (Role) session.getAttribute(SharedConstants.SESSION_ROLE_KEY);
    }

    public static void removeAuthentication(HttpSession session) {
        session.removeAttribute(SharedConstants.SESSION_USER_KEY);
        session.removeAttribute(SharedConstants.SESSION_ROLE_KEY);
        session.removeAttribute(SharedConstants.SESSION_HASLOGIN_KEY);
    }

}
