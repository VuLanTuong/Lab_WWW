package com.fit.se.ontap2410.backend.enums;

public enum StaffStatus {
    ACTIVE(1),
    PAUSE(0),
    NOT_ACTIVE(-1);
    private final int value;

    StaffStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
