package com.busanit501.kimdh.service;

import com.busanit501.kimdh.domain.Food;
import com.busanit501.kimdh.domain.food_Reply;
import com.busanit501.kimdh.dto.PageRequestDTO;
import com.busanit501.kimdh.dto.PageResponseDTO;
import com.busanit501.kimdh.dto.ReplyDTO;
import com.busanit501.kimdh.repository.FoodRepository;
import com.busanit501.kimdh.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class ReplyServiceImpl implements ReplyService {

    private final ReplyRepository replyRepository;

    private final FoodRepository foodRepository;

    private final ModelMapper modelMapper;

    @Override
    public Long register(ReplyDTO replyDTO) {
        food_Reply reply = modelMapper.map(replyDTO, food_Reply.class);
        Optional<Food> result = foodRepository.findById(replyDTO.getId());
        Food food = result.orElseThrow();
        reply.changeFood(food);
        Long rno = replyRepository.save(reply).getRno();
        return rno;
    }

    @Override
    public ReplyDTO readOne(Long rno) {
        Optional<food_Reply> result = replyRepository.findById(rno);
        food_Reply reply = result.orElseThrow();
        ReplyDTO replyDTO = modelMapper.map(reply, ReplyDTO.class);
        return replyDTO;
    }

    @Override
    public void update(ReplyDTO replyDTO) {
        Optional<food_Reply> result = replyRepository.findById(replyDTO.getRno());
        food_Reply reply = result.orElseThrow();
        reply.changeReplyTextReplyer(replyDTO.getReplyText(), replyDTO.getReplyer());
        replyRepository.save(reply);
    }

    @Override
    public void delete(Long rno) {
        replyRepository.deleteById(rno);
    }

    @Override
    public PageResponseDTO<ReplyDTO> listWithReply(Long id, PageRequestDTO pageRequestDTO) {
        Pageable pageable = PageRequest.of(pageRequestDTO.getPage() - 1 <= 0 ? 0 : pageRequestDTO.getPage() - 1,
                pageRequestDTO.getSize(), Sort.by("rno").ascending());
        Page<food_Reply> result = replyRepository.listOfFood(id, pageable);

        List<ReplyDTO> dtoList = result.getContent().stream()
                .map(reply -> {
                    ReplyDTO replyDTO = modelMapper.map(reply, ReplyDTO.class);
                    replyDTO.setId(reply.getFood().getId());
                    return replyDTO;
                })
                .collect(Collectors.toList());

        PageResponseDTO<ReplyDTO> pageResponseDTO = PageResponseDTO.<ReplyDTO>withAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total((int)result.getTotalElements())
                .build();

        return pageResponseDTO;
    }
}
