/**
 * 
 */
package com.ln.film.service;

import com.ln.film.model.Users;


/**
 * 
 *
 */
public interface EmailService {

	public void sendResetEmail(Users user);
}
