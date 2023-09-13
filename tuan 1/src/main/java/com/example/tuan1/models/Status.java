package com.example.tuan1.models;

public enum Status {
    ACTIVE("1"),
    DEACTIVE("0"),
    REMOVE("-1");


    private int status;


    Status(String s) {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
