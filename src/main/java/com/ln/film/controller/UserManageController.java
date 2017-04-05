package com.ln.film.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ln.film.annotation.Login;
import com.ln.film.exception.user.UserEmailDuplicatedException;
import com.ln.film.exception.user.UserMobileDuplicatedException;
import com.ln.film.exception.user.UsernameDuplicatedException;
import com.ln.film.form.AddUserForm;
import com.ln.film.form.UpdateForm;
import com.ln.film.model.Role;
import com.ln.film.model.Users;
import com.ln.film.model.transients.AccessLevel;
import com.ln.film.service.UserManageService;


@Controller
@RequestMapping(value = "/usermanage")
@Login(level=AccessLevel.ADMIN_GENERAL)
public class UserManageController extends AbstractController {
	private static final Logger logger = LoggerFactory.getLogger(UserManageController.class);

	@Autowired
	private UserManageService userManageService;
	
	@RequestMapping(value = "/showmanage")
	public String showUsermanage(ModelMap model, HttpSession session, @RequestParam(required = false) String status) {
		if (session == null || null == session.getAttribute("hasLogin") || session.getAttribute("user") == null) {
			logger.info("没有登录, 重定向至登陆页");
			return "redirect:/login";
		}
	    logger.info("跳转管理员页面");
		return "usermanage/usermanage";
	}
	@RequestMapping(value = "/list")
	public String show(ModelMap model, HttpSession session, @RequestParam(required = false) String status) {
		if (session == null || null == session.getAttribute("hasLogin") || session.getAttribute("user") == null) {
			logger.info("没有登录, 重定向至登陆页");
			return "redirect:/login";
		}
		logger.info("显示所有用户");
		Role role = (Role) session.getAttribute("role");
		List<Users> userList = userManageService.getUserByLevel(role.getRoleid());
		Users user=(Users) session.getAttribute("user");
		model.put("userList", userList);
		model.put("me", user);
		return "/usermanage/usermanage-list";
	}

	@RequestMapping(value = "delete", method = { RequestMethod.GET })
	public String delete(ModelMap model, HttpSession session, @RequestParam(required = false) String status,
			Integer userid) {
		logger.info("删除用户");
		boolean flag = false;
		flag = userManageService.deleteUser(userid);
		if (!flag) {
			// 前台弹窗提示
		}
		return "forward:/usermanage/list";
	}

	@RequestMapping(value = "freeze", method = { RequestMethod.GET })
	public String freeze(ModelMap model, HttpSession session, @RequestParam(required = false) Integer status,
			Integer userid) {
		logger.info("冻结或解冻用户");
		if (status == 0) {
			userManageService.freezeUser(userid);
		} else {
			userManageService.unfreezeUser(userid);
		}
		return "forward:/usermanage/list";
	}

	@RequestMapping(value = "update", method = { RequestMethod.GET })
	public String update(ModelMap model, HttpSession session, Integer userid,
			@RequestParam(required = false) Integer ur) {
		logger.info("跳转修改用户");
		Users userUpdate = userManageService.getUserById(userid);
		if (userUpdate != null) {
//			session.setAttribute("useridUpdate", userid);
			model.put("userUpdate", userUpdate);
		} else {
			logger.error("无法修改用户");
		}
		if (ur != null && ur == 1) {
			List<Role> roleList = userManageService.getRole();
			model.put("roleList", roleList);
			return "usermanage/usermanage-update-role";
		} else {
			return "usermanage/usermanage-update";
		}

	}

