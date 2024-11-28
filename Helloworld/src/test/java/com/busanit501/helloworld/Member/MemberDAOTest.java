package com.busanit501.helloworld.Member;

import com.busanit501.helloworld.Blog.DAO.BlogDAO;
import com.busanit501.helloworld.Blog.DTO.BlogVO;
import com.busanit501.helloworld.Member.dao.MemberDAO;
import com.busanit501.helloworld.Member.vo.MemberVO;
import com.busanit501.helloworld.food.dao.FoodDAO;
import com.busanit501.helloworld.food.vo.FoodVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


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
        MemberVO memberVO = memberDAO.selectOne (1L);
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

}
