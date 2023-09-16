package com.example.week2.model;

public enum EmployeeStatus {
        ACTIVE(1),

        INACTIVE(0),

        TERMINAL(-1);

        private int status;

        EmployeeStatus(int status) {
            this.status = status;
        }
    }


