package com.busanit501.helloworld.Blog.Controller;

import com.busanit501.helloworld.Blog.DTO.BlogDTO;
import com.busanit501.helloworld.Blog.Service.BlogService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name ="blogreadcontroller", urlPatterns = "/blog/read")
public class blogreadcontroller extends HttpServlet {
    @Override
protected void doGet(HttpServletRequest rq, HttpServletResponse rsp) throws IOException, ServletException{
        System.out.println("blogreadcontroller 이거 조회됌.");

        int bno = Integer.parseInt(rq.getParameter("Bno"));
        //서비스에서 하나의 더미데이터를 조회 후 화면에 전달하기
        BlogDTO blogDTO = BlogService.INSTANCE.getOne(bno);

        rq.setAttribute("blogDTO", blogDTO);
        rq.getRequestDispatcher("/WEB-INF/Blog/Blogread.jsp")
                .forward(rq, rsp);

    }
}
