package com.ln.film.service;

import javax.servlet.http.HttpServletResponse;

import com.ln.film.exception.authentication.AuthenticationException;
import com.ln.film.model.Users;


/**
 * service for login operations
 * 
 */
public interface LoginService {
    Users login(String username, String password, String ip) throws AuthenticationException;

    Users loginByCookie(String userCookie);

    void saveLoginCookie(HttpServletResponse response, Users user);

    void removeLoginCookie(HttpServletResponse response);
}
