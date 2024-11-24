package com.busanit501.helloworld.Blog.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name ="bloglogincontroller", urlPatterns = "/blog/login")
public class bloglogincontroller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher("/WEB-INF/Blog/Bloglogin.jsp")
                .forward(req, resp);
    }
    protected void doPost(HttpServletRequest rq, HttpServletResponse rsp)throws IOException, ServletException{
        System.out.println("입력된 내용을 받아 왔습니다");
        String username = rq.getParameter("username");
        String password = rq.getParameter("password");

        PrintWriter out = rsp.getWriter();
        out.println("<html><body>");
        out.println("<h1> username : " + username + "</h1>");
        out.println("<h2> password : " + password + "</h2>");
        out.println("</body></html>");



    }
}
