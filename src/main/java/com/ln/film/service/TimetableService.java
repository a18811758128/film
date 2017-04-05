package com.ln.film.service;

import java.util.Date;
import java.util.List;

import com.ln.film.model.Timetable;


public interface TimetableService {

	List<Timetable> getTimetableList();

	void deleteTimetable(Integer tid);

	void addTimetable(Integer tfid, Integer thallid, Date tdate, Date ttime);

	void updateTimetable(Integer tid, Integer tfid, Integer thallid, Date tdate, Date ttime);

	Timetable getTimetableById(Integer otid);

	List<Timetable> getTimetableByTdate(Timetable timetable);

	List<Timetable> getTimetableByTtime(Timetable timetable);

	Timetable getTimetable(Timetable timetable);

}
