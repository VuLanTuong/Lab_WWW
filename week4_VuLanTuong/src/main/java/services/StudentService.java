package services;

import models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.StudentRepository;

import java.util.List;

@Service
public class StudentService {

        @Autowired
        private StudentRepository bookRepository;

        public List<Student> list() {
            return bookRepository.findAll();
        }
    }

