package com.busanit501.helloworld.food.controller;

import com.busanit501.helloworld.food.service.FoodService;
import com.busanit501.helloworld.food.dto.FoodDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "TodoReadController", urlPatterns = "/food/read")
public class FoodReadController extends HttpServlet {
    private FoodService foodService = FoodService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rsp) throws IOException, ServletException {
        System.out.println("doGet TodoReadController 하나 조회 예제");


        try {
            Long tno = Long.parseLong(rq.getParameter("tno"));
            FoodDTO foodDTO = foodService.get(tno);

            rq.setAttribute("dto", foodDTO);
            rq.getRequestDispatcher("/WEB-INF/food/foodRead.jsp")
                    .forward(rq, rsp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
