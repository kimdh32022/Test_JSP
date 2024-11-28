package com.busanit501.helloworld.Food;

import com.busanit501.helloworld.Blog.DTO.BlogDTO;
import com.busanit501.helloworld.Blog.Service.BlogService;
import com.busanit501.helloworld.Food.dto.FoodDTO;
import com.busanit501.helloworld.Food.service.FoodService;
//import com.busanit501.helloworld.food.service.FoodService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Log4j2
public class FoodServiceTest {
    private FoodService foodService;
    private BlogService blogService;


    @BeforeEach
    public void ready() {
        foodService = FoodService.INSTANCE;
        blogService = BlogService.INSTANCE;
    }


    @Test
    public void FoodService() throws SQLException {
        FoodDTO foodDTO = FoodDTO.builder()
                .title("떡볶이")
                .dueDate(LocalDate.now())
                .build();
        foodService.register(foodDTO);
    }

    @Test
    public void listAll() throws SQLException {
        List<FoodDTO> foodDTOList = foodService.listAll();
        for (FoodDTO foodDTO : foodDTOList) {
            log.info(foodDTO);
        }
    }

    @Test
    public void testSelectOne() throws SQLException {
        FoodDTO foodDTO = foodService.get(14L);
        log.info("foodDTO : 하나 조회" + foodDTO);
    }

    @Test
    public void testSelectone() throws SQLException {
        BlogDTO blogDTO = blogService.getOne(1L);
        log.info("blogDTO : " + blogDTO);
    }


    @Test
    public void Testupdate() throws SQLException {
        FoodDTO foodDTO = FoodDTO.builder()
                .tno(19L)
                .title("수정 작업중")
                .dueDate(LocalDate.now())
                .finished(true)
                .build();

        foodService.update(foodDTO);
    }
}
