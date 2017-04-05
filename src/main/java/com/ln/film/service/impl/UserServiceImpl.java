package com.ln.film.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ln.film.dao.RoleMapper;
import com.ln.film.dao.UsersMapper;
import com.ln.film.model.AjaxResult;
import com.ln.film.model.Role;
import com.ln.film.model.RoleExample;
import com.ln.film.model.Users;
import com.ln.film.model.UsersExample;
import com.ln.film.service.UserService;


/**
 * 
 */
@Service
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Value("#{environment['server.baseurl']}")
    public String SERVER_BASEURL = "localhost";

    @Value("#{environment['email.aeskey']}")
    public String AES_KEY = "Hi,DongKingKong.";

    @Autowired
    private UsersMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Users findUser(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public Users findByUsername(String username) {
        UsersExample example = new UsersExample();

        UsersExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<Users> result = userMapper.selectByExample(example);

        return result.size() > 0 ? result.get(0) : null;
    }

    @Override
    public Role getUserRole(Users user) {
        RoleExample example=new RoleExample();
        RoleExample.Criteria criteria=example.createCriteria();
        criteria.andRoleidEqualTo(user.getRoleid());
		return roleMapper.selectByExample(example).get(0);
    }

    @Override
    public Role getUserRole(int userId) {
        return getUserRole(findUser(userId));
    }

    @Override
    public void saveUser(Users user) {
        if (user.getUserid() == null || user.getUserid() == 0) {
            userMapper.insert(user);
        } else {
            userMapper.updateByPrimaryKey(user);
        }
    }

    @Override
    public void removeUser(int id) {
        int count = userMapper.deleteByPrimaryKey(id);

        logger.debug("Remove user by id:{}, result:{}", id, count);
    }

    @Override
    public void removeByUsername(String username) {
        UsersExample example = new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        int count = userMapper.deleteByExample(example);

        logger.debug("Remove user by username:{}, result:{}", username, count);
    }

    @Override
    public Users findByIdCardNo(String idCardNo) {
        UsersExample example = new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();
        criteria.andUidcardEqualTo(idCardNo);
        List<Users> list = userMapper.selectByExample(example);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public Users findByMobile(String mobile, Boolean isActivated) {
        UsersExample example = new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();
        criteria.andUphoneEqualTo(mobile);
        List<Users> list = userMapper.selectByExample(example);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public Users findByEmail(String email, Boolean isActivated) {
        UsersExample example = new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();
        criteria.andUemailEqualTo(email);
        List<Users> list = userMapper.selectByExample(example);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public String getVerifyUrl(Users user) throws Exception {
//        logger.info("get verify email url for user:" + user.getId());
//        String verifyCode = UUID.randomUUID().toString();
//        user.setEmailVerifyCode(verifyCode);
//        userMapper.updateByPrimaryKey(user);
//        String text = "uid=" + user.getId() + "&verifyCode=" + verifyCode
//                + "&time=" + System.currentTimeMillis();
//        String cipher = AESUtils.Encrypt(text, AES_KEY);
//        String url = "http://" + SERVER_BASEURL + "/email/verify?text="
//                + cipher;
//        return url;
    	return null;
    }

    @Override
    public AjaxResult verifyEmail(String cipher) {
		return null;
//        try {
//            logger.info("verify email with cipher:" + cipher);
//            String text = AESUtils.Decrypt(cipher, AES_KEY);
//            if (StringUtils.isEmpty(text)) {
//                return new AjaxResult(AjaxResult.FAIL, "激活码错误");
//            }
//            String[] params = text.split("&");
//            logger.info("decoded text is:" + text + ", params length:"
//                    + params.length);
//            if (params.length < 3) {
//                return new AjaxResult(AjaxResult.FAIL, "激活码格式错误");
//            }
//            String uidStr = params[0].substring(params[0].indexOf('=') + 1);
//            String verifyCode = params[1].substring(params[1].indexOf('=') + 1);
//            String timeStr = params[2].substring(params[2].indexOf('=') + 1);
//            logger.info("uidStr:" + uidStr + ", verifyCode:" + verifyCode
//                    + ", timeStr:" + timeStr);
//            Integer uid = Integer.parseInt(uidStr);
//            User u = userMapper.selectByPrimaryKey(uid);
//            if (u == null) {
//                logger.info("verify email fail, cannot find user for uid:"
//                        + uid);
//                return new AjaxResult(AjaxResult.FAIL, "找不到用户");
//            }
//            if (u.getEmailActivated() != null && u.getEmailActivated()) {
//                return new AjaxResult(AjaxResult.SUCCESS, "你的邮件地址'" + u.getEmail()
//                        + "'之前已激活成功, 不必重复激活");
//            }
//            long time = Long.parseLong(timeStr);
//            long curTime = System.currentTimeMillis();
//            logger.info("verify code time:" + time + ", current time:"
//                    + curTime);
//            if (curTime - time > SharedConstants.MILS_ONE_DAY * 3) {
//                return new AjaxResult(AjaxResult.FAIL, "激活码已失效");
//            }
//            if (u.getEmailVerifyCode().equals(verifyCode)) {
//                u.setEmailActivated(true);
//                userMapper.updateByPrimaryKey(u);
//                return new AjaxResult(AjaxResult.SUCCESS, "激活成功");
//            } else {
//                return new AjaxResult(AjaxResult.SUCCESS, "激活码不正确");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new AjaxResult(AjaxResult.FAIL, "系统错误："
//                    + e.getLocalizedMessage());
//        }
    }

	@Override
	public List<Users> getUserList() {
		UsersExample example=new UsersExample();
		return userMapper.selectByExample(example);
	}

    

}
