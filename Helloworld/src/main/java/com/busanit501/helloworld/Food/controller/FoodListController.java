package com.busanit501.helloworld.Food.controller;

import com.busanit501.helloworld.Food.dto.FoodDTO;
import com.busanit501.helloworld.Food.service.FoodService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Log4j2 // log.info 형식으로 출력할 예정
@WebServlet(name = "FoodListController", urlPatterns = "/food/list")
public class FoodListController extends HttpServlet {

    private FoodService foodService = FoodService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = request.getServletContext();
        String result = (String) context.getAttribute("appTestName");


        try {
            List<FoodDTO> foodlist = foodService.listAll();
            request.setAttribute("list", foodlist);
            request.getRequestDispatcher("/WEB-INF/food/foodList.jsp")
                    .forward(request, response);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
