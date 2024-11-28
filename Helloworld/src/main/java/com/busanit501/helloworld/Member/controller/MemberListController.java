package com.busanit501.helloworld.Member.controller;

import com.busanit501.helloworld.Member.dto.MemberDTO;
import com.busanit501.helloworld.Member.service.MemberService;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
@Log4j2
@WebServlet(name = "MemberListController", urlPatterns = "/member/list")
public class MemberListController extends HttpServlet {

    private MemberService memberService = MemberService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rsp) throws ServletException, IOException {
        try {
            log.info("회원 전체 목록 조회를 시작합니다.");
            List<MemberDTO> memberlist = memberService.listAll();
            log.debug("조회된 회원 수: {}", memberlist.size());
            rq.setAttribute("list", memberlist);
            log.info("JSP 파일 호출 직전");
            rq.getRequestDispatcher("/WEB-INF/member/memberList.jsp")
                            .forward(rq, rsp);
            log.info("JSP 파일 호출 성공");

        } catch (SQLException e) {
            log.error("회원 목록 조회 중 오류 발생", e);
            throw new RuntimeException(e);
        }


    }
}
