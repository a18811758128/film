package com.ln.film.dao;

import com.ln.film.model.Timetable;
import com.ln.film.model.TimetableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface TimetableMapper {
    int countByExample(TimetableExample example);

    int deleteByExample(TimetableExample example);

    int deleteByPrimaryKey(Integer tid);

    int insert(Timetable record);

    int insertSelective(Timetable record);

    List<Timetable> selectByExample(TimetableExample example);

    Timetable selectByPrimaryKey(Integer tid);

    int updateByExampleSelective(@Param("record") Timetable record, @Param("example") TimetableExample example);

    int updateByExample(@Param("record") Timetable record, @Param("example") TimetableExample example);

    int updateByPrimaryKeySelective(Timetable record);

    int updateByPrimaryKey(Timetable record);
}