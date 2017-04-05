package com.ln.film.model;

import java.util.Date;

public class Timetable {
    private Integer tid;

    private Integer tfid;

    private Integer thallid;

    private Date tdate;

    private Date ttime;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getTfid() {
        return tfid;
    }

    public void setTfid(Integer tfid) {
        this.tfid = tfid;
    }

    public Integer getThallid() {
        return thallid;
    }

    public void setThallid(Integer thallid) {
        this.thallid = thallid;
    }

    public Date getTdate() {
        return tdate;
    }

    public void setTdate(Date tdate) {
        this.tdate = tdate;
    }

    public Date getTtime() {
        return ttime;
    }

    public void setTtime(Date ttime) {
        this.ttime = ttime;
    }
}