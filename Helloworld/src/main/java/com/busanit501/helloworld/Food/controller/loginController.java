package com.busanit501.helloworld.Food.controller;

import com.busanit501.helloworld.Food.dto.MemDTO;
import com.busanit501.helloworld.Food.service.MemService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

@WebServlet(name = "loginController", urlPatterns = "/login")
public class loginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rsp) throws IOException, ServletException {
        rq.getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(rq,rsp);
    }
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rsp) throws IOException, ServletException {
       String mid = rq.getParameter("mid");
       String mpw = rq.getParameter("mpw");
       String auto = rq.getParameter("auto");

       boolean rememberME = auto != null && auto.equals("on");

        try {
            MemDTO memDTO = MemService.INSTANCE.login(mid,mpw);
            if(rememberME) {
                String uuid = UUID.randomUUID().toString();
                MemService.INSTANCE.updateUuid(mid, uuid);
                memDTO.setUuid(uuid);

                Cookie rememberCookie = new Cookie("rememberMe", uuid);
                rememberCookie.setPath("/");
                rememberCookie.setMaxAge(60 * 60 * 24 * 7);
                rsp.addCookie(rememberCookie);

            }
            HttpSession  session =  rq.getSession();
            session.setAttribute("loginInfo", memDTO);
            rsp.sendRedirect("/food/list");
        } catch (SQLException e) {
            rsp.sendRedirect("/login?result=error");
        }
    }
}
