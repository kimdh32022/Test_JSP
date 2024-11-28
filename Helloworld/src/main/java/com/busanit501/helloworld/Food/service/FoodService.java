package com.busanit501.helloworld.Food.service;

import com.busanit501.helloworld.Food.Utill.MapperUtill;
import com.busanit501.helloworld.Food.dao.FoodDAO;
import com.busanit501.helloworld.Food.dto.FoodDTO;
import com.busanit501.helloworld.Food.vo.FoodVO;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public enum FoodService {
    INSTANCE;

    private FoodDAO foodDAO;
    private ModelMapper modelMapper;

    FoodService() {
        foodDAO = new FoodDAO();
        modelMapper = MapperUtill.INSTANCE.getMap();
    }

    // 1 등록
    // 화면에서 등록된 내용이 DTO파일에 담아서 서비스 계층에 전달
    //DAO 작업 시, 디비에서 직접적인 영향을 주는 객체
    //VO  실제 비지니스 로직에서만 사용
    // 1 추가하기
    public void register(FoodDTO foodDTO) throws SQLException {
        FoodVO foodVO = modelMapper.map(foodDTO, FoodVO.class);
        log.info("foodVO : "+ foodVO);
        foodDAO.insert(foodVO);
    }
    // 2 전체 조회
    public List<FoodDTO> listAll() throws SQLException {
        List<FoodVO> volist = foodDAO.selectAll();
        log.info("volist : "+ volist);
        List<FoodDTO> dtolist = volist.stream().map(vo -> modelMapper.map(vo, FoodDTO.class))
                .collect(Collectors.toList());
        return dtolist;
    }
    // 3 하나 조회
    public FoodDTO get(Long tno) throws SQLException {
        log.info("tno : "+ tno);
        FoodVO foodVO = foodDAO.selectOne(tno);
        FoodDTO foodDTO = modelMapper.map(foodVO, FoodDTO.class);
        return foodDTO;
    }
    // 4 수정기능
    public void update(FoodDTO foodDTO) throws SQLException {
        log.info("foodDTO : "+ foodDTO);
        FoodVO foodVO = modelMapper.map(foodDTO, FoodVO.class);
        foodDAO.updatedata(foodVO);
    }
    // 5 삭제기능
    public void delete(Long tno) throws SQLException {
        foodDAO.deletedata(tno);
    }
}
