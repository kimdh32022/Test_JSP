package com.busanit501.helloworld.Blog.Controller;


import com.busanit501.helloworld.Blog.DTO.BlogDTO;
import com.busanit501.helloworld.Blog.Service.BlogService;
import com.busanit501.helloworld.food.dto.FoodDTO;
import com.busanit501.helloworld.food.service.FoodService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "BlogRegController" , urlPatterns = "/Blog/register")
public class BlogRegController extends HttpServlet {

    private BlogService blogService = BlogService.INSTANCE;
    private final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rsp) throws ServletException, IOException {
        rq.getRequestDispatcher("/WEB-INF/Blog/BlogReg.jsp")
                .forward(rq,rsp);
    }

    //화면에서 데이터를 전달받고 DTO에 담아 화면에
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rsp) throws ServletException, IOException {
        //PRG 패턴
        //POST 처리후 get호출 무한 post 방지 효과 화면 전환 효과
        BlogDTO blogDTO = BlogDTO.builder()
                .title(rq.getParameter("title"))
                .content(rq.getParameter("content"))
                .build();

        try {
            blogService.register(blogDTO);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        rsp.sendRedirect("/food/list");
    }


}
