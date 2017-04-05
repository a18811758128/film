package com.ln.film.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ln.film.dao.UsersMapper;
import com.ln.film.exception.authentication.BadCredentialException;
import com.ln.film.exception.user.UserNotFoundException;
import com.ln.film.model.Users;
import com.ln.film.model.UsersExample;
import com.ln.film.service.EmailService;
import com.ln.film.service.PasswordService;
import com.ln.film.utils.MyTools;

/**
 * 
 */
@Service
public class PasswordServiceImpl implements PasswordService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public static final String RESET_PASSWORD_STRING = "pwd_reset_string";

    @Autowired
    private UsersMapper userMapper;


    @Autowired
    private EmailService emailService;

//    @Autowired
//    private CacheService cacheUtils;

    @Override
    public void update(Users user, String oldPassword, String password)
            throws BadCredentialException {
        logger.info("update password for user:" + user);
        if (!user.getPassword().equals(MyTools.MD5(oldPassword))) {
            throw new BadCredentialException();
        }
        user.setPassword(MyTools.MD5(password));
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public Users reset(String email, String ip) {
        logger.info("reset password for email:" + email);
        UsersExample userExample = new UsersExample();
        userExample.createCriteria().andUemailEqualTo(email);
        List<Users> emailUserList = userMapper.selectByExample(userExample);
        Users user = emailUserList.isEmpty() ? null : emailUserList.get(0);

        if (user == null) {
            throw new UserNotFoundException();
        }
        // save new password
        emailService.sendResetEmail(user);
        return user;
    }

}
