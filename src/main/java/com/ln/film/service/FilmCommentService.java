package com.ln.film.service;

import java.util.List;

import com.ln.film.model.Filmcomment;

public interface FilmCommentService {

	List<Filmcomment> getFilmcommentListByFid(Integer fid);

	void addComment(Filmcomment filmcomment);

}
