package com.busanit501.helloworld.dao;

import com.busanit501.helloworld.Blog.DAO.BlogDAO;
import com.busanit501.helloworld.food.dao.FoodDAO;
import com.busanit501.helloworld.food.dao.MemDAO;
import com.busanit501.helloworld.food.vo.MemVO;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
@Log4j2
public class MemDAOTest {
    private MemDAO memDAO;

    @BeforeEach
    public void ready() {
        memDAO = new MemDAO();
    }
    @Test
    public void getMemberTest() throws SQLException {
        String mid = "lsy";
        String mpw = "1234";
        MemVO memVO = memDAO.getMember(mid,mpw);
        log.info(memVO);
    }






}