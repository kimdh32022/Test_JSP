package com.busanit501.helloworld.food.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "loginController", urlPatterns = "/login")
public class loginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rsp) throws IOException, ServletException {
        rq.getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(rq,rsp);
    }
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rsp) throws IOException, ServletException {
       String id = rq.getParameter("username");
       String passw = rq.getParameter("password");

       String tempInfo = id + passw;
       HttpSession  session =  rq.getSession();
       session.setAttribute("loginInfo", tempInfo);
       rsp.sendRedirect("/food/list");
    }
}
