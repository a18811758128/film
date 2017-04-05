package com.ln.film.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ln.film.annotation.Login;
import com.ln.film.model.Film;
import com.ln.film.model.Hall;
import com.ln.film.model.Orders;
import com.ln.film.model.Timetable;
import com.ln.film.model.Users;
import com.ln.film.model.vo.OrderAndSeat;
import com.ln.film.service.FilmsService;
import com.ln.film.service.OrderService;
import com.ln.film.service.TimetableService;

@Controller
@RequestMapping(value="order")
@Login
public class OrderController extends AbstractController{
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private TimetableService timetableService;
	
	@Autowired
	private FilmsService filmsService;
	
	@RequestMapping(value="list",method=RequestMethod.GET)
	public String showOrder(HttpSession session, ModelMap model){
		if (session == null || null == session.getAttribute("hasLogin") || session.getAttribute("user") == null) {
			logger.info("没有登录, 重定向至登陆页");
			return "redirect:/login";
		}
		Users user = (Users) session.getAttribute("user");
        logger.info("访问我的订单");
        List<OrderAndSeat> oasList=new ArrayList<>();
		List<Orders> orderList=orderService.getOrderListByUserid(user.getUserid());
		for(Orders order:orderList){
			OrderAndSeat oas=new OrderAndSeat();
			oas.setOid(order.getOid());
			oas.setOdate(order.getOdate());
			oas.setOprice(order.getOprice());
			oas.setOstate(order.getOstate());
			oas.setSeatCount(order.getSeatCount());
			oas.setTicketCode(order.getTicketCode());
			oas.setUser(user);
			oas.setTimetable(timetableService.getTimetableById(order.getOtid()));
			oas.setOrderSeatList(orderService.getOrderSeatListByOid(order.getOid()));
			oasList.add(oas);
		}
		List<Film> filmList = filmsService.getFilmList();
		List<Hall> hallList = filmsService.getHallList();
		model.put("filmList", filmList);
		model.put("hallList", hallList);
		model.put("oasList",oasList);
		return "orders";
	}
	
	@RequestMapping(value="buythefilm")
	public String buyTheFilm(ModelMap map,HttpSession session,Integer tfid,String tdate,String ttime){
		if (session == null || null == session.getAttribute("hasLogin") || session.getAttribute("user") == null) {
			logger.info("没有登录, 重定向至登陆页");
			return "redirect:/login";
		}
		logger.info("根据场次搜索电影");
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2=new SimpleDateFormat("HH:mm");
		Timetable timetable=new Timetable();
		timetable.setTfid(tfid);
		try {
			timetable.setTdate(sdf1.parse(tdate));
			timetable.setTtime(sdf2.parse(ttime));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<Timetable> timetableList=timetableService.getTimetableByTtime(timetable);
		Film film=filmsService.getFilmById(timetable.getTfid());
		List<Hall> hallList = filmsService.getHallList();
		map.put("hallList", hallList);
		map.put("film", film);
		map.put("timetableList", timetableList);
		return "buyTheFilm";
	}
	
	@RequestMapping(value="selectSeat")
	public String selectSeat(ModelMap model,HttpSession session,
			@RequestParam(value="tid",required=false)Integer tid,
			@RequestParam(value="fid",required=false)Integer fid,
			@RequestParam(value="price",required=false)Double price,
			@RequestParam(value="tdate",required=false)String tdate,
			@RequestParam(value="ttime",required=false)String ttime,
			@RequestParam(value="thallid",required=false)Integer thallid){
		if (session == null || null == session.getAttribute("hasLogin") || session.getAttribute("user") == null) {
			logger.info("没有登录, 重定向至登陆页");
			return "redirect:/login";
		}
		logger.info("选座");
		if(tid!=null){
			Timetable timetable = timetableService.getTimetableById(tid);
			Film film = filmsService.getFilmById(timetable.getTfid());
			model.put("timetable", timetable);
			model.put("film", film);
		}else{
			SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdf2=new SimpleDateFormat("HH:mm");
			Timetable timetable=new Timetable();
			try {
				timetable.setTfid(fid);
				timetable.setThallid(thallid);
				timetable.setTdate(sdf1.parse(tdate));
				timetable.setTtime(sdf2.parse(ttime));
				timetable=timetableService.getTimetable(timetable);
				Film film = filmsService.getFilmById(fid);
				model.put("timetable", timetable);
				model.put("film", film);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		List<Hall> hallList = filmsService.getHallList();
		model.put("hallList", hallList);
		return "selectSeat";
		
	}
}
