package com.busanit501.helloworld.Blog.Service;


import com.busanit501.helloworld.Blog.DAO.BlogDAO;
import com.busanit501.helloworld.Blog.DTO.BlogDTO;
import com.busanit501.helloworld.Blog.DTO.BlogVO;
import com.busanit501.helloworld.Food.Utill.MapperUtill;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public enum BlogService {
    INSTANCE;

    private BlogDAO blogDAO;
    private ModelMapper modelMapper;

    BlogService() {
        blogDAO = new BlogDAO();
        modelMapper = MapperUtill.INSTANCE.getMap();
    }


    // 화면에서 등록된 내용이 DTO파일에 담아서 서비스 계층에 전달
    //DAO 작업 시, 디비에서 직접적인 영향을 주는 객체
    //VO  실제 비지니스 로직에서만 사용
    // 1 등록
    public void register(BlogDTO blogDTO) throws SQLException {
        BlogVO foodVO = modelMapper.map(blogDTO, BlogVO.class);
        log.info("foodVO : "+ foodVO);
        blogDAO.insertBlog(foodVO);
    }
    // 2 전체 조회
    public List<BlogDTO> listAll() throws SQLException {
        List<BlogVO> volist = blogDAO.selectAllBlog();
        log.info("volist : "+ volist);
        List<BlogDTO> dtolist = volist.stream().map(vo -> modelMapper.map(vo, BlogDTO.class))
                .collect(Collectors.toList());
        return dtolist;
    }
    // 3 하나만 조회
    public BlogDTO getOne(Long bno) throws SQLException {
        log.info("bno : "+ bno);
        BlogVO blogVO = blogDAO.selectone(bno);
        BlogDTO blogdto = modelMapper.map(blogVO, BlogDTO.class);
        return blogdto;
    }
    // 4

}
