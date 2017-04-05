package com.ln.film.service;

import java.util.List;

import com.ln.film.model.AjaxResult;
import com.ln.film.model.Role;
import com.ln.film.model.Users;

public interface UserService {
    Users findUser(int id);

    Users findByUsername(String username);

    Role getUserRole(Users user);

    Role getUserRole(int userId);

    void saveUser(Users user);

    void removeUser(int id);

    void removeByUsername(String username);

    /**
     * 根据身份证号查找用户
     *
     * @param idCardNo
     * @return
     */
    Users findByIdCardNo(String idCardNo);

    /**
     * 根据手机号查找用户
     *
     * @param mobile
     * @param isActivated
     *            : false: in-activated, true: activated, NULL: both
     * @return
     */
    Users findByMobile(String mobile, Boolean isActivated);

    /**
     * 根据邮箱地址查找用户
     *
     * @param email
     *            : email of the user
     * @param isActivated
     *            : false: in-activated, true: activated, NULL: both
     * @return
     */
    Users findByEmail(String email, Boolean isActivated);

    public String getVerifyUrl(Users user) throws Exception;

    public AjaxResult verifyEmail(String cipher);

	List<Users> getUserList();
}
