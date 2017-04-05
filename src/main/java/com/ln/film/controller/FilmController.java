package com.ln.film.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.ln.film.annotation.Login;
import com.ln.film.form.UpdateFilmForm;
import com.ln.film.model.Area;
import com.ln.film.model.Film;
import com.ln.film.model.Sort;
import com.ln.film.model.transients.AccessLevel;
import com.ln.film.service.FilmsService;

@Controller
@RequestMapping(value = "/film")
@Login(level=AccessLevel.ADMIN_GENERAL)
public class FilmController extends AbstractController{
	
	private static final Logger logger = LoggerFactory.getLogger(FilmController.class);
	
	@Autowired
	private FilmsService filmsService;
	
	@RequestMapping(value="")
	public String showFilms(ModelMap model, HttpSession session){
		if (session == null || null == session.getAttribute("hasLogin") || session.getAttribute("user") == null) {
			logger.info("没有登录, 重定向至登陆页");
			return "redirect:/login";
		}
		logger.info("显示上映影片信息");
		List<Film> filmList = filmsService.getFilmList();
		List<Area> areaList = filmsService.getAreaList();
		List<Sort> sortList = filmsService.getSortList();
	    model.put("filmList", filmList);
	    model.put("areaList", areaList);
	    model.put("sortList", sortList);
		return "/filmmanage/filmlist";
	}
	
	@RequestMapping(value = "delete", method = { RequestMethod.GET })
	public String delete(ModelMap model, HttpSession session,Integer fid) {
		logger.info("删除电影");
		if (session == null || null == session.getAttribute("hasLogin") || session.getAttribute("user") == null) {
			logger.info("没有登录, 重定向至登陆页");
			return "redirect:/login";
		}
		filmsService.deleteFilm(fid);
		return "forward:/film";
	}
	
	@RequestMapping(value = "update", method = { RequestMethod.GET })
	public String update(ModelMap model, HttpSession session, Integer fid) {
		logger.info("跳转修改电影");
		if (session == null || null == session.getAttribute("hasLogin") || session.getAttribute("user") == null) {
			logger.info("没有登录, 重定向至登陆页");
			return "redirect:/login";
		}
		Film filmUpdate = filmsService.getFilmById(fid);
		List<Area> areaList = filmsService.getAreaList();
		List<Sort> sortList = filmsService.getSortList();
		model.put("filmUpdate", filmUpdate);
		model.put("areaList", areaList);
	    model.put("sortList", sortList);
		return "filmmanage/film-update";
	}
	
	@RequestMapping(value = "updateFilm/{fid}", method = RequestMethod.POST)
	public String updateFilm(ModelMap model, HttpServletRequest request, HttpSession session,
			@ModelAttribute(FORM_ATTR_NAME) UpdateFilmForm form,@PathVariable("fid") Integer fid,
			@RequestParam("photoup")CommonsMultipartFile fphoto,@RequestParam("videoup")CommonsMultipartFile fvideo) {
		logger.info("修改电影");
		if (session == null || null == session.getAttribute("hasLogin") || session.getAttribute("user") == null) {
			logger.info("没有登录, 重定向至登陆页");
			return "redirect:/login";
		}
		String fphotonewName=null;
		String fvideonewName=null;
		if(!fphoto.isEmpty()){
			try {
			String originalName = fphoto.getOriginalFilename();
            String extension = originalName.substring(originalName
                    .lastIndexOf('.'));
            String uuid = UUID.randomUUID().toString();
            fphotonewName = uuid + extension;
            String path=request.getSession().getServletContext().getRealPath("/upload/images/"+fphotonewName);
            logger.info("存放路径为："+path);
            File dir = new File(path);
            if (!dir.exists()) {
            	dir.mkdirs();
            }
			fphoto.transferTo(dir);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(!fvideo.isEmpty()){
			try {
				String originalName = fvideo.getOriginalFilename();
				String extension = originalName.substring(originalName
						.lastIndexOf('.'));
				String uuid = UUID.randomUUID().toString();
				fvideonewName = uuid + extension;
				String path=session.getServletContext().getRealPath("/upload/video/"+fvideonewName);
				logger.info("存放路径为："+path);
				File dir = new File(path);
				if (!dir.exists()) {
					dir.mkdirs();
				}
				fvideo.transferTo(dir);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String fphotoPath="/upload/images/"+fphotonewName;
		String fvideoPath="/upload/video/"+fvideonewName;
		filmsService.updateFilm(fid,form.getFfilmname(),form.getFsortid(),form.getFaid(),
				form.getFdiretor(),form.getFplay(),form.getFintro(),form.getFlanguage(),
				form.getFlong(),form.getFtype(),form.getFprice(),fphotoPath,fvideoPath);
		return "forward:/film";
	}
	
	@RequestMapping(value = "add")
	public String add(ModelMap model, HttpSession session, HttpServletRequest request) {
		logger.info("跳转添加电影");
		if (session == null || null == session.getAttribute("hasLogin") || session.getAttribute("user") == null) {
			logger.info("没有登录, 重定向至登陆页");
			return "redirect:/login";
		}
		List<Area> areaList = filmsService.getAreaList();
		List<Sort> sortList = filmsService.getSortList();
		model.put("areaList", areaList);
	    model.put("sortList", sortList);
		return "filmmanage/film-add";
	}

	@RequestMapping(value = "addFilm", method = RequestMethod.POST)
	public String addFilm(ModelMap model, HttpServletRequest request, HttpSession session,
			@ModelAttribute(FORM_ATTR_NAME)UpdateFilmForm form,@RequestParam("photoup")CommonsMultipartFile fphoto,
			@RequestParam("videoup")CommonsMultipartFile fvideo) {
		logger.info("添加电影");
		if (session == null || null == session.getAttribute("hasLogin") || session.getAttribute("user") == null) {
			logger.info("没有登录, 重定向至登陆页");
			return "redirect:/login";
		}
		String fphotonewName=null;
		String fvideonewName=null;
		if(!fphoto.isEmpty()){
			try {
			String originalName = fphoto.getOriginalFilename();
            String extension = originalName.substring(originalName
                    .lastIndexOf('.'));
            String uuid = UUID.randomUUID().toString();
            fphotonewName = uuid + extension;
            String path=request.getSession().getServletContext().getRealPath("/upload/images/"+fphotonewName);
            logger.info("存放路径为："+path);
            File dir = new File(path);
            if (!dir.exists()) {
            	dir.mkdirs();
            }
			fphoto.transferTo(dir);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(!fvideo.isEmpty()){
			try {
				String originalName = fvideo.getOriginalFilename();
				String extension = originalName.substring(originalName
						.lastIndexOf('.'));
				String uuid = UUID.randomUUID().toString();
				fvideonewName = uuid + extension;
				String path=session.getServletContext().getRealPath("/upload/video/"+fvideonewName);
				logger.info("存放路径为："+path);
				File dir = new File(path);
				if (!dir.exists()) {
					dir.mkdirs();
				}
				fvideo.transferTo(dir);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String fphotoPath="/upload/images/"+fphotonewName;
		String fvideoPath="/upload/video/"+fvideonewName;
		filmsService.addFilm(form.getFfilmname(),form.getFsortid(),form.getFaid(),
				form.getFdiretor(),form.getFplay(),form.getFintro(),form.getFlanguage(),
				form.getFlong(),form.getFtype(),form.getFprice(),fphotoPath,fvideoPath);
		return "forward:/film";
		}
}
