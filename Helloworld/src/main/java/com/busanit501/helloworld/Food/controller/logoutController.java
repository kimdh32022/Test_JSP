package com.busanit501.helloworld.Food.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet (name = "logoutController" , urlPatterns = "/logout")
public class logoutController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rsp) throws IOException, ServletException{
        HttpSession session = rq.getSession();
        session.removeAttribute("loginInfo");
        session.invalidate();
        rsp.sendRedirect("/login");
    }
}
