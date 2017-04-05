package com.ln.film.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.ln.film.annotation.Login;
import com.ln.film.exception.TimetableDuplicatedException;
import com.ln.film.form.AddTimetableForm;
import com.ln.film.form.UpdateFilmForm;
import com.ln.film.model.Film;
import com.ln.film.model.Hall;
import com.ln.film.model.Timetable;
import com.ln.film.model.transients.AccessLevel;
import com.ln.film.service.FilmsService;
import com.ln.film.service.TimetableService;

@Controller
@RequestMapping(value="timetable")
@Login(level=AccessLevel.ADMIN_GENERAL)
public class TimetableController extends AbstractController{
	private static final Logger logger = LoggerFactory.getLogger(FilmController.class);
	
	@Autowired
	private TimetableService timetableService;
	
	@Autowired
	private FilmsService filmsService;
	
	@RequestMapping(value="list")
	public String timetableList(ModelMap model, HttpSession session){
		if (session == null || null == session.getAttribute("hasLogin") || session.getAttribute("user") == null) {
			logger.info("没有登录, 重定向至登陆页");
			return "redirect:/login";
		}
		logger.info("显示场次安排信息");
		List<Timetable> timetableList=timetableService.getTimetableList();
		List<Film> filmList = filmsService.getFilmList();
		List<Hall> hallList = filmsService.getHallList();
		model.put("filmList", filmList);
		model.put("hallList", hallList);
		model.addAttribute("timetableList", timetableList);
		return "timetable/timetablelist";
	}
	
	@RequestMapping(value="add")
	public String timetableAll(ModelMap model, HttpSession session,@ModelAttribute(FORM_ATTR_NAME) AddTimetableForm form){
		List<Film> filmList = filmsService.getFilmList();
		List<Hall> hallList = filmsService.getHallList();
		model.put("filmList", filmList);
		model.put("hallList", hallList);
		return "timetable/timetable-add";
	}
	
	@RequestMapping(value = "addTimetable", method = RequestMethod.POST)
	public String addFilm(ModelMap model, HttpServletRequest request, HttpSession session,
			@ModelAttribute(FORM_ATTR_NAME)AddTimetableForm form,BindingResult result) {
		logger.info("添加场次");
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2=new SimpleDateFormat("HH:mm");
		
		Date ttime=null;
		Date tdate=null;
		try {
			tdate=sdf1.parse(form.getTdate());
			ttime=sdf2.parse(form.getTtime());
			timetableService.addTimetable(form.getTfid(),form.getThallid(),tdate,ttime);
		} catch (ParseException e) {
			e.printStackTrace();
		}catch(TimetableDuplicatedException e){
			result.rejectValue("thallid", "form.hall.add.error.duplicated", new String[] { form.getThallid().toString() }, null);
			List<Film> filmList = filmsService.getFilmList();
			List<Hall> hallList = filmsService.getHallList();
			model.put("filmList", filmList);
			model.put("hallList", hallList);
			return "timetable/timetable-add";
		}
		return "forward:/timetable/list";
		}
	
	@RequestMapping(value = "delete", method = { RequestMethod.GET })
	public String delete(ModelMap model, HttpSession session, @RequestParam(required = false) String status,
			Integer tid) {
		logger.info("删除场次");
		timetableService.deleteTimetable(tid);
		return "forward:/timetable/list";
	}
	
	@RequestMapping(value = "update", method = { RequestMethod.GET })
	public String update(ModelMap model, HttpSession session, Integer tid) {
		logger.info("跳转修改场次");
		List<Film> filmList = filmsService.getFilmList();
		List<Hall> hallList = filmsService.getHallList();
		model.put("filmList", filmList);
		model.put("hallList", hallList);
		model.put("tid", tid);
		return "timetable/timetable-update";
	}
	
	@RequestMapping(value = "updateTimetable/{tid}", method = RequestMethod.POST)
	public String updateTimetable(ModelMap model, HttpServletRequest request, HttpSession session,
			@ModelAttribute(FORM_ATTR_NAME) AddTimetableForm form,@PathVariable("tid") Integer tid
			) {
		logger.info("修改场次");
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2=new SimpleDateFormat("HH:mm");
		
		Date ttime=null;
		Date tdate=null;
		try {
			tdate=sdf1.parse(form.getTdate());
			ttime=sdf2.parse(form.getTtime());
			timetableService.updateTimetable(tid,form.getTfid(),form.getThallid(),tdate,ttime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return forwardTo("/timetable/list");
	}
}
