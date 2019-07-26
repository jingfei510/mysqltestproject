package com.xx.service;

import com.xx.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    List<Course> selectAllCourse();

}
