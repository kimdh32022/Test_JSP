package com.busanit501.helloworld.Member.service;

import com.busanit501.helloworld.Member.dao.MemberDAO;
import com.busanit501.helloworld.Member.dto.MemberDTO;
import com.busanit501.helloworld.Member.vo.MemberVO;
import com.busanit501.helloworld.food.Utill.MapperUtill;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public enum MemberService {
    INSTANCE;

    private MemberDAO memberDAO;
    private ModelMapper modelMapper;

    MemberService() {
        memberDAO = new MemberDAO();
        modelMapper = MapperUtill.INSTANCE.getMap();
    }

    // 1 등록
    public void register(MemberDTO memberDTO) throws SQLException {
        MemberVO memberVO = modelMapper.map(memberDTO, MemberVO.class);
        memberDAO.insert(memberVO);
    }
    // 2 전체 조회
//    public List<MemberDTO> listAll() throws SQLException {
//        List<MemberVO> volist = memberDAO.selectAll();
//        List<MemberDTO> list = volist.stream().map(vo -> modelMapper.map(vo, MemberDTO.class))
//                .collect(Collectors.toList());
//        return list;
//    }
    public List<MemberDTO> listAll() throws SQLException {
        log.info("회원 전체 목록 조회 시작");
        List<MemberVO> volist = memberDAO.selectAll();
        log.debug("DAO에서 반환된 VO 리스트 크기: {}", volist.size());

        List<MemberDTO> list = volist.stream()
                .map(vo -> modelMapper.map(vo, MemberDTO.class))
                .collect(Collectors.toList());
        log.info("DTO 변환 완료: {} 개의 회원 조회", list.size());
        return list;
    }
    // 3 하나 조회
    public MemberDTO get(Long Uno) throws SQLException {
        MemberVO memberVO = memberDAO.selectOne(Uno);
        MemberDTO memberDTO = modelMapper.map(memberVO, MemberDTO.class);
        return memberDTO;
    }
    // 4 수정기능
    public void update(MemberDTO memberDTO) throws SQLException {
        MemberVO memberVO = modelMapper.map(memberDTO, MemberVO.class);
        memberDAO.updatedata(memberVO);
    }
    // 5 삭제기능
    public void delete(Long Uno) throws SQLException {
        memberDAO.deletedata(Uno);
    }
}
