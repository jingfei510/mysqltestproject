package com.xx.utils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class SetUTF8 {
    public static void set(ServletResponse response, ServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
    }
    public static void set(ServletResponse response) throws UnsupportedEncodingException {
        response.setContentType("text/html;charset=utf-8");
    }

}
