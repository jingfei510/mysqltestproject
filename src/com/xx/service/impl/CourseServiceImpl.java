package com.xx.service.impl;

import com.xx.entity.Course;
import com.xx.mapper.CourseMapper;
import com.xx.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseMapper courseMapper;
    @Override
    public List<Course> selectAllCourse() {
        return courseMapper.selectAllCourse();
    }

}
