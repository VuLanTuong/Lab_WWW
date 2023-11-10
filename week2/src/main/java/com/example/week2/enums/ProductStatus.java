package com.example.week2.enums;

public enum ProductStatus {
    IN_ACTIVE(0), //tam ngung
    ACTIVE(1),//đang kinh doanh

    TERMINATED(-1); //khong ban nua
    private int value;

    ProductStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
