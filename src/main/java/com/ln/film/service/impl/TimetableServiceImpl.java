package com.ln.film.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ln.film.dao.TimetableMapper;
import com.ln.film.exception.TimetableDuplicatedException;
import com.ln.film.model.Timetable;
import com.ln.film.model.TimetableExample;
import com.ln.film.service.TimetableService;
@Service
public class TimetableServiceImpl implements TimetableService {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private TimetableMapper timetableMapper;
	
	@Override
	public List<Timetable> getTimetableList() {
		TimetableExample example=new TimetableExample();
		return timetableMapper.selectByExample(example);
	}

	@Override
	public void deleteTimetable(Integer tid) {
		timetableMapper.deleteByPrimaryKey(tid);
	}

	@Override
	public void addTimetable(Integer tfid, Integer thallid, Date tdate, Date ttime) {
		validateDuplication(thallid,tdate,ttime);
		Timetable timetable=new Timetable();
		timetable.setTfid(tfid);
		timetable.setThallid(thallid);
		timetable.setTdate(tdate);
		timetable.setTtime(ttime);
		timetableMapper.insertSelective(timetable);
	}
	
	@Override
	public void updateTimetable(Integer tid, Integer tfid, Integer thallid, Date tdate, Date ttime) {
		Timetable timetable=new Timetable();
		timetable.setTid(tid);
		timetable.setTfid(tfid);
		timetable.setThallid(thallid);
		timetable.setTdate(tdate);
		timetable.setTtime(ttime);
		timetableMapper.updateByPrimaryKey(timetable);
		
	}
	
	private void validateDuplication(Integer thallid, Date tdate,
            Date ttime) {
        logger.debug("validate duplicate for thallid:"+thallid+" tdate:"+tdate+" ttime:"+ttime);
        TimetableExample example=new TimetableExample();
        TimetableExample.Criteria criteria=example.createCriteria();
        criteria.andThallidEqualTo(thallid);
        criteria.andTdateEqualTo(tdate);
        criteria.andTtimeEqualTo(ttime);
        if (timetableMapper.countByExample(example) > 0) {
                logger.error("timetable duplicated!");
                throw new TimetableDuplicatedException();
        }
        logger.debug("validate duplicate done.");
    }

	@Override
	public Timetable getTimetableById(Integer otid) {
		return timetableMapper.selectByPrimaryKey(otid);
	}

	@Override
	public List<Timetable> getTimetableByTdate(Timetable timetable) {
		TimetableExample example=new TimetableExample();
		TimetableExample.Criteria criteria=example.createCriteria();
		criteria.andTfidEqualTo(timetable.getTfid());
		criteria.andTdateEqualTo(timetable.getTdate());
		return timetableMapper.selectByExample(example);
	}

	@Override
	public List<Timetable> getTimetableByTtime(Timetable timetable) {
		TimetableExample example=new TimetableExample();
		TimetableExample.Criteria criteria=example.createCriteria();
		criteria.andTfidEqualTo(timetable.getTfid());
		criteria.andTdateEqualTo(timetable.getTdate());
		criteria.andTtimeEqualTo(timetable.getTtime());
		return timetableMapper.selectByExample(example);
	}

	@Override
	public Timetable getTimetable(Timetable timetable) {
		TimetableExample example=new TimetableExample();
		TimetableExample.Criteria criteria=example.createCriteria();
		criteria.andTfidEqualTo(timetable.getTfid());
		criteria.andTdateEqualTo(timetable.getTdate());
		criteria.andTtimeEqualTo(timetable.getTtime());
		criteria.andThallidEqualTo(timetable.getThallid());
		List<Timetable> selectByExample = timetableMapper.selectByExample(example);
		if(selectByExample!=null&&!selectByExample.isEmpty()){
			return selectByExample.get(0);
		}
		return null;
	}

	@Override
	public List<Timetable> getTimetableByFid(Integer fid) {
		TimetableExample example=new TimetableExample();
		example.createCriteria().andTfidEqualTo(fid);
		return timetableMapper.selectByExample(example);
	}

}
