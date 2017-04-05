package com.ln.film.service;

import com.ln.film.exception.authentication.BadCredentialException;
import com.ln.film.model.Users;

/**
 * service for user to manage his password
 * 
 */
public interface PasswordService {
    void update(Users user, String oldPassword, String password) throws BadCredentialException;

    Users reset(String email, String ip);
}
