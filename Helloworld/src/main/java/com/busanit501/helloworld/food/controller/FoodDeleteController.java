package com.busanit501.helloworld.food.controller;

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
import java.util.List;

@Log4j2 // log.info 형식으로 출력할 예정
@WebServlet(name = "FoodDeleteController", urlPatterns = "/food/delete")
public class FoodDeleteController extends HttpServlet {

    private FoodService foodService = FoodService.INSTANCE;

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rsp) throws ServletException, IOException {

        Long tno =Long.parseLong(rq.getParameter("tno"));
        try {
            foodService.delete(tno);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        rsp.sendRedirect("food/list");

    }
}