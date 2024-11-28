package com.busanit501.helloworld.dao;

import com.busanit501.helloworld.Blog.DAO.BlogDAO;
import com.busanit501.helloworld.Blog.DTO.BlogVO;
import com.busanit501.helloworld.Food.dao.FoodDAO;
import com.busanit501.helloworld.Food.vo.FoodVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


public class FoodDAOTest {
    private FoodDAO foodDAO;
    private BlogDAO blogDAO;

    // 아래에 각 단위 테스트가 실행되기전에, 먼저 실행을 함.
    @BeforeEach
    public void ready() {
        foodDAO = new FoodDAO();
        blogDAO = new BlogDAO();
    }



    @Test
    public void insetTest() throws Exception {
        FoodVO foodVO = FoodVO.builder()
                .title("샘플 데이터 추가9")
                .dueDate(LocalDate.now())
                .finished(false)
                .build();

        foodDAO.insert(foodVO);

    }
    @Test
    public void selectAll() throws Exception {
        List<FoodVO> foodVOList = foodDAO.selectAll();
        System.out.println(foodVOList);
    }
    @Test
    public void selectOne() throws Exception {

        FoodVO foodVO = foodDAO.selectOne (7L);
        System.out.println(foodVO);
    }

    @Test
    public void deletedata() throws Exception {
        Long tno =2L;
        foodDAO.deletedata(tno);

    }
    @Test
    public void updatedata() throws Exception {
        FoodVO foodVO = FoodVO.builder()
                .tno(6L)
                .title("수정중")
                .finished(true)
                .dueDate(LocalDate.of(1999,2,22))
                .build();
        foodDAO.updatedata(foodVO);
    }
    @Test

    public void insertBlog() throws Exception {
        BlogVO blogVO = BlogVO.builder()
                .title("제목 2")
                .content("제목 12에 대한 내용")
                .Bdate(new Date())
                .build();

        blogDAO.insertBlog(blogVO);
    }




}
