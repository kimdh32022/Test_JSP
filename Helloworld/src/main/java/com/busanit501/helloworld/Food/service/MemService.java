package com.busanit501.helloworld.Food.service;

import com.busanit501.helloworld.Food.Utill.MapperUtill;
import com.busanit501.helloworld.Food.dao.MemDAO;
import com.busanit501.helloworld.Food.dto.MemDTO;
import com.busanit501.helloworld.Food.vo.MemVO;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.sql.SQLException;

@Log4j2
public enum MemService {
    INSTANCE;

    private MemDAO memDAO;
    private ModelMapper modelMapper;

    MemService() {
        memDAO = new MemDAO();
        modelMapper = MapperUtill.INSTANCE.getMap();
    }

    public MemDTO login(String mid, String mpw) throws SQLException {
        MemVO memVO = memDAO.getMemberWithMpw(mid, mpw);
        MemDTO memDTO = modelMapper.map(memVO, MemDTO.class);
        return memDTO;
    }
    public void updateUuid(String mid,String uuid) throws SQLException {
        memDAO.updateUuid(mid, uuid);
    }
    public MemDTO getMemberWithUuidService(String uuid) throws SQLException {
        MemVO memVO= memDAO.getMemberWithUuid(uuid);
        MemDTO memDTO = modelMapper.map(memVO, MemDTO.class);
        return memDTO;
    }
}
