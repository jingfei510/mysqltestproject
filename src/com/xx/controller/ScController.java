package com.xx.controller;

import com.xx.entity.Grade;
import com.xx.entity.Sc;
import com.xx.entity.User;
import com.xx.service.ScService;
import com.xx.utils.SetUTF8;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ScController {
    @Autowired
    ScService scService;

    @RequestMapping("scCourseGrade")
    public void selectScByUid(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws IOException {
        SetUTF8.set(response, request);
        User user = (User) session.getAttribute("user");
        if (user != null) {
            System.out.println(user.getSnum());
            List<Grade> scs = scService.selectScBySnum(user.getSnum());
            List<String> scslist = new ArrayList<>();
            for (Grade sc : scs) {
                JSONObject jsonObject = JSONObject.fromObject(sc);
                scslist.add(jsonObject.toString());
            }
            System.out.println(scslist);
            response.getWriter().print(scslist);
        }else {
            System.out.println("此用户未登录");
        }
    }

}
