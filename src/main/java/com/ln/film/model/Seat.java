package com.ln.film.model;

public class Seat {
    private Integer seid;

    private Integer sehallid;

    private String serow;

    private String senum;

    public Integer getSeid() {
        return seid;
    }

    public void setSeid(Integer seid) {
        this.seid = seid;
    }

    public Integer getSehallid() {
        return sehallid;
    }

    public void setSehallid(Integer sehallid) {
        this.sehallid = sehallid;
    }

    public String getSerow() {
        return serow;
    }

    public void setSerow(String serow) {
        this.serow = serow == null ? null : serow.trim();
    }

    public String getSenum() {
        return senum;
    }

    public void setSenum(String senum) {
        this.senum = senum == null ? null : senum.trim();
    }
}