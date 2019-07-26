package com.xx.service;

import com.xx.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudentService {
    public List<Student> selectAllStudent();

    void handleDeleteStudent(Integer id);

    void updateStudent(Student student);

}
