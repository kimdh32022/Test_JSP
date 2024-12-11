package com.busanit501.springex.mapper;

import com.busanit501.springex.domain.FoodVO;
import com.busanit501.springex.dto.PageRequestDTO;

import java.util.List;

public interface FoodMapper {

    String getTime();
    // 등록
    void insert(FoodVO foodvo);
    // 전체 조회
    List<FoodVO> selectAll();
    // 하나 조회
    FoodVO selectOne(Long tno);
    // 삭제
    void delete(Long tno);
    // 업데이트
    void update(FoodVO foodvo);
    //페이징
    List<FoodVO> selectList(PageRequestDTO pageRequestDTO);

    int getCount(PageRequestDTO pageRequestDTO);
    // 검색



}
