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
import com.ln.film.model.Seat;
import com.ln.film.model.SeatExample;
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
		example.setOrderByClause("odate DESC");
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

	@Override
	public List<Seat> getSeatListByHid(Integer thallid) {
		SeatExample example=new SeatExample();
		example.createCriteria().andSehallidEqualTo(thallid);
		return seatMapper.selectByExample(example);
	}

	@Override
	public boolean getSelectSeatBySeid(Integer seid) {
		OrderSeatExample example=new OrderSeatExample();
		OrderSeatExample.Criteria criteria=example.createCriteria();
		criteria.andSeidEqualTo(seid);
		criteria.andStatusEqualTo("0");
		if(orderSeatMapper.countByExample(example)>0){
			return true;
		}
		return false;
	}

	@Override
	public Seat getSeatBySeat(Seat seat) {
		SeatExample example=new SeatExample();
		SeatExample.Criteria criteria=example.createCriteria();
		criteria.andSehallidEqualTo(seat.getSehallid());
		criteria.andSerowEqualTo(seat.getSerow());
		criteria.andSenumEqualTo(seat.getSenum());
		List<Seat> selectByExample = seatMapper.selectByExample(example);
		if(selectByExample!=null&&!selectByExample.isEmpty()){
			return selectByExample.get(0);
		}
		return null;
	}

	@Override
	public int addSeat(Seat seat) {
		return seatMapper.insertSelective(seat);
	}

	@Override
	public Seat getSeatById(Integer seid) {
		return seatMapper.selectByPrimaryKey(seid);
	}

	@Override
	public int addOrder(Orders order) {
		return ordersMapper.insertSelective(order);
	}

	@Override
	public int addOrderSeat(OrderSeat os) {
		// TODO Auto-generated method stub
		return orderSeatMapper.insertSelective(os);
	}

	@Override
	public Orders getOrderById(Integer oid) {
		return ordersMapper.selectByPrimaryKey(oid);
	}

	@Override
	public int updateOrder(Orders order) {
		return ordersMapper.updateByPrimaryKeySelective(order);
	}

	@Override
	public int updateOrderSeat(OrderSeat orderSeat) {
		return orderSeatMapper.updateByPrimaryKeySelective(orderSeat);
	}

	@Override
	public int deleteOrderById(Integer oid) {
		return ordersMapper.deleteByPrimaryKey(oid);
	}

	@Override
	public int deleteOrderSeatByOid(Integer oid) {
		OrderSeatExample example=new OrderSeatExample();
		example.createCriteria().andOidEqualTo(oid);
		return orderSeatMapper.deleteByExample(example);
	}
	
}
