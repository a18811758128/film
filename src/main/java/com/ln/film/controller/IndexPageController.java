package com.ln.film.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ln.film.form.TimetableQueryForm;
import com.ln.film.model.AjaxResult;
import com.ln.film.model.Film;
import com.ln.film.model.Filmcomment;
import com.ln.film.model.Timetable;
import com.ln.film.model.Users;
import com.ln.film.service.FilmsService;
import com.ln.film.service.TimetableService;

@Controller
@RequestMapping("/")
public class IndexPageController {
	private static final Logger logger = LoggerFactory.getLogger(IndexPageController.class);
	
	@Autowired
	private FilmsService filmsService;
	
	@Autowired
	private TimetableService timetableService;
	
    @RequestMapping({"index"})
	public String indexPage(ModelMap model) {
        logger.info("访问首页");
        List<Film> filmList = filmsService.getFilmList();
        model.put("tab", "index");
        model.put("filmList", filmList);
		return "index-page";
	}
    
    @RequestMapping(value="preferential")
    public String preferential(ModelMap model) {
    	logger.info("访问优惠活动页面");
    	return "preferential";
    }
    
    @RequestMapping(value="query")
	public String queryFilm(ModelMap model,HttpSession session){
    	logger.info("访问排期");
    	List<Film> filmList = filmsService.getFilmList();
    	model.put("filmList", filmList);
    	model.put("nowdate", new Date());
		return "film-select";
	}
    
    @RequestMapping(value="queryfilm",method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult fbcomment(HttpSession session,
			@RequestBody TimetableQueryForm form,
            BindingResult result){
    	if (session == null || null == session.getAttribute("hasLogin")
                || session.getAttribute("user") == null) {
            logger.info("没有登录, 重定向至登陆页");
            return new AjaxResult(AjaxResult.FAIL, "login");
        }
		logger.info("根据电影时间查询场次安排");
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2=new SimpleDateFormat("HH:mm");
		Timetable timetable=new Timetable();
		timetable.setTfid(form.getTfid());
		try {
			timetable.setTdate(sdf1.parse(form.getTdate()));
			timetable.setTtime(sdf2.parse(form.getTtime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AjaxResult ajaxResult = new AjaxResult(AjaxResult.FAIL);
		List<Timetable> timetableList=null;
		timetableList=timetableService.getTimetableByTdate(timetable);
		if(timetableList!=null&&!timetableList.isEmpty()){
			timetableList=timetableService.getTimetableByTtime(timetable);
			if(timetableList!=null&&!timetableList.isEmpty()){
				ajaxResult.setCode(AjaxResult.SUCCESS);
			}else{
				return new AjaxResult(AjaxResult.FAIL, "ttime");
			}
		}else{
			return new AjaxResult(AjaxResult.FAIL, "tdate");
		}
		
		return ajaxResult;
	}
}
