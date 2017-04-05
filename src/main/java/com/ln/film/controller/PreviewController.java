package com.ln.film.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ln.film.model.Area;
import com.ln.film.model.Film;
import com.ln.film.model.Filmcomment;
import com.ln.film.model.Sort;
import com.ln.film.model.Users;
import com.ln.film.service.FilmCommentService;
import com.ln.film.service.FilmsService;
import com.ln.film.service.UserService;

@Controller
@RequestMapping(value="preview")
public class PreviewController extends AbstractController {

	private static final Logger logger = LoggerFactory.getLogger(FilmController.class);
	
	@Autowired
	private FilmsService filmsService;
	
	@Autowired
	private FilmCommentService filmCommentService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="showfilm",method=RequestMethod.GET)
	public String showFilm(ModelMap model,HttpServletRequest request,Integer fid){
		logger.info("预览视频");
		Film film=filmsService.getFilmById(fid);
		List<Area> areaList = filmsService.getAreaList();
		List<Sort> sortList = filmsService.getSortList();
		List<Filmcomment> filmcommentList= filmCommentService.getFilmcommentListByFid(fid);
		List<Users> userList=userService.getUserList();
	    model.put("areaList", areaList);
	    model.put("sortList", sortList);
		model.put("film", film);
		model.put("filmcommentList", filmcommentList);
		model.put("userList", userList);
		return "preview";
	}
}
