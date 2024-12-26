package com.busanit501.kimdh.service;

import com.busanit501.kimdh.dto.FoodDTO;
import com.busanit501.kimdh.dto.FoodListReplyCountDTO;
import com.busanit501.kimdh.dto.PageRequestDTO;
import com.busanit501.kimdh.dto.PageResponseDTO;

public interface FoodService {
    Long registerFood(FoodDTO foodDTO);

    FoodDTO readOneFood(Long id);

    void updateFood(FoodDTO foodDTO);

    void deleteFood(Long id);

    PageResponseDTO<FoodDTO> list(PageRequestDTO pageRequestDTO);

    PageResponseDTO<FoodListReplyCountDTO> listWithReplyCount(PageRequestDTO pageRequestDTO);
}
