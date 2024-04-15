package com.gyuwangsa.vo;

import java.util.Date;

public class RoleUserVO {
    //유저 아이디
    private String user_nm;
    //권한
    private String role_cd;
    //유효시작일
    private Date start_date;
    //유효종료일
    private Date end_date;
    //브랜드 코드
    private int brand_cd;
    //비고
    private String note;

    public RoleUserVO(){}

    public RoleUserVO(String user_nm, String role_cd, Date start_date, Date end_date, int brand_cd, String note) {
        this.user_nm = user_nm;
        this.role_cd = role_cd;
        this.start_date = start_date;
        this.end_date = end_date;
        this.brand_cd = brand_cd;
        this.note = note;
    }

    public String getUser_nm() {
        return user_nm;
    }

    public void setUser_nm(String user_nm) {
        this.user_nm = user_nm;
    }

    public String getRole_cd() {
        return role_cd;
    }

    public void setRole_cd(String role_cd) {
        this.role_cd = role_cd;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public int getBrand_cd() {
        return brand_cd;
    }

    public void setBrand_cd(int brand_cd) {
        this.brand_cd = brand_cd;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


}
