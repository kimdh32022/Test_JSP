package com.busanit501.helloworld.food.service;

import com.busanit501.helloworld.food.dto.FoodDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//열거형 상수들,
//상수들의 집합, 모음집
public enum FoodService {
    INSTANCE;

    // 글 등록하는 기능.
    public void register(FoodDTO foodDTO) {
        // 디비에 데이터를 쓰는 작업, insert
        System.out.println("글쓰기 작업하는 기능입니다.");
    }

    public List<FoodDTO> getList() {
        List<FoodDTO> foodList = IntStream.range(0,10).mapToObj(
                i -> {
                    // 10 반복 해서, 더미 인스턴스 10개 생성,
                    FoodDTO foodDTO = new FoodDTO();
                    foodDTO.setTitle("테스트AA " + i);
                    foodDTO.setTno((long) i);
                    foodDTO.setDueDate(LocalDate.now());
                    return  foodDTO;
                }).collect(Collectors.toList());
        return foodList;
    }

    // 하나 조회, 상세보기 , 게시글에서, 게시글 번호 클릭시 나타나는 데이터
    public FoodDTO getOne(Long tno) {
        FoodDTO foodDTO = new FoodDTO();
        foodDTO.setTno(5L);
        foodDTO.setTitle("하나 조회 더미 데이터");
        foodDTO.setDueDate(LocalDate.now());
        return foodDTO;
    }

}

