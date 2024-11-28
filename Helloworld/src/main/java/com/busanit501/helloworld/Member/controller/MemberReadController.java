package com.busanit501.helloworld.Member.controller;

import com.busanit501.helloworld.Member.dto.MemberDTO;
import com.busanit501.helloworld.Member.service.MemberService;
import com.busanit501.helloworld.food.dto.FoodDTO;
import com.busanit501.helloworld.food.service.FoodService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "MemberReadController", urlPatterns = "/member/read")
public class MemberReadController extends HttpServlet {
    private MemberService memberService = MemberService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rsp) throws IOException, ServletException {
        try {
            Long Uno = Long.parseLong(rq.getParameter("Uno"));
            MemberDTO memberDTO = memberService.get(Uno);

            rq.setAttribute("dto", memberDTO);
            rq.getRequestDispatcher("/WEB-INF/member/memberRead.jsp")
                    .forward(rq, rsp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
