package com.busanit501.springex.service;

import com.busanit501.springex.dto.FoodDTO;
import com.busanit501.springex.dto.PageRequestDTO;
import com.busanit501.springex.dto.PageResponseDTO;

import java.util.List;

public interface FoodService {

    void register(FoodDTO foodDTO);

    List<FoodDTO> getAll();

    PageResponseDTO<FoodDTO> getFoods(PageRequestDTO pageRequestDTO);

    FoodDTO getOne(Long tno);

    void delete(Long tno);

    void update(FoodDTO foodDTO);


}
