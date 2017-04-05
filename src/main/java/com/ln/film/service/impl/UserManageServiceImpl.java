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
import com.ln.film.service.UserManageService;
import com.ln.film.utils.MyTools;


@Service
public class UserManageServiceImpl implements UserManageService {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
    UsersMapper userMapper;
	
	
	@Autowired
    private RoleMapper roleMapper;
	//查询所有低权限的用户
	@Override
	public List<Users> getUserByLevel(Integer roleid) {
		UsersExample example=new UsersExample();
		UsersExample.Criteria criteria=example.createCriteria();
		criteria.andRoleidLessThanOrEqualTo(roleid);
		example.setOrderByClause("userid DESC");
		return userMapper.selectByExample(example);
	}

	@Override
	public boolean deleteUser(Integer userid) {
		int deleteByPrimaryKey = userMapper.deleteByPrimaryKey(userid);
		if(deleteByPrimaryKey>0){
			
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	public boolean freezeUser(Integer userid) {
		Users user=new Users();
		user.setUserid(userid);
		int updateByPrimaryKeySelective = userMapper.updateByPrimaryKeySelective(user);
		if(updateByPrimaryKeySelective>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean unfreezeUser(Integer userid) {
		Users user=new Users();
		user.setUserid(userid);
		int updateByPrimaryKeySelective = userMapper.updateByPrimaryKeySelective(user);
		if(updateByPrimaryKeySelective>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Users getUserById(Integer userid) {
		UsersExample example=new UsersExample();
		UsersExample.Criteria criteria=example.createCriteria();
		criteria.andUseridEqualTo(userid);
		List<Users> selectByExample = userMapper.selectByExample(example);
		if(selectByExample!=null&&selectByExample.size()>0){
			Users user=selectByExample.get(0);
			return user;
		}else{
			return null;
		}
	}

	@Override
	public boolean addUser(String username, String password, Integer status, Integer role, String realname,
			String mobile, String email, String idCardNo) {
		validateDuplication(username, email, mobile);

        /*
         * ========= save a new use ===========
         */
        Users user = new Users();
        RoleExample roleExample = new RoleExample();
        roleExample.createCriteria().andRoleidEqualTo(role);
        List<Role> roleList = roleMapper.selectByExample(roleExample);
        Role roleUser = roleList.get(0);

        user.setUsername(username);
        user.setPassword(MyTools.MD5(password));
        user.setUemail(email);
        // user.setCompany();
        user.setUphone(mobile);
        user.setRoleid(roleUser.getRoleid());
        user.setUrealname(realname);
        user.setUidcard(idCardNo);
        logger.trace("Saving a new user for register:{}", user);
        int insert = userMapper.insert(user);

        logger.debug("user saving done, user id is:" + user.getUserid());
        if(insert>0){
        	return true;
        }else{
        	return false;
        }
	}
	
	private void validateDuplication(String username, String email,
            String mobile) {
        // username
        logger.debug("validate duplicate for username:{}, email:{}, mobile:{}",
                new String[] { username, email, mobile });

        UsersExample userExample = new UsersExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        if (userMapper.countByExample(userExample) > 0) {
            throw new UsernameDuplicatedException();
        }

        // email
        if (StringUtils.hasText(email)) {
            userExample = new UsersExample();
            UsersExample.Criteria criteria = userExample.createCriteria();
            criteria.andUemailEqualTo(email);
            if (userMapper.countByExample(userExample) > 0) {
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
                throw new UserMobileDuplicatedException();
            }
        }

        logger.debug("validate duplicate done.");
    }

	@Override
	public List<Role> getRoleById(Integer roleid) {
		logger.info("id:"+roleid);
		RoleExample example=new RoleExample();
		RoleExample.Criteria criteria=example.createCriteria();
		criteria.andRoleidEqualTo(roleid);
		List<Role> selectByExample = roleMapper.selectByExample(example);
		logger.debug(selectByExample.toString());
		return selectByExample;
				
	}

	@Override
	public List<Role> getRole() {
		// TODO Auto-generated method stub
		RoleExample example=new RoleExample();
		return roleMapper.selectByExample(example);
	}

	@Override
	public boolean updateRole(Integer roleid,Integer userid) {
		Users user=new Users();
		user.setRoleid(roleid);
		user.setUserid(userid);
		int updateByPrimaryKeySelective = userMapper.updateByPrimaryKeySelective(user);
		logger.debug(""+updateByPrimaryKeySelective);
		if(updateByPrimaryKeySelective>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateUser(Integer userid, String username, String password, Integer status, String email,
			String mobile, String gongsi, Integer role, String address, String qq, String realname, Integer vendorId,
			String idCardNo, Integer usernameChangeTimes, Integer province, Integer city, Integer area) {
		UsersExample example=new UsersExample();
		UsersExample.Criteria criteria=example.createCriteria();
		criteria.andUseridEqualTo(userid);
		Users user=new Users();
		user.setUserid(userid);
		user.setPassword(MyTools.MD5(password));
		user.setUsername(username);
		user.setUemail(email);
		user.setUphone(mobile);
		user.setRoleid(role);
		user.setUqq(qq);
		user.setUrealname(realname);
		user.setUidcard(idCardNo);
		int updateByExampleSelective = userMapper.updateByExampleSelective(user, example);
		if(updateByExampleSelective>0){
			return true;
		}else{
			return false;
		}
	}
}
