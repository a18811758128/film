package com.ln.film.dao;

import com.ln.film.model.Filmcomment;
import com.ln.film.model.FilmcommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface FilmcommentMapper {
    int countByExample(FilmcommentExample example);

    int deleteByExample(FilmcommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Filmcomment record);

    int insertSelective(Filmcomment record);

    List<Filmcomment> selectByExample(FilmcommentExample example);

    Filmcomment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Filmcomment record, @Param("example") FilmcommentExample example);

    int updateByExample(@Param("record") Filmcomment record, @Param("example") FilmcommentExample example);

    int updateByPrimaryKeySelective(Filmcomment record);

    int updateByPrimaryKey(Filmcomment record);
}