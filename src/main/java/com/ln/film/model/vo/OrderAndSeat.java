package com.ln.film.model.vo;

import java.util.Date;
import java.util.List;

import com.ln.film.model.OrderSeat;
import com.ln.film.model.Timetable;
import com.ln.film.model.Users;

public class OrderAndSeat {
	private Integer oid;
	private Users user;
	private Date odate;
	private String ostate;
	private Timetable timetable;
	private Double oprice;
	private Integer seatCount;
	private String ticketCode;
	private List<OrderSeat> orderSeatList;
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Date getOdate() {
		return odate;
	}
	public void setOdate(Date odate) {
		this.odate = odate;
	}
	public String getOstate() {
		return ostate;
	}
	public void setOstate(String ostate) {
		this.ostate = ostate;
	}
	public Timetable getTimetable() {
		return timetable;
	}
	public void setTimetable(Timetable timetable) {
		this.timetable = timetable;
	}
	public Double getOprice() {
		return oprice;
	}
	public void setOprice(Double oprice) {
		this.oprice = oprice;
	}
	public Integer getSeatCount() {
		return seatCount;
	}
	public void setSeatCount(Integer seatCount) {
		this.seatCount = seatCount;
	}
	public String getTicketCode() {
		return ticketCode;
	}
	public void setTicketCode(String ticketCode) {
		this.ticketCode = ticketCode;
	}
	public List<OrderSeat> getOrderSeatList() {
		return orderSeatList;
	}
	public void setOrderSeatList(List<OrderSeat> orderSeatList) {
		this.orderSeatList = orderSeatList;
	}
	
}
