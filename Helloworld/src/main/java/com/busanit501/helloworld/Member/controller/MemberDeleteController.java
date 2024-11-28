package com.busanit501.helloworld.Member.controller;

import com.busanit501.helloworld.Member.service.MemberService;
import com.busanit501.helloworld.food.service.FoodService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@Log4j2 // log.info 형식으로 출력할 예정
@WebServlet(name = "MemberDeleteController", urlPatterns = "/member/delete")
public class MemberDeleteController extends HttpServlet {

    private MemberService memberService = MemberService.INSTANCE;

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rsp) throws ServletException, IOException {

        Long Uno =Long.parseLong(rq.getParameter("Uno"));
        try {
            memberService.delete(Uno);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        rsp.sendRedirect("/member/list");

    }
}