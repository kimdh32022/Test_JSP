package com.busanit501.kimdh.service;

import com.busanit501.kimdh.dto.FoodDTO;
import com.busanit501.kimdh.dto.PageRequestDTO;
import com.busanit501.kimdh.dto.PageResponseDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@Log4j2
@SpringBootTest
public class FoodServiceTest {
    @Autowired
    private FoodService foodService;


    @Test
    public void testRegisterFood() {
        FoodDTO foodDTO = FoodDTO.builder()
                .fname("카레")
                .fmeteral("카레가루, 양파, 당근, 감자, 고기")
                .writer("김도현")
                .regDate(LocalDateTime.now())
                .build();
        Long id = foodService.registerFood(foodDTO);
        log.info(" 입력한 게시글 고유 번호 : " + id.toString());
    }

    @Test
    public void testSelectOneFood() {
        Long id = 103L;
        FoodDTO foodDTO = foodService.readOneFood(id);
        log.info("testSelectOneFood의 결과 :"+foodDTO.toString());
    }

    @Test
    public void testUpdateFood() {
        FoodDTO foodDTO = FoodDTO.builder()
                .id(8L)
                .fname("우동")
                .fmeteral("우동면, 어묵, 국물")
                .build();
        foodService.updateFood(foodDTO);
    }

    @Test
    public void testDeleteFood() {
        Long id = 201L;
        foodService.deleteFood(id);
    }

    @Test
    public void testListFood() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .type("tcw")
                .keyword("음식")
                .build();

        PageResponseDTO<FoodDTO> list = foodService.list(pageRequestDTO);
        log.info("list : " + list.toString());
    }
}
