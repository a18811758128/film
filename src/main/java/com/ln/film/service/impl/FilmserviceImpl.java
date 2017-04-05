package com.ln.film.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ln.film.dao.AreaMapper;
import com.ln.film.dao.FilmMapper;
import com.ln.film.dao.HallMapper;
import com.ln.film.dao.SortMapper;
import com.ln.film.model.Area;
import com.ln.film.model.AreaExample;
import com.ln.film.model.Film;
import com.ln.film.model.FilmExample;
import com.ln.film.model.Hall;
import com.ln.film.model.HallExample;
import com.ln.film.model.Sort;
import com.ln.film.model.SortExample;
import com.ln.film.service.FilmsService;
@Service
public class FilmserviceImpl implements FilmsService {

	@Autowired
	private FilmMapper filmMapper;
	
	@Autowired
	private AreaMapper areaMapper;
	
	@Autowired
	private SortMapper sortMapper;
	
	@Autowired
	private HallMapper hallMapper;
	
	@Override
	public List<Film> getFilmList() {
		FilmExample example=new FilmExample();
		return filmMapper.selectByExample(example);
	}
	@Override
	public List<Area> getAreaList() {
		// TODO Auto-generated method stub
		AreaExample example=new AreaExample();
		return areaMapper.selectByExample(example);
	}
	@Override
	public List<Sort> getSortList() {
		// TODO Auto-generated method stub
		SortExample example=new SortExample();
		return sortMapper.selectByExample(example);
	}
	@Override
	public Film getFilmById(Integer fid) {
		// TODO Auto-generated method stub
		FilmExample example=new FilmExample();
		FilmExample.Criteria criteria=example.createCriteria();
		criteria.andFidEqualTo(fid);
		List<Film> selectByExample = filmMapper.selectByExample(example);
		if(selectByExample.isEmpty()){
			return null;
		}else{
			return selectByExample.get(0);
		}
	}
	@Override
	public void deleteFilm(Integer fid) {
		filmMapper.deleteByPrimaryKey(fid);
	}
	@Override
	public void updateFilm(Integer fid, String ffilmname, Integer fsortid, Integer faid, String fdiretor, String fplay,
			String fintro, String flanguage, Integer flong, String ftype, Double fprice, String fphotoPath,
			String fvideoPath) {
		Film film=new Film();
		film.setFid(fid);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		film.setFdate(sdf.format(new Date()));
		film.setFaid(faid);
		film.setFdiretor(fdiretor);
		film.setFfilmname(ffilmname);
		film.setFintro(fintro);
		film.setFlanguage(flanguage);
		film.setFlong(flong);
		film.setFplay(fplay);
		film.setFsortid(fsortid);
		film.setFprice(fprice);
		film.setFtype(ftype);
		film.setFphoto(fphotoPath);
		film.setFvideo(fvideoPath);
		filmMapper.updateByPrimaryKey(film);
	}
	@Override
	public void addFilm(String ffilmname, Integer fsortid, Integer faid, String fdiretor, String fplay, String fintro,
			String flanguage, Integer flong, String ftype, Double fprice, String fphotoPath, String fvideoPath) {
		Film film=new Film();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		film.setFdate(sdf.format(new Date()));
		film.setFaid(faid);
		film.setFdiretor(fdiretor);
		film.setFfilmname(ffilmname);
		film.setFintro(fintro);
		film.setFlanguage(flanguage);
		film.setFlong(flong);
		film.setFplay(fplay);
		film.setFsortid(fsortid);
		film.setFprice(fprice);
		film.setFtype(ftype);
		film.setFphoto(fphotoPath);
		film.setFvideo(fvideoPath);
		filmMapper.insertSelective(film);
	}
	@Override
	public List<Hall> getHallList() {
		HallExample example=new HallExample();
		return hallMapper.selectByExample(example);
	}

}
