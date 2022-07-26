package com.ll.exam.util;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Rq {
    private final HttpServletRequest req;
    private final HttpServletResponse resp;


    public HttpServletRequest getReq() {
        return req;
    }

    public HttpServletResponse getResp() {
        return resp;
    }

    public Rq(HttpServletRequest req, HttpServletResponse resp) {
        try {
            //들어오는 데이터를 utf-8로 해석하겠다.
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        //완성되는 html 인코딩을 utf-8로 하겠다.
        resp.setCharacterEncoding("UTF-8");
        // 브라우저에게 우리가 만든 결과물이 utf-8이다라고 알려줌
        resp.setContentType("text/html; charset=utf-8");
        this.req = req;
        this.resp = resp;
    }

    public int getIntParam(String parameter, int defaultVal) {
        int param;
        try {
            if (req.getParameter(parameter) != null) {
                param = Integer.parseInt(req.getParameter(parameter));
            } else {
                param = defaultVal;
            }
        } catch(NumberFormatException e) {
            return defaultVal;
        }

        return param;
    }

    public void appendBody(String formatted) {
        try {
            resp.getWriter().append(formatted);
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void view(String path) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path + ".jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getParam(String paramName, String defaultValue) {
        String value = req.getParameter(paramName);

        if (value == null || value.trim().length() == 0) {
            return defaultValue;
        }

        return value;
    }

    public String getPath() {
        return req.getRequestURI();
    }

    public String getMethod() {
        return req.getMethod();
    }
}
