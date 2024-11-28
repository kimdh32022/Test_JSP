package com.busanit501.helloworld.food;

import com.busanit501.helloworld.food.dto.MemDTO;
import com.busanit501.helloworld.food.service.MemService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

@Log4j2
public class MemServiceTest {
    private MemService memService;


    @BeforeEach
    public void ready() {
        memService = MemService.INSTANCE;
    }

    @Test
    public void test1() throws SQLException {
        MemDTO memDTO = memService.login("lsy", "1234");
        log.info("MemberService loginTest : " + memDTO.toString());

    }
}
