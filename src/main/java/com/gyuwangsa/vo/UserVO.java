package com.gyuwangsa.vo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class UserVO {
    //유저ID
    private int user_id;
    //유저 아이디
    private String user_nm;
    //비밀번호
    private String password;
    //이름
    private String name;
    //이메일  
    private String email;
    //핸드폰 번호
    private String phone;
    //우편번호
    private String addr_no;
    //주소
    private String addr;
    //상세 주소
    private String addr_dtl;
    //성별
    private char sex_cd;
    //비밀번호 초기화 상태
    private char pwd_yn;
    //비밀번호 변경일
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.S", timezone = "Asia/Seoul")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.S")
    private Date pwd_date;
    //마지막 접속일
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.S", timezone = "Asia/Seoul")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.S")
    private Date login_date;
    //가입유형
    private String join_type;
    //인증키
    private String api_key;

    public UserVO(){};
    public UserVO(int user_id, String user_nm, String password, String name, String email, String phone,
                  String addr_no, String addr, String addr_dtl, char sex_cd, char pwd_yn, Date pwd_date,
                  Date login_date, String join_type, String api_key) {
        this.user_id = user_id;
        this.user_nm = user_nm;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.addr_no = addr_no;
        this.addr = addr;
        this.addr_dtl = addr_dtl;
        this.sex_cd = sex_cd;
        this.pwd_yn = pwd_yn;
        this.pwd_date = pwd_date;
        this.login_date = login_date;
        this.join_type = join_type;
        this.api_key = api_key;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_nm() {
        return user_nm;
    }

    public void setUser_nm(String user_nm) {
        this.user_nm = user_nm;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddr_no() {
        return addr_no;
    }

    public void setAddr_no(String addr_no) {
        this.addr_no = addr_no;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getAddr_dtl() {
        return addr_dtl;
    }

    public void setAddr_dtl(String addr_dtl) {
        this.addr_dtl = addr_dtl;
    }

    public char getSex_cd() {
        return sex_cd;
    }

    public void setSex_cd(char sex_cd) {
        this.sex_cd = sex_cd;
    }

    public char getPwd_yn() {
        return pwd_yn;
    }

    public void setPwd_yn(char pwd_yn) {
        this.pwd_yn = pwd_yn;
    }

    public Date getPwd_date() {
        return pwd_date;
    }

    public void setPwd_date(Date pwd_date) {
        this.pwd_date = pwd_date;
    }

    public Date getLogin_date() {
        return login_date;
    }

    public void setLogin_date(Date login_date) {
        this.login_date = login_date;
    }

    public String getJoin_type() {
        return join_type;
    }

    public void setJoin_type(String join_type) {
        this.join_type = join_type;
    }

    public String getApi_key() {
        return api_key;
    }

    public void setApi_key(String api_key) {
        this.api_key = api_key;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "user_id=" + user_id +
                ", user_nm='" + user_nm + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", addr_no='" + addr_no + '\'' +
                ", addr='" + addr + '\'' +
                ", addr_dtl='" + addr_dtl + '\'' +
                ", sex_cd='" + sex_cd + '\'' +
                ", pwd_yn=" + pwd_yn +
                ", pwd_date=" + pwd_date +
                ", login_date=" + login_date +
                ", join_type='" + join_type + '\'' +
                ", api_key='" + api_key + '\'' +
                '}';
    }
}
