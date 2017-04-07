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

	public void sendReturnEmail(Users user);
}
