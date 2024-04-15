package com.gyuwangsa.vo;

import java.util.Date;

public class BrandVO {
    //브랜드 코드
    private int brand_cd;
    //브랜드 이름
    private String brand_nm;
    //브랜드 로고
    private String brand_img;
    //브랜드 우편번호
    private String brand_addr_no;
    //브랜드 주소
    private String brand_addr;
    //브랜드 상세 주소
    private String brand_addr_dtl;
    //택배사 코드
    private String deli_comp_cd;
    //승인 여부
    private char state_cd;
    //유효시작일
    private Date start_date;
    //유효종료일
    private Date end_date;
    //비고
    private String note;

    public BrandVO(){};

    public BrandVO(int brand_cd, String brand_nm, String brand_img, String brand_addr_no, String brand_addr, String brand_addr_dtl, String deli_comp_cd, char state_cd, Date start_date, Date end_date, String note) {
        this.brand_cd = brand_cd;
        this.brand_nm = brand_nm;
        this.brand_img = brand_img;
        this.brand_addr_no = brand_addr_no;
        this.brand_addr = brand_addr;
        this.brand_addr_dtl = brand_addr_dtl;
        this.deli_comp_cd = deli_comp_cd;
        this.state_cd = state_cd;
        this.start_date = start_date;
        this.end_date = end_date;
        this.note = note;
    }

    public int getBrand_cd() {
        return brand_cd;
    }

    public void setBrand_cd(int brand_cd) {
        this.brand_cd = brand_cd;
    }

    public String getBrand_nm() {
        return brand_nm;
    }

    public void setBrand_nm(String brand_nm) {
        this.brand_nm = brand_nm;
    }

    public String getBrand_img() {
        return brand_img;
    }

    public void setBrand_img(String brand_img) {
        this.brand_img = brand_img;
    }

    public String getBrand_addr_no() {
        return brand_addr_no;
    }

    public void setBrand_addr_no(String brand_addr_no) {
        this.brand_addr_no = brand_addr_no;
    }

    public String getBrand_addr() {
        return brand_addr;
    }

    public void setBrand_addr(String brand_addr) {
        this.brand_addr = brand_addr;
    }

    public String getBrand_addr_dtl() {
        return brand_addr_dtl;
    }

    public void setBrand_addr_dtl(String brand_addr_dtl) {
        this.brand_addr_dtl = brand_addr_dtl;
    }

    public String getDeli_comp_cd() {
        return deli_comp_cd;
    }

    public void setDeli_comp_cd(String deli_comp_cd) {
        this.deli_comp_cd = deli_comp_cd;
    }

    public char getState_cd() {
        return state_cd;
    }

    public void setState_cd(char state_cd) {
        this.state_cd = state_cd;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "BrandVO{" +
                "brand_cd=" + brand_cd +
                ", brand_nm='" + brand_nm + '\'' +
                ", brand_img='" + brand_img + '\'' +
                ", brand_addr_no='" + brand_addr_no + '\'' +
                ", brand_addr='" + brand_addr + '\'' +
                ", brand_addr_dtl='" + brand_addr_dtl + '\'' +
                ", deli_comp_cd='" + deli_comp_cd + '\'' +
                ", state_cd=" + state_cd +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", note='" + note + '\'' +
                '}';
    }
}
