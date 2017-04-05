package com.ln.film.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ln.film.dao.FilmcommentMapper;
import com.ln.film.model.Filmcomment;
import com.ln.film.model.FilmcommentExample;
import com.ln.film.service.FilmCommentService;
@Service
public class FilmCommentServiceImpl implements FilmCommentService {
	
	@Autowired
	private FilmcommentMapper filmcommentMapper;

	@Override
	public List<Filmcomment> getFilmcommentListByFid(Integer fid) {
		FilmcommentExample example=new FilmcommentExample();
		example.createCriteria().andCfidEqualTo(fid);
		return filmcommentMapper.selectByExample(example);
	}

	@Override
	public void addComment(Filmcomment filmcomment) {
		filmcommentMapper.insertSelective(filmcomment);
	}

}
