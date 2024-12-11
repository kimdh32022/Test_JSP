package com.busanit501.springex.service;

import com.busanit501.springex.domain.FoodVO;
import com.busanit501.springex.dto.FoodDTO;
import com.busanit501.springex.dto.PageRequestDTO;
import com.busanit501.springex.dto.PageResponseDTO;
import com.busanit501.springex.mapper.FoodMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor

public class FoodServiceImpl implements FoodService{

    private final FoodMapper foodMapper;
    private final ModelMapper modelMapper;

    @Override
    public void register(FoodDTO foodDTO) {
       FoodVO foodVO = modelMapper.map(foodDTO, FoodVO.class);
        foodMapper.insert(foodVO);
    }

    @Override
    public PageResponseDTO<FoodDTO> getFoods(PageRequestDTO pageRequestDTO) {
        int total = foodMapper.getCount(pageRequestDTO);

        List<FoodDTO> dtoList = foodMapper.selectList(pageRequestDTO).stream()
                .map(food -> modelMapper.map(food, FoodDTO.class))
                .collect(Collectors.toList());

        PageResponseDTO<FoodDTO> pageResponseDTO = PageResponseDTO.<FoodDTO>withAll()
                .total(total)
                .dtoList(dtoList)
                .pageRequestDTO(pageRequestDTO)
                .build();

        return pageResponseDTO;
    }

    @Override
    public List<FoodDTO> getAll() {
       List<FoodDTO> list = foodMapper.selectAll().stream()
               .map(vo-> modelMapper.map(vo,FoodDTO.class))
               .collect(Collectors.toList());
        return list;
    }

    @Override
    public FoodDTO getOne(Long tno) {
        FoodVO foodVO = foodMapper.selectOne(tno);
        FoodDTO foodDTO = modelMapper.map(foodVO,FoodDTO.class);
        return foodDTO;
    }

    @Override
    public void delete(Long tno) {
        foodMapper.delete(tno);
    }

    @Override
    public void update(FoodDTO foodDTO) {
        FoodVO foodVO = modelMapper.map(foodDTO, FoodVO.class);
        foodMapper.update(foodVO);
    }
}
