package com.example.week4_vulantuong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import repositories.ClazzRepository;
import repositories.StudentRepository;

@SpringBootApplication
public class Week4VuLanTuongApplication {

//    @Autowired
//    private ClazzRepository clazzRepository;
//
//    @Autowired
//    private StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(Week4VuLanTuongApplication.class, args);
    }

}
