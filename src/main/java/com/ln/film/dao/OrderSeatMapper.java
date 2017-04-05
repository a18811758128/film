package com.ln.film.dao;

import com.ln.film.model.OrderSeat;
import com.ln.film.model.OrderSeatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface OrderSeatMapper {
    int countByExample(OrderSeatExample example);

    int deleteByExample(OrderSeatExample example);

    int deleteByPrimaryKey(Integer osid);

    int insert(OrderSeat record);

    int insertSelective(OrderSeat record);

    List<OrderSeat> selectByExample(OrderSeatExample example);

    OrderSeat selectByPrimaryKey(Integer osid);

    int updateByExampleSelective(@Param("record") OrderSeat record, @Param("example") OrderSeatExample example);

    int updateByExample(@Param("record") OrderSeat record, @Param("example") OrderSeatExample example);

    int updateByPrimaryKeySelective(OrderSeat record);

    int updateByPrimaryKey(OrderSeat record);
}