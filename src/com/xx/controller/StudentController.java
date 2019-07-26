package com.xx.controller;

import com.xx.entity.Student;
import com.xx.service.StudentService;
import com.xx.service.impl.StudentServiceImpl;
import com.xx.utils.SetUTF8;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "selectAllStudent")
    public void selectAllStudent(HttpServletResponse response) throws IOException {
        SetUTF8.set(response);
        List<Student> students = studentService.selectAllStudent();
        List<String> studentslist = new ArrayList<>();
        for (Student student : students) {
            JSONObject jsonObject = JSONObject.fromObject(student);
            //将查出来的学生转成json存储
            studentslist.add(jsonObject.toString());
        }
        System.out.println(studentslist);
        response.getWriter().print(studentslist);
    }

    @RequestMapping(value = "handleDeleteStudent")
    public void handleDeleteStudent(Student student,HttpServletResponse response) throws IOException {
        SetUTF8.set(response);
        //System.out.println(student.getId()+"\t"+student.getName());
        try {
            studentService.handleDeleteStudent(student.getId());
            response.getWriter().print("删除成功！");
        }catch (Exception e){
            response.getWriter().print("删除出现错误！");
        }


    }

    @RequestMapping(value = "updateStudent")
    public void updateStudent(Student student, HttpServletResponse response, HttpServletRequest request) throws IOException {
        SetUTF8.set(response,request);
        System.out.println(student);
        try {
            studentService.updateStudent(student);
            response.getWriter().print("修改成功！");
        }catch (Exception e){
            response.getWriter().print("修改出现错误！");
        }


    }

}
