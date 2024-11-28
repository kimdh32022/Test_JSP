package com.busanit501.helloworld.Food;

import com.busanit501.helloworld.Member.dto.MemberDTO;
import com.busanit501.helloworld.Member.service.MemberService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

@Log4j2
public class MemberServiceTest {
    private MemberService memberService;


    @BeforeEach
    public void ready() {
        memberService = MemberService.INSTANCE;
    }


    @Test
    public void MemberService() throws SQLException {
        MemberDTO memberDTO = MemberDTO.builder()
                .id("떡볶이")
                .password("123456")
                .uname("kim")
                .build();
        memberService.register(memberDTO);
    }

    @Test
    public void listAll() throws SQLException {
        List<MemberDTO> DTOList = memberService.listAll();
        for (MemberDTO memberDTO : DTOList) {
            log.info(memberDTO);
        }
    }
    @Test
    public void testSelectOne() throws SQLException {
        MemberDTO memberDTO = memberService.get(8L);
        log.info("foodDTO : 하나 조회" + memberDTO);
    }



    @Test
    public void Testupdate() throws SQLException {
        MemberDTO memberDTO = MemberDTO.builder()
                .uno(7L)
                .id("수정 작업중")
                .password("321")
                .uname("조이한")
                .build();

        memberService.update(memberDTO);
    }
}
