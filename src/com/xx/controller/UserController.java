package com.xx.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.xx.service.UserService;

import com.xx.utils.MD5;
import com.xx.utils.SetUTF8;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import com.xx.entity.User;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value="/login")
	public void login(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws Exception {
		String snum = request.getParameter("snum");
		String password=request.getParameter("password");
		System.out.println(snum+"="+password);
		//MD5加密，生成32位 小写字母
		password = MD5.md5(password);
		User user = userService.loginByUserId(snum);
		if (user != null) {
			if (user.getPassword().equals(password)) {
				System.out.println("登陆成功");
				System.out.println("loginid:"+user.getId());
				session.setAttribute("user", user);
				response.getWriter().print("true");
			} else {
				response.getWriter().print("false");
			}
		} else {
			response.getWriter().print("false");
		}
	}
	@RequestMapping(value="/register")
	public void register(User user,HttpServletResponse response) throws IOException {
		try {
			String password = user.getPassword();
			//生成32位 小写字母
			password = MD5.md5(password);
			user.setPassword(password);
			userService.register(user);
			response.getWriter().print("true");
		}catch (Exception e){
			response.getWriter().print("false");
		}
	}


	@RequestMapping(value="/exit")
	public void exit(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws IOException {
		User user = (User)session.getAttribute("user");
		if (user != null) {
			System.out.println("删除了session");
			session.invalidate();

	}}

	@RequestMapping(value = "/selectUser")
	public void selectUser(HttpServletResponse response,HttpSession session) throws IOException {
		SetUTF8.set(response);
		System.out.println("this is selectUser");
		User user1 = (User)session.getAttribute("user");
		System.out.println("selectuserid:"+user1.getId());
		//在查询一遍，而不用之前session里面的，是因为如果修改了学号等信息的话，session中还是原来的信息
        User user=userService.selectUser(user1);
        if(user!=user1){
            session.setAttribute("user",user);
        }
		//对象和json转换
		JSONObject json = JSONObject.fromObject(user);
		JSONArray array=JSONArray.fromObject(user);
		String strJson=json.toString();
		String strArray=array.toString();
		System.out.println("strJson:"+strJson);
		System.out.println("strArray:"+strArray);
		response.getWriter().print(strArray);

	}

	@RequestMapping(value = "/selectUserById")
	public void selectUserById(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws IOException {
		SetUTF8.set(response);
		System.out.println("this is selectUserById");
		User user1 = (User)session.getAttribute("user");
		System.out.println(user1.getId());
		//在查询一遍，而不用之前session里面的，是因为如果修改了学号等信息的话，session中还是原来的信息
		User user=userService.selectUserById(user1.getId());

		//对象和json转换
		JSONObject json = JSONObject.fromObject(user);
		JSONArray array=JSONArray.fromObject(user);
		String strJson=json.toString();
		String strArray=array.toString();
		System.out.println("strJson:"+strJson);
		System.out.println("strArray:"+strArray);
		response.getWriter().print(strJson);

	}
	@RequestMapping(value = "/updateUser")
	public void updateUser(User user,HttpServletRequest request,HttpServletResponse response) throws Exception {
		SetUTF8.set(response,request);
		System.out.println("this is updateUser");
		System.out.println(user);
		String password = user.getPassword();
		//生成32位 小写字母
		password = MD5.md5(password);
		user.setPassword(password);
		try {
			userService.updateUser(user);
			response.getWriter().print("修改成功!");

		}catch (Exception e){
			System.err.println(e.getMessage());
			response.getWriter().print("修改失败!");
		}

	}

	@RequestMapping(value = "/selectAllUsers")
	public void selectAllUsers(HttpServletResponse response) throws IOException {
		SetUTF8.set(response);
		System.out.println("this is selectAllUsers");
		List<User> users=userService.selectAllUsers();
		System.out.println(users);
		ArrayList<String> jsonUsers = new ArrayList<>();
		for (User user : users) {
			JSONObject json = JSONObject.fromObject(user);
			String strJson=json.toString();
			jsonUsers.add(strJson);
		}
		System.out.println(jsonUsers);
		response.getWriter().print(jsonUsers);


	}


}
