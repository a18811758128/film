package com.ln.film.service;

import com.ln.film.model.Users;

/**
 * 
 */
public interface RegisterService {
    Users register(String username, String password, String mobile,
            String realName, String idCardNo, String email, String ip);

}
