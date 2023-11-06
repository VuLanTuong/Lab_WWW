package com.example.week7_vulantuong.enums;

public enum EmployeeStatus {
    IN_ACTIVE(0),
    ACTIVE(1),

    TERMINATED(-1);
    private int value;

    EmployeeStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
