package com.example.week2.models;

import jakarta.persistence.Table;

@Table
public enum ProductStatus {
    ACTIVE(1),

    INACTIVE(0),

    TERMINAL(-1);

    private int status;

    ProductStatus() {

    }

    ProductStatus(int status) {
        this.status = status;
    }

    public static int convertEnumToInt(ProductStatus status){
        if(EmployeeStatus.ACTIVE.equals(status)){
            return 1;

        }
        if(EmployeeStatus.INACTIVE.equals(status)){
            return 0;

        }
        return -1;
    }

    public static ProductStatus convertIntToEnum(int status){
        if (status == 1) {
            return ProductStatus.ACTIVE;
        }

        if (status == -1) {
            return ProductStatus.TERMINAL;
        }
        return ProductStatus.INACTIVE;
    }



}
