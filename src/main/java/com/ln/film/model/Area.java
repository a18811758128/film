package com.ln.film.model;

public class Area {
    private Integer aid;

    private String azone;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAzone() {
        return azone;
    }

    public void setAzone(String azone) {
        this.azone = azone == null ? null : azone.trim();
    }
}