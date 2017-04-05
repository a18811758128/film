package com.ln.film.model;

public class Hall {
    private Integer hid;

    private String hhall;

    private String hnum;

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public String getHhall() {
        return hhall;
    }

    public void setHhall(String hhall) {
        this.hhall = hhall == null ? null : hhall.trim();
    }

    public String getHnum() {
        return hnum;
    }

    public void setHnum(String hnum) {
        this.hnum = hnum == null ? null : hnum.trim();
    }
}