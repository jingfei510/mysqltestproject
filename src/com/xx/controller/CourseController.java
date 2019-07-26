package com.xx.controller;

import com.xx.entity.Course;
import com.xx.service.CourseService;
import com.xx.utils.SetUTF8;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping("selectAllCourse")
    public void selectAllCourse(HttpServletResponse response) throws IOException {
        SetUTF8.set(response);
        List<Course> courses=courseService.selectAllCourse();
        List<String> courselist = new ArrayList<>();
        for (Course cour : courses) {
            JSONObject jsonObject = JSONObject.fromObject(cour);
            courselist.add(jsonObject.toString());
        }
        response.getWriter().print(courselist);

    }





}
