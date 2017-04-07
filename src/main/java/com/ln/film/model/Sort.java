package com.ln.film.model;

public class Sort {
    private Integer sid;

    private String ssort;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSsort() {
        return ssort;
    }

    public void setSsort(String ssort) {
        this.ssort = ssort == null ? null : ssort.trim();
    }
}