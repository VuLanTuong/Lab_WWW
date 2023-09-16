package com.example.week2.model;

public enum ProductStatus {
    ACTIVE(1),

    INACTIVE(0),

    TERMINAL(-1);

    private int status;

    ProductStatus(int status) {
        this.status = status;
    }
}
