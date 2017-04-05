package com.ln.film.service;

import java.util.List;

import com.ln.film.model.Role;
import com.ln.film.model.Users;


public interface UserManageService {

	List<Users> getUserByLevel(Integer roleid);

	boolean deleteUser(Integer userid);

	boolean freezeUser(Integer userid);

	boolean unfreezeUser(Integer userid);

	Users getUserById(Integer userid);

	boolean addUser(String username, String password, Integer status, Integer role, String realname, String mobile,
			String email, String idCardNo);

	List<Role> getRoleById(Integer roleid);

	List<Role> getRole();

	boolean updateRole(Integer roleid, Integer userid);

	boolean updateUser(Integer userid, String username, String password, Integer status, String email, String mobile,
			String gongsi, Integer role, String address, String qq, String realname, Integer vendorId, String idCardNo,
			Integer usernameChangeTimes, Integer province, Integer city, Integer area);


}
