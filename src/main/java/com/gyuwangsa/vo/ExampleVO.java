package com.gyuwangsa.vo;

public class ExampleVO {

    private int num;
    private String id;

    public int getNumber() {
        return num;
    }

    public String getId() {
        return id;
    }

    public void setNumber(int num) {
        this.num = num;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ExampleVO(){};

    public ExampleVO(int num, String id) {
        this.num = num;
        this.id = id;
    }

    @Override
    public String toString() {
        return "ExampleVO{" +
                "num=" + num +
                ", id='" + id + '\'' +
                '}';
    }
}
