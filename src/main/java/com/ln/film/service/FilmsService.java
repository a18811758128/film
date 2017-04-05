package com.ln.film.service;

import java.util.List;

import com.ln.film.model.Area;
import com.ln.film.model.Film;
import com.ln.film.model.Hall;
import com.ln.film.model.Sort;


public interface FilmsService {
	public List<Film> getFilmList();

	public List<Area> getAreaList();

	public List<Sort> getSortList();

	public Film getFilmById(Integer fid);

	public void deleteFilm(Integer fid);

	public void updateFilm(Integer fid, String ffilmname, Integer fsortid, Integer faid, String fdiretor, String fplay,
			String fintro, String flanguage, Integer flong, String ftype, Double fprice, String fphotoPath,
			String fvideoPath);

	public void addFilm(String ffilmname, Integer fsortid, Integer faid, String fdiretor, String fplay, String fintro,
			String flanguage, Integer flong, String ftype, Double fprice, String fphotoPath, String fvideoPath);

	public List<Hall> getHallList();
}
