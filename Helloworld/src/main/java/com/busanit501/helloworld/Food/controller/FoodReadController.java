package com.busanit501.helloworld.Food.controller;

import com.busanit501.helloworld.Food.service.FoodService;
import com.busanit501.helloworld.Food.dto.FoodDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "FoodReadController", urlPatterns = "/food/read")
public class FoodReadController extends HttpServlet {
    private FoodService foodService = FoodService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rsp) throws IOException, ServletException {
        System.out.println("doGet TodoReadController 하나 조회 예제");



        try {
            Long tno = Long.parseLong(rq.getParameter("tno"));
            FoodDTO foodDTO = foodService.get(tno);

            rq.setAttribute("dto", foodDTO);

            Cookie findCookie = findCookie(rq.getCookies(), "viewTodos");
            String cookieValue = findCookie.getValue();
            boolean exists = false;
            if (cookieValue != null && cookieValue.indexOf(tno+"-") >= 0) {
                exists = true;
            }
            if (!exists) {
                cookieValue += tno+"-";
                findCookie.setValue(cookieValue);
                findCookie.setMaxAge(60 * 60 * 24);
                findCookie.setPath("/");
                rsp.addCookie(findCookie);
            }

            rq.getRequestDispatcher("/WEB-INF/food/foodRead.jsp")
                    .forward(rq, rsp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }//doget
    protected Cookie findCookie(Cookie[] cookies, String name) {
        Cookie findCookie = null;
        if(cookies != null && cookies.length > 0) {
            for(Cookie cookie : cookies) {
                if(cookie.getName().equals(name)) {
                    findCookie = cookie;
                    break;
                }//if
            }//for
        }//if
        if(findCookie == null) {
            findCookie = new Cookie("viewTodos", "");
            findCookie.setPath("/");
            findCookie.setMaxAge(60 * 60 * 24);

        }

        return findCookie;
    }//Cookie

}// class
