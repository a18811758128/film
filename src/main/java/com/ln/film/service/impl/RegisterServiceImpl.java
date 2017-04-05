package com.ln.film.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ln.film.dao.RoleMapper;
import com.ln.film.dao.UsersMapper;
import com.ln.film.exception.user.UserEmailDuplicatedException;
import com.ln.film.exception.user.UserMobileDuplicatedException;
import com.ln.film.exception.user.UsernameDuplicatedException;
import com.ln.film.model.Role;
import com.ln.film.model.RoleExample;
import com.ln.film.model.Users;
import com.ln.film.model.UsersExample;
import com.ln.film.service.RegisterService;
import com.ln.film.utils.MyTools;



/**
 * 
 */
@Service
public class RegisterServiceImpl implements RegisterService {
    private final Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UsersMapper userMapper;


    @Override
    public Users register(String username, String password, String mobile,
            String realName, String idCardNo, String email, String ip) {
        /*
         * ========= Duplication checking ===========
         */
        validateDuplication(username, email, mobile);

        /*
         * ========= save a new use ===========
         */
        Users user = new Users();
        RoleExample roleExample = new RoleExample();
        roleExample.createCriteria().andNameEqualTo("ROLE_USER");
        List<Role> roleList = roleMapper.selectByExample(roleExample);
        Role roleUser = roleList.get(0);
        user.setUsername(username);
        user.setPassword(MyTools.MD5(password));
        user.setUemail(email);
        user.setUphone(mobile);
        user.setRoleid(roleUser.getRoleid());

        logger.trace("Saving a new user for register:{}", user);
        userMapper.insert(user);
        logger.debug("user saving done, user id is:" + user.getUserid());
        // fetch user
        UsersExample userExample = new UsersExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        List<Users> users = userMapper.selectByExample(userExample);

        return users.isEmpty() ? null : users.get(0);
    }

    private void validateDuplication(String username, String email,
            String mobile) {
        logger.debug("validate duplicate for username:{}, email:{}, mobile:{}",
                new String[] { username, email, mobile });

        UsersExample userExample = new UsersExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        if (userMapper.countByExample(userExample) > 0) {
            logger.error("user name '" + username + "' duplicated!");
            throw new UsernameDuplicatedException();
        }
        UsersExample userExample2 = new UsersExample();
        userExample2.createCriteria().andUphoneEqualTo(username);
        if (userMapper.countByExample(userExample2) > 0) {
            logger.error("user name '" + username + "' duplicated!");
            throw new UsernameDuplicatedException();
        }
        UsersExample userExample3 = new UsersExample();
        userExample3.createCriteria().andUemailEqualTo(username);
        if (userMapper.countByExample(userExample3) > 0) {
            logger.error("user name '" + username + "' duplicated!");
            throw new UsernameDuplicatedException();
        }
        // email
        if (StringUtils.hasText(email)) {
            userExample = new UsersExample();
            UsersExample.Criteria criteria = userExample.createCriteria();
            criteria.andUemailEqualTo(email);
            if (userMapper.countByExample(userExample) > 0) {
                logger.error("user email '" + email + "' duplicated!");
                throw new UserEmailDuplicatedException();
            }
        }

        // mobile
        if (StringUtils.hasText(mobile)) {
            userExample = new UsersExample();
            UsersExample.Criteria criteria = userExample.createCriteria();
            criteria.andUphoneEqualTo(mobile);
            // currently do not allow duplication mobile number,
            // no matter whether it's activated or not
//            criteria.andMobileActivatedEqualTo(true);
            if (userMapper.countByExample(userExample) > 0) {
                logger.error("user mobile '" + mobile + "' duplicated!");
                throw new UserMobileDuplicatedException();
            }
        }

        logger.debug("validate duplicate done.");
    }
}
