package com.busanit501.helloworld.Blog.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name ="BlogTest1",urlPatterns = "/test1")
public class Blogcontroller1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rsp) throws IOException, ServletException {
        //jsp 파일을 던져줌

    }
}