	@RequestMapping(value = "updateUser/{userid}", method = RequestMethod.POST)
	public String updateUser(ModelMap model, HttpServletRequest request, HttpSession session,
			@ModelAttribute(FORM_ATTR_NAME) UpdateForm form,@PathVariable("userid") Integer userid) {
		logger.info("修改用户");
		boolean flag = false;
		System.out.println(form.getProvince());
		flag = userManageService.updateUser(userid, form.getUsername(),
				form.getPassword(), form.getStatus(), form.getEmail(), form.getMobile(), form.getGongsi(),
				form.getRole(), form.getAddress(), form.getQq(), form.getRealname(), form.getVendorId(),
				form.getIdCardNo(), form.getUsernameChangeTimes(),form.getProvince(),form.getCity(),form.getArea());
		if (flag) {
			return "forward:/usermanage/list";
		} else {
			logger.error("修改失败");
			return "forward:/usermanage/list";
		}
	}

	@RequestMapping(value = "add")
	public String add(ModelMap model, HttpSession session, HttpServletRequest request) {
		logger.info("跳转添加用户");
		List<Role> roleList = userManageService.getRole();
		model.put("roleList", roleList);
		return "usermanage/usermanage-add";
	}

	@RequestMapping(value = "addUser", method = RequestMethod.POST)
	public String addUser(ModelMap model, HttpServletRequest request, HttpSession session,
			@ModelAttribute(FORM_ATTR_NAME) AddUserForm form) {
		logger.info("添加用户");
		boolean flag = false;
		try {
			flag = userManageService.addUser(form.getUsername(), form.getPassword(), form.getStatus(), form.getRole(),
					form.getRealname(), form.getMobile(), form.getEmail(), form.getIdCardNo());

		} catch (UsernameDuplicatedException e) {
			logger.warn("Failed to register.", e);
			model.put("error", "用户已存在");
			return "forward:/usermanage/list";
		} catch (UserEmailDuplicatedException e) {
			model.put("error", "邮箱填写错误");
			return "forward:/usermanage/list";
		} catch (UserMobileDuplicatedException e) {
			model.put("error", "手机填写错误");
			return "forward:/usermanage/list";
		}
		if (flag) {
			return "forward:/usermanage/list";
		} else {
			logger.error("添加失败");
			model.put("error", "添加失败");
			return "forward:/usermanage/list";
		}
	}

	@RequestMapping(value = "/role")
	public String role(ModelMap model, HttpSession session, @RequestParam(required = false) String status) {
		if (session == null || null == session.getAttribute("hasLogin") || session.getAttribute("user") == null) {
			logger.info("没有登录, 重定向至登陆页");
			return "redirect:/login";
		}
		logger.info("显示所有用户");
		Role role = (Role) session.getAttribute("role");
		List<Users> userList = userManageService.getUserByLevel(role.getRoleid());
		List<Role> roleList=userManageService.getRole();
		model.put("userList", userList);
		model.put("roleList", roleList);
		return "/usermanage/usermanage-role";
	}
	
	@RequestMapping(value = "/updateRole/{userid}")
	public String updateRole(ModelMap model, HttpSession session,@RequestParam Integer roleid,
			@PathVariable("userid") Integer userid) {
		if (session == null || null == session.getAttribute("hasLogin") || session.getAttribute("user") == null) {
			logger.info("没有登录, 重定向至登陆页");
			return "redirect:/login";
		}
		logger.info("修改用户权限");
		userManageService.updateRole(roleid,userid);
		return "forward:/usermanage/list";
	}
//	@RequestMapping(value = "/getRoleById", method = RequestMethod.GET)
//	public @ResponseBody List<Role> getroleById(ModelMap model, HttpSession session, @RequestParam Integer roleid) {
//		logger.info("获取权限");
//		List<Role> role = userManageService.getRoleById(roleid);
//		if(role!=null&&role.size()>0){
//			return role;
//		}else{
//			return null;
//		}
//	}
//	
//	@RequestMapping(value = "/getrole", method = RequestMethod.GET)
//	public @ResponseBody List<Role> getrole(ModelMap model, HttpSession session) {
//		logger.info("获取权限");
//		List<Role> role = userManageService.getRole();
//		if(role!=null&&role.size()>0){
//			return role;
//		}else{
//			return null;
//		}
//	}
}
