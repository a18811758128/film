package com.ln.film.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ln.film.annotation.Login;
import com.ln.film.model.AjaxResult;
import com.ln.film.model.Film;
import com.ln.film.model.Hall;
import com.ln.film.model.OrderSeat;
import com.ln.film.model.Orders;
import com.ln.film.model.Seat;
import com.ln.film.model.Timetable;
import com.ln.film.model.Users;
import com.ln.film.model.vo.OrderAndSeat;
import com.ln.film.service.EmailService;
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
	
	@Autowired
    private EmailService emailService;
	
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
		Timetable timetable=null;
		Film film =null;
		if(tid!=null){
			timetable = timetableService.getTimetableById(tid);
			film= filmsService.getFilmById(timetable.getTfid());
			
		}else{
			SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdf2=new SimpleDateFormat("HH:mm");
			try {
				timetable=new Timetable();
				timetable.setTfid(fid);
				timetable.setThallid(thallid);
				timetable.setTdate(sdf1.parse(tdate));
				timetable.setTtime(sdf2.parse(ttime));
				timetable=timetableService.getTimetable(timetable);
				film = filmsService.getFilmById(fid);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		List<Hall> hallList = filmsService.getHallList();
		List<Seat> seats=orderService.getSeatListByHid(timetable.getThallid());
		List<Seat> seatList=new ArrayList<>();
		for (Seat seat : seats) {
			boolean flag=orderService.getSelectSeatBySeid(seat.getSeid());
			if(flag){
				seatList.add(seat);
			}
		}
		model.put("seatList", seatList);
		model.put("hallList", hallList);
		model.put("timetable", timetable);
		model.put("film", film);
		return "selectSeat";
	}
	
	@RequestMapping(value="add")
	@ResponseBody
	public AjaxResult AddOrder(ModelMap model,HttpSession session,@RequestBody Seat[] seats){
		if (session == null || null == session.getAttribute("hasLogin")
                || session.getAttribute("user") == null) {
            logger.info("没有登录, 重定向至登陆页");
            return new AjaxResult(AjaxResult.FAIL, "login");
        }
        AjaxResult ajaxResult = new AjaxResult(AjaxResult.FAIL);
        List<Seat> seatList=new ArrayList<>();
        for (Seat seat : seats) {
			if(orderService.getSeatBySeat(seat)==null){
				orderService.addSeat(seat);
			}
			seatList.add(orderService.getSeatBySeat(seat));
		}
        ajaxResult.setCode(AjaxResult.SUCCESS);
        ajaxResult.setData(seatList);
		return ajaxResult;
	}
	
	@RequestMapping(value="pay",method=RequestMethod.GET)
	public String pay(HttpSession session, ModelMap model,Integer tid,Integer[] seids){
		if (session == null || null == session.getAttribute("hasLogin") || session.getAttribute("user") == null) {
			logger.info("没有登录, 重定向至登陆页");
			return "redirect:/login";
		}
		Users user = (Users) session.getAttribute("user");
        logger.info("支付");
        Timetable timetable=timetableService.getTimetableById(tid);
        Film film=filmsService.getFilmById(timetable.getTfid());
        Orders order=new Orders();
        order.setOdate(new Date());
        order.setOprice(film.getFprice()*seids.length);
        order.setSeatCount(seids.length);
        order.setOtid(tid);
        order.setOuid(user.getUserid());
        order.setTicketCode("未支付");
        orderService.addOrder(order);
        List<OrderSeat> orderSeatList=new ArrayList<>();
        for (Integer seid : seids) {
			Seat seat=orderService.getSeatById(seid);
			OrderSeat os=new OrderSeat();
			os.setSeat(seat);
			os.setOid(order.getOid());
			os.setSeid(seid);
			os.setStatus("1");
			orderService.addOrderSeat(os);
			orderSeatList.add(os);
		}
        List<OrderAndSeat> oasList=new ArrayList<>();
		OrderAndSeat oas=new OrderAndSeat();
		oas.setOid(order.getOid());
		oas.setOdate(order.getOdate());
		oas.setTicketCode(order.getTicketCode());
		oas.setOprice(film.getFprice()*orderSeatList.size());
		oas.setSeatCount(orderSeatList.size());
		oas.setUser(user);
		oas.setTimetable(timetable);
		oas.setOrderSeatList(orderSeatList);
		oasList.add(oas);
		List<Hall> hallList = filmsService.getHallList();
		model.put("film", film);
		model.put("hallList", hallList);
		model.put("oasList",oasList);
		return "orders-pay";
	}
	
	@RequestMapping(value = "/pay/{oid}", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult payOrder(HttpSession session,
			@PathVariable("oid") Integer oid) {

		if (session == null || null == session.getAttribute("hasLogin") || session.getAttribute("user") == null) {
			logger.info("没有登录, 重定向至登陆页");
			return new AjaxResult(AjaxResult.FAIL, "login");
		}

		try {
			// 未链接支付, 直接认为支付成功

			logger.info("支付订单 订单编号: " + oid);
			logger.info("支付成功!!");
			Orders order = orderService.getOrderById(oid);
			if (order == null) {
				return new AjaxResult(AjaxResult.FAIL, "找不到订单'" + oid + "'");
			}
			Random r1=new Random();
			int c1 = r1.nextInt(899999)+100000;
			int c2 = r1.nextInt(899999)+100000;
			String ticketCode=c1+""+c2;
			order.setTicketCode(ticketCode);
			orderService.updateOrder(order);
			List<OrderSeat> orderSeatList=orderService.getOrderSeatListByOid(oid);
			if(orderSeatList!=null&&!orderSeatList.isEmpty()){
				for (OrderSeat orderSeat : orderSeatList) {
					orderSeat.setStatus("0");
					orderService.updateOrderSeat(orderSeat);
				}
			}
			return new AjaxResult(AjaxResult.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(AjaxResult.FAIL, e.getMessage());
		}
	}
	
	@RequestMapping(value="payorder",method=RequestMethod.GET)
	public String payOrder(HttpSession session, ModelMap model,Integer oid){
		if (session == null || null == session.getAttribute("hasLogin") || session.getAttribute("user") == null) {
			logger.info("没有登录, 重定向至登陆页");
			return "redirect:/login";
		}
		Users user = (Users) session.getAttribute("user");
        logger.info("支付");
        
        Orders order=orderService.getOrderById(oid);
        Timetable timetable=timetableService.getTimetableById(order.getOtid());
        Film film=filmsService.getFilmById(timetable.getTfid());
        List<OrderAndSeat> oasList=new ArrayList<>();
		OrderAndSeat oas=new OrderAndSeat();
		oas.setOid(order.getOid());
		oas.setOdate(order.getOdate());
		oas.setTicketCode(order.getTicketCode());
		oas.setOprice(order.getOprice());
		oas.setSeatCount(order.getSeatCount());
		oas.setUser(user);
		oas.setTimetable(timetable);
		oas.setOrderSeatList(orderService.getOrderSeatListByOid(order.getOid()));
		oasList.add(oas);
		List<Hall> hallList = filmsService.getHallList();
		model.put("film", film);
		model.put("hallList", hallList);
		model.put("oasList",oasList);
		return "orders-pay";
	}
	
	@RequestMapping(value="delete/{oid}")
	public String deleteOrder(ModelMap model,HttpSession session,@PathVariable("oid") Integer oid){
		if (session == null || null == session.getAttribute("hasLogin") || session.getAttribute("user") == null) {
			logger.info("没有登录, 重定向至登陆页");
			return "redirect:/login";
		}
		orderService.deleteOrderById(oid);
		orderService.deleteOrderSeatByOid(oid);
		return redirectTo("/order/list");
	}
	
	@RequestMapping(value="return/{oid}")
	public String returnOrder(ModelMap model,HttpSession session,@PathVariable("oid") Integer oid){
		if (session == null || null == session.getAttribute("hasLogin") || session.getAttribute("user") == null) {
			logger.info("没有登录, 重定向至登陆页");
			return "redirect:/login";
		}
		Users user = (Users) session.getAttribute("user");
		Orders order = orderService.getOrderById(oid);
		List<OrderSeat> orderSeatList= orderService.getOrderSeatListByOid(oid);
		for (OrderSeat orderSeat : orderSeatList) {
			orderSeat.setStatus("1");
			orderService.updateOrderSeat(orderSeat);
		}
		order.setTicketCode("已退票");
		if(orderService.updateOrder(order)>0){
			emailService.sendReturnEmail(user);
		}
		return redirectTo("/order/list");
	}
}
