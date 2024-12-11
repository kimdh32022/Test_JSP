package com.busanit501.springex.service;

import com.busanit501.springex.dto.PageRequestDTO;
import com.busanit501.springex.dto.PageResponseDTO;
import com.busanit501.springex.dto.TodoDTO;

import java.util.List;

public interface TodoService {
    void register(TodoDTO todoDTO);

    List<TodoDTO> getAll();

//    PageResponseDTO<TodoDTO> getListWithPage(PageRequestDTO pageRequestDTO);

    TodoDTO getOne(Long tno);

    void delete(Long tno);

    void update(TodoDTO todoDTO);

    PageResponseDTO<TodoDTO> selectList(PageRequestDTO pageRequestDTO);

}
