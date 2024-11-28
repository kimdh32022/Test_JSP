package com.busanit501.helloworld.Member;

import com.busanit501.helloworld.Blog.DTO.BlogDTO;
import com.busanit501.helloworld.Blog.Service.BlogService;
import com.busanit501.helloworld.Member.dto.MemberDTO;
import com.busanit501.helloworld.Member.service.MemberService;
import com.busanit501.helloworld.food.dto.FoodDTO;
import com.busanit501.helloworld.food.service.FoodService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;
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
                .ID("떡볶이")
                .Password("123456")
                .Uname("kim")
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
                .Uno(7L)
                .ID("수정 작업중")
                .Password("321")
                .Uname("조이한")
                .build();

        memberService.update(memberDTO);
    }
}
