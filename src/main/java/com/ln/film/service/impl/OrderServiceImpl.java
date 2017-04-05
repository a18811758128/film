package com.ln.film.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ln.film.dao.OrderSeatMapper;
import com.ln.film.dao.OrdersMapper;
import com.ln.film.dao.SeatMapper;
import com.ln.film.model.OrderSeat;
import com.ln.film.model.OrderSeatExample;
import com.ln.film.model.Orders;
import com.ln.film.model.OrdersExample;
import com.ln.film.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrdersMapper ordersMapper;
	
	@Autowired
	private OrderSeatMapper orderSeatMapper;

	@Autowired
	private SeatMapper seatMapper;
	
	@Override
	public List<Orders> getOrderListByUserid(Integer userid) {
		OrdersExample example=new OrdersExample();
		OrdersExample.Criteria criteria=example.createCriteria();
		criteria.andOuidEqualTo(userid);
		return ordersMapper.selectByExample(example);
	}

	@Override
	public List<OrderSeat> getOrderSeatListByOid(Integer oid) {
		OrderSeatExample example=new OrderSeatExample();
		OrderSeatExample.Criteria criteria=example.createCriteria();
		criteria.andOidEqualTo(oid);
		List<OrderSeat> orderSeatList = orderSeatMapper.selectByExample(example);
		for(OrderSeat orderSeat:orderSeatList){
			orderSeat.setSeat(seatMapper.selectByPrimaryKey(orderSeat.getSeid()));
		}
		return orderSeatList;
	}
	
}
