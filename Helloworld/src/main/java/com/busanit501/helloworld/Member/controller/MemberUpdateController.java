package com.busanit501.helloworld.Member.controller;

import com.busanit501.helloworld.Member.dto.MemberDTO;
import com.busanit501.helloworld.Member.service.MemberService;
import com.busanit501.helloworld.food.dto.FoodDTO;
import com.busanit501.helloworld.food.service.FoodService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Log4j2
@WebServlet (name ="MemberUpdateController", urlPatterns = "/member/update")
public class MemberUpdateController extends HttpServlet {

    private MemberService memberService = MemberService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rsp) throws ServletException, IOException {

        try {
            Long Uno = Long.parseLong(rq.getParameter("Uno"));
            MemberDTO memberDTO = memberService.get(Uno);

            rq.setAttribute("dto", memberDTO);
            rq.getRequestDispatcher("/WEB-INF/member/memberUpd.jsp")
                    .forward(rq,rsp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        rsp.sendRedirect("/member/list");
    }


}