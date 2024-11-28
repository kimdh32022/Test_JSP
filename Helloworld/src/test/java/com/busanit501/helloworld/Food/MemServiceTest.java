package com.busanit501.helloworld.Food;

import com.busanit501.helloworld.Food.dto.MemDTO;
import com.busanit501.helloworld.Food.service.MemService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.UUID;

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

    @Test
    public void test2() throws SQLException {
        String uuid = UUID.randomUUID().toString();
        memService.updateUuid("lsy2", uuid);
    }

    @Test
    public void test3() throws SQLException {
        MemDTO memDTO = memService.getMemberWithUuidService("95065fbe-87e8-4a07-a99b-42e1b3da8c37");
        log.info("memDTO : " + memDTO);
    }
}
