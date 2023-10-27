package com.example.gk4.models;

public enum IsGrant {
    DIASABLE(0),
    ENABLE(1);

    private int value;


    IsGrant(int value){
        this.value = value;
    }
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
