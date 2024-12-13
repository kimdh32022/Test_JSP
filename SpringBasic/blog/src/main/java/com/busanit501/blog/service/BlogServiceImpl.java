package com.busanit501.blog.service;

import com.busanit501.blog.domain.BlogVO;
import com.busanit501.blog.dto.PageRequestDTO;
import com.busanit501.blog.dto.PageResponseDTO;
import com.busanit501.blog.dto.BlogDTO;
import com.busanit501.blog.mapper.BlogMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService {

    private final BlogMapper blogMapper;
    private final ModelMapper modelMapper;

    @Override
    public void register(BlogDTO blogDTO) {
        BlogVO blogVO = modelMapper.map(blogDTO, BlogVO.class);
        blogMapper.insert(blogVO);

    }
    @Override
    public List<BlogDTO> getAll() {
        List<BlogDTO> list = blogMapper.selectAll().stream()
                .map(vo -> modelMapper.map(vo,BlogDTO.class))
                .collect(Collectors.toList());
        return list;
    }



    @Override
    public BlogDTO getOne(Long tno) {
        BlogVO blogVO= blogMapper.selectOne(tno);
        BlogDTO blogDTO = modelMapper.map(blogVO,BlogDTO.class);
        return blogDTO;
    }

    @Override
    public void delete(Long tno) {
        blogMapper.delete(tno);
    }

    @Override
    public void update(BlogDTO blogDTO) {
        BlogVO blogVO = modelMapper.map(blogDTO,BlogVO.class);
        blogMapper.update(blogVO);

    }

    @Override
    public PageResponseDTO<BlogDTO> selectList(PageRequestDTO pageRequestDTO) {
        int total = blogMapper.getCount(pageRequestDTO);

        List<BlogDTO> dtoList = blogMapper.selectList(pageRequestDTO).stream()
                .map(vo -> modelMapper.map(vo,BlogDTO.class))
                .collect(Collectors.toList());
        PageResponseDTO<BlogDTO> pageResponseDTO = PageResponseDTO.<BlogDTO>withAll()
                .total(total)
                .dtoList(dtoList)
                .pageRequestDTO(pageRequestDTO)
                .build();

        return pageResponseDTO;
    }



}
