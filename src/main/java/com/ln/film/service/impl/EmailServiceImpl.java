/**
 * 
 */
package com.ln.film.service.impl;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ln.film.model.Users;
import com.ln.film.service.EmailService;
import com.ln.film.service.UserService;
import com.ln.film.utils.EmailUtils;
import com.ln.film.utils.MyTools;



/**
 * 
 *
 */
@Service
public class EmailServiceImpl implements EmailService {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	private static final String[] RANDOM_PASSWORD_CHARS = new String[] { "a",
            "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
            "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0",
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D",
            "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
            "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
    private static final int RANDOM_PASSWORD_LEN = 8;
    
    @Autowired
    private EmailUtils emailUtils;
    
    @Autowired
    private UserService userService;
    
	@Override
	public void sendResetEmail(Users user) {
		// TODO Auto-generated method stub
		String password = randomPassword();
        String emailContent = "你的帐号 " + user.getUsername() + " 密码已被重置为:"
                + password;
        boolean result = false;
        result = emailUtils.sendEmail("密码已重置", emailContent, user.getUemail());
        logger.info("send email result:" + result);
        if (result) {
            user.setPassword(MyTools.MD5(password));
            userService.saveUser(user);
        }
		
	}
	
	 private String randomPassword() {
	        StringBuffer shortBuffer = new StringBuffer();
	        String uuid = UUID.randomUUID().toString().replace("-", "");
	        for (int i = 0; i < RANDOM_PASSWORD_LEN; i++) {
	            String str = uuid.substring(i * 4, i * 4 + 4);
	            int x = Integer.parseInt(str, 16);
	            shortBuffer.append(RANDOM_PASSWORD_CHARS[x % 0x3E]);
	        }
	        return shortBuffer.toString();

	    }

}
