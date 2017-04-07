package com.ln.film.dao;

import com.ln.film.model.Hall;
import com.ln.film.model.HallExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface HallMapper {
    int countByExample(HallExample example);

    int deleteByExample(HallExample example);

    int deleteByPrimaryKey(Integer hid);

    int insert(Hall record);

    int insertSelective(Hall record);

    List<Hall> selectByExample(HallExample example);

    Hall selectByPrimaryKey(Integer hid);

    int updateByExampleSelective(@Param("record") Hall record, @Param("example") HallExample example);

    int updateByExample(@Param("record") Hall record, @Param("example") HallExample example);

    int updateByPrimaryKeySelective(Hall record);

    int updateByPrimaryKey(Hall record);
}