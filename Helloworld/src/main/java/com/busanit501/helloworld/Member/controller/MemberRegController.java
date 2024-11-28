package com.busanit501.helloworld.Member.controller;


import com.busanit501.helloworld.Member.dto.MemberDTO;
import com.busanit501.helloworld.Member.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "MemberRegController" , urlPatterns = "/member/register")
public class MemberRegController extends HttpServlet {

    private MemberService memberService = MemberService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rsp) throws ServletException, IOException {
        rq.getRequestDispatcher("/WEB-INF/member/memberReg.jsp")
                .forward(rq,rsp);
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rsp) throws ServletException, IOException {
        MemberDTO memberDTO = MemberDTO.builder()
                .id(rq.getParameter("id"))
                .password(rq.getParameter("password"))
                .uname(rq.getParameter("uname"))
                .build();

        try {
            memberService.register(memberDTO);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        rsp.sendRedirect("/member/list");
    }


}
