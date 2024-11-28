package com.busanit501.helloworld.dao;

import com.busanit501.helloworld.Food.dao.MemDAO;
import com.busanit501.helloworld.Food.vo.MemVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.UUID;

@Log4j2
public class MemDAOTest {
    private MemDAO memDAO;

    @BeforeEach
    public void ready() {
        memDAO = new MemDAO();
    }

    @Test
    public void getMemberWithMpwTest() throws SQLException {
        String mid = "lsy";
        String mpw = "1234";
        MemVO memVO = memDAO.getMemberWithMpw(mid, mpw);
        log.info(memVO);
    }

    @Test
    public void updateUuidTest() throws SQLException {
        String uuid = UUID.randomUUID().toString();
        log.info("uuid 랜덤 문자열 샘플 : " + uuid);
        memDAO.updateUuid("kimdh", uuid);

    }
    @Test
    public void getMemberWithUuidTest() throws SQLException {
        MemVO memVO = memDAO.getMemberWithUuid("9a707358-1223-45c4-a634-8e62e81a353d");
        log.info(memVO);
    }


}





