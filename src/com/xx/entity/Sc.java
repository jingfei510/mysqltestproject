package com.xx.entity;

public class Sc {
    private Integer id;

    private String snum;

    private Integer cid;

    private Integer grade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSnum() {
        return snum;
    }

    public void setSnum(String snum) {
        this.snum = snum == null ? null : snum.trim();
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Sc{" +
                "id=" + id +
                ", snum='" + snum + '\'' +
                ", cid=" + cid +
                ", grade=" + grade +
                '}';
    }
}