package com.busanit501.helloworld.food.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class FoodVO {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
    //VO (value object)
    //사용용도 : 직접적인 데이터 베이스와 연동하는 클래스
}