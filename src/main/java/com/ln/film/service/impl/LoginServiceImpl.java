package com.ln.film.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ln.film.RegConstants;
import com.ln.film.dao.UsersMapper;
import com.ln.film.exception.authentication.AuthenticationException;
import com.ln.film.exception.authentication.BadCredentialException;
import com.ln.film.model.Users;
import com.ln.film.model.UsersExample;
import com.ln.film.service.LoginService;
import com.ln.film.utils.MyTools;


/**
 * 
 */
@Service
public class LoginServiceImpl implements LoginService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UsersMapper userMapper;

//    @Autowired
//    private CookieUtils cookieUtils;

    @Override
    public Users login(String username, String password, String ip)
            throws AuthenticationException {
        logger.debug("login with username:" + username + ", password:"
                + password + " from ip:" + ip);
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new BadCredentialException();
        }

        Users user = null;

        // find user
        UsersExample example = new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();
        if (RegConstants.PATTERN_EMAIL.matcher(username).matches()) {
            // find user by email
            criteria.andUemailEqualTo(username);
            List<Users> result = userMapper.selectByExample(example);
            user = result.size() > 0 ? result.get(0) : null;
        } else if (RegConstants.PATTERN_MOBILE_PHONE.matcher(username)
                .matches()) {
            // find user by mobile
            criteria.andUphoneEqualTo(username);
            List<Users> result = userMapper.selectByExample(example);
            user = result.size() > 0 ? result.get(0) : null;
        } else {
            // find by username
            criteria.andUsernameEqualTo(username);
            List<Users> result = userMapper.selectByExample(example);
            user = result.size() > 0 ? result.get(0) : null;
        }

        // match password
        if (user == null
                || !MyTools.MD5(password).equals(user.getPassword())) {
            throw new BadCredentialException();
        }
        return user;
    }

	@Override
	public Users loginByCookie(String userCookie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveLoginCookie(HttpServletResponse response, Users user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeLoginCookie(HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

//    @Override
//    public Users loginByCookie(String userCookie) {
//        logger.info("login by cookie, user cookie is:" + userCookie);
//        String[] userIdName = CipherHelper.decrypt(userCookie).split("-");
//        if (userIdName == null || userIdName.length < 2) {
//            logger.info("login by cookie fail, userIdName is:" + userIdName);
//            return null;
//        }
//        try {
//            String userIdStr = userIdName[0];
//            String userName = userIdName[1];
//            logger.info("login by cookie, user:" + userName + ", id:"
//                    + userIdStr);
//            int userId = Integer.parseInt(userIdStr);
//            User realUser = userMapper.selectByPrimaryKey(userId);
//            if (userName.equals(realUser.getUsername())) {
//                return realUser;
//            } else {
//                logger.info("login by cookie fail, real user name is:"
//                        + realUser.getUsername());
//                return null;
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return null;
//        }
//    }

//    @Override
//    public void saveLoginCookie(HttpServletResponse response, User user) {
//        try {
//            String cookie = CipherHelper.encrypt(user.getId() + "-" + user.getUsername());
//            cookieUtils.setCookie(response,
//                    SharedConstants.USER_COOKIE_KEY, cookie,
//                    SharedConstants.COOKIE_EXPIRE_TIME);
//        } catch (Exception ex) {
//            logger.error("Save user cookie failed, error is:" + ex.getMessage());
//        }
//    }

//    @Override
//    public void removeLoginCookie(HttpServletResponse response) {
//        try {
//            cookieUtils.removeCookie(response, SharedConstants.USER_COOKIE_KEY);
//        } catch (Exception ex) {
//            logger.error("Save user cookie failed, error is:" + ex.getMessage());
//        }
//    }
}
