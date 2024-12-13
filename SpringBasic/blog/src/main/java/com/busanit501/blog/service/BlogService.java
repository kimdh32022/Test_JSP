package com.busanit501.blog.service;

import com.busanit501.blog.dto.PageRequestDTO;
import com.busanit501.blog.dto.PageResponseDTO;
import com.busanit501.blog.dto.BlogDTO;

import java.util.List;

public interface BlogService {
    void register(BlogDTO blogDTO);

    List<BlogDTO> getAll();


    PageResponseDTO<BlogDTO> selectList(PageRequestDTO pageRequestDTO);


    BlogDTO getOne(Long tno);

    void delete(Long tno);

    void update(BlogDTO blogDTO);
}
