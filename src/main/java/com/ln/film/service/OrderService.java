package com.ln.film.service;

import java.util.List;

import com.ln.film.model.OrderSeat;
import com.ln.film.model.Orders;

public interface OrderService {

	List<Orders> getOrderListByUserid(Integer userid);

	List<OrderSeat> getOrderSeatListByOid(Integer oid);

}
