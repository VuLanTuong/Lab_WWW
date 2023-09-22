package com.example.week2.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "employee")
@Getter
@Setter
@ToString
public class Employee {
//    emp_id, full_name, dob, email, phone, address, status
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeId;
    private String fullName;
    private Date dob;
    private String email;
    private String phone;
    private String address;


    @Convert(converter = EmployeeStatusConverter.class)
    private EmployeeStatus status;

    @OneToMany(mappedBy = "employee")
    private List<Order> orderList;

    public Employee( String fullName, Date dob, String email, String phone, String address, EmployeeStatus status, List<Order> orderList) {

        this.fullName = fullName;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.status = status;
        this.orderList = orderList;
    }

    public Employee() {

    }


}
