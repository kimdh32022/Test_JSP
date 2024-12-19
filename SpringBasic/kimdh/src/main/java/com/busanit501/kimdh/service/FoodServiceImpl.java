package com.busanit501.kimdh.service;

import com.busanit501.kimdh.domain.Food;
import com.busanit501.kimdh.dto.FoodDTO;
import com.busanit501.kimdh.dto.PageRequestDTO;
import com.busanit501.kimdh.dto.PageResponseDTO;
import com.busanit501.kimdh.repository.FoodRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;
    private final ModelMapper modelMapper;

    @Override
    public Long registerFood(FoodDTO foodDTO) {
        Food food = modelMapper.map(foodDTO, Food.class);
        Long id = foodRepository.save(food).getId();
        return id;
    }

    @Override
    public FoodDTO readOneFood(Long id) {
        Optional<Food> result = foodRepository.findById(id);
        Food food = result.orElseThrow();
        FoodDTO dto = modelMapper.map(food, FoodDTO.class);
        return dto;
    }

    @Override
    public void updateFood(FoodDTO foodDTO) {
        Optional<Food> result = foodRepository.findById(foodDTO.getId());
        Food food = result.orElseThrow();
        food.changeFood(foodDTO.getFname(),foodDTO.getFmeteral());
        foodRepository.save(food);
    }

    @Override
    public void deleteFood(Long id) {
        foodRepository.deleteById(id);
    }

    @Override
    public PageResponseDTO<FoodDTO> list(PageRequestDTO pageRequestDTO) {
        String[] types = pageRequestDTO.getTypes();
        String keyword = pageRequestDTO.getKeyword();
        Pageable pageable = pageRequestDTO.getPageable("id");

        Page<Food> result = foodRepository.searchAll(types,keyword,pageable);

        List<FoodDTO> dtoList = result.stream()
                .map(x -> modelMapper.map(x, FoodDTO.class))
                .collect(Collectors.toList());

        return PageResponseDTO.<FoodDTO>withAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total((int) result.getTotalElements())
                .build();
    }
}
