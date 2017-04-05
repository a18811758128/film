package com.ln.film.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ln.film.annotation.Login;
import com.ln.film.model.AjaxResult;
import com.ln.film.model.Filmcomment;
import com.ln.film.model.Users;
import com.ln.film.service.FilmCommentService;

@Controller
@RequestMapping(value="filmcomment")
@Login
public class FilmCommentController extends AbstractController {
	@Autowired
	private FilmCommentService filmCommentService;
	
	@RequestMapping(value="fb",method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult fbcomment(HttpSession session,
			@RequestBody Filmcomment filmcomment,
            BindingResult result){
		if (session == null || null == session.getAttribute("hasLogin")
                || session.getAttribute("user") == null) {
            logger.info("没有登录, 重定向至登陆页");
            return new AjaxResult(AjaxResult.FAIL, "login");
        }
		logger.info("添加评论");
		Users user=(Users) session.getAttribute("user");
		AjaxResult ajaxResult = new AjaxResult(AjaxResult.FAIL);
		filmcomment.setCtime(new Date());
		filmcomment.setUserid(user.getUserid());
		filmCommentService.addComment(filmcomment);
		ajaxResult.setCode(AjaxResult.SUCCESS);
		return ajaxResult;
	}
}
