package com.busanit501.helloworld.dao;

import com.busanit501.helloworld.Member.dao.MemberDAO;
import com.busanit501.helloworld.Member.vo.MemberVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

@Log4j2
public class MemberDAOTest {
    private MemberDAO memberDAO;

    // 아래에 각 단위 테스트가 실행되기전에, 먼저 실행을 함.
    @BeforeEach
    public void ready() {
        memberDAO = new MemberDAO();
    }


    @Test
    public void insetTest() throws Exception {
        MemberVO memberVO = MemberVO.builder()
                .ID("123")
                .Password("1234")
                .Uname("도현")
                .build();

        memberDAO.insert(memberVO);

    }

    @Test
    public void selectAll() throws Exception {
        List<MemberVO> memberVOList = memberDAO.selectAll();
        System.out.println(memberVOList);
    }
    @Test
    public void selectOne() throws Exception {
        MemberVO memberVO = memberDAO.selectOne(5L);
        System.out.println(memberVO);
    }
//
    @Test
    public void deletedata() throws Exception {
        Long Uno =1L;
        memberDAO.deletedata(Uno);

    }
    @Test
    public void updatedata() throws Exception {
        MemberVO memberVO = MemberVO.builder()
                .Uno(6L)
                .ID("수정중")
                .Password("4321")
                .Uname("이한")
                .build();
        memberDAO.updatedata(memberVO);
    }
    @Test
    public void updateUuid() throws Exception {
        String uuid = UUID.randomUUID().toString();
        log.info(uuid);
        MemberDAOTest memDAO;
//        memDAO.updatedata("lsy",uuid);
    }
    
    @Test
    public void updateUUiddata() throws Exception {
        String uuid = UUID.randomUUID().toString();

    }
}
