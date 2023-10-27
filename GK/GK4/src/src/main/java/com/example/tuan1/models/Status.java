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


    public static int convertEnumToInt(Status status){
        if(Status.ACTIVE.equals(status)){
            return 1;

        }
        if(Status.DEACTIVE.equals(status)){
            return 0;

        }
        return -1;
    }

    public static Status convertIntToEnum(int status){
        if (status == 1) {
             return Status.ACTIVE;
        }

        if (status == -1) {
            return Status.REMOVE;
        }
        return Status.DEACTIVE;
    }
}
