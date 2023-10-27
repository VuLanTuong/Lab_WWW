package com.fit.se.ontap2410.backend.models;

import com.fit.se.ontap2410.backend.converters.StaffStatusConverter;
import com.fit.se.ontap2410.backend.enums.StaffStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
// query sql
@NamedQueries(
        {
                @NamedQuery(
                        name = "Staff.findAll",query = "select s from Staff s where status = 1"
                )
        }
)
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private long id;
    private String name;
    private int age;
    private String address;
    private LocalDateTime checkInAt;


    //apply converter
    @Convert(converter = StaffStatusConverter.class)
    private StaffStatus status;
    @Transient
    @OneToMany(mappedBy = "manager")
    private List<Staff> staffs;
    //    Quan tu tu quan ly no
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id",nullable =true)
    private Staff manager;

    @OneToMany(mappedBy = "staff")
    private List<Task> tasks;

    public Staff() {
    }

    public Staff(long id, String name, int age, String address, LocalDateTime checkInAt, StaffStatus status, Staff manager) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.checkInAt = checkInAt;
        this.status = status;
        this.manager = manager;
    }
    public Staff(String name, int age, String address, LocalDateTime checkInAt, StaffStatus status, Staff manager) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.checkInAt = checkInAt;
        this.status = status;
        this.manager = manager;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getCheckInAt() {
        return checkInAt;
    }

    public void setCheckInAt(LocalDateTime checkInAt) {
        this.checkInAt = checkInAt;
    }

    public StaffStatus getStatus() {
        return status;
    }

    public void setStatus(StaffStatus status) {
        this.status = status;
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }

    public Staff getManager() {
        return manager;
    }

    public void setManager(Staff manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", checkInAt=" + checkInAt +
                ", status=" + status +
                ", manager=" + manager +
                '}';
    }
}
