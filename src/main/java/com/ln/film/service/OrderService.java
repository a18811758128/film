package com.ln.film.service;

import java.util.List;

import com.ln.film.model.OrderSeat;
import com.ln.film.model.Orders;
import com.ln.film.model.Seat;

public interface OrderService {

	List<Orders> getOrderListByUserid(Integer userid);

	List<OrderSeat> getOrderSeatListByOid(Integer oid);

	List<Seat> getSeatListByHid(Integer thallid);

	boolean getSelectSeatBySeid(Integer seid);

}
