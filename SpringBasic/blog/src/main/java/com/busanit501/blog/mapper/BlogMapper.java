package com.busanit501.blog.mapper;

import com.busanit501.blog.domain.BlogVO;
import com.busanit501.blog.dto.PageRequestDTO;

import java.util.List;

public interface BlogMapper {

    String getTime();

    void insert(BlogVO blogVO);

    List<BlogVO> selectAll();

    BlogVO selectOne(Long bno);

    void delete(Long bno);

    void update(BlogVO blogVO);

    //페이징한 전체 목록
    List<BlogVO> selectList(PageRequestDTO pageRequestDTO);

    // 페이징 위해서, 전체갯수,
    int getCount(PageRequestDTO pageRequestDTO);
}





