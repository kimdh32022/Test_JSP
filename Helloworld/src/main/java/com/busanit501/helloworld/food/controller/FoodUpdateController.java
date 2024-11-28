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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
@Log4j2
@WebServlet (name ="FoodUpdateController", urlPatterns = "/food/update")
public class FoodUpdateController extends HttpServlet {

    private FoodService foodService = FoodService.INSTANCE;
    private final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rsp) throws ServletException, IOException {

        try {
            Long tno = Long.parseLong(rq.getParameter("tno"));
            FoodDTO foodDTO = foodService.get(tno);

            rq.setAttribute("dto", foodDTO);
            rq.getRequestDispatcher("/WEB-INF/food/foodUpd.jsp")
                    .forward(rq,rsp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    //화면에서 데이터를 전달받고 DTO에 담아 화면에
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rsp) throws ServletException, IOException {
        //PRG 패턴
        //POST 처리후 get호출 무한 post 방지 효과 화면 전환 효과
        String finished = rq.getParameter("finished");
        log.info("finished" +finished);
        boolean checkFinished = false;
        if(finished != null && finished.equals("on")) {
            checkFinished = true;
        }

        FoodDTO foodDTO = FoodDTO.builder()
                .tno(Long.parseLong(rq.getParameter("tno")))
                .title(rq.getParameter("title"))
                .dueDate(LocalDate.parse(rq.getParameter("dueDate"),DATE_TIME_FORMATTER))
                .finished(checkFinished)
                .build();

        try {
            foodService.update(foodDTO);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        rsp.sendRedirect("/food/list");
    }


}