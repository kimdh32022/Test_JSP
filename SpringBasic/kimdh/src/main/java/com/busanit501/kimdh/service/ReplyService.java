package com.busanit501.kimdh.service;

import com.busanit501.kimdh.dto.PageRequestDTO;
import com.busanit501.kimdh.dto.PageResponseDTO;
import com.busanit501.kimdh.dto.ReplyDTO;

public interface ReplyService {
    Long register(ReplyDTO replyDTO);
    ReplyDTO readOne(Long rno);
    void update(ReplyDTO replyDTO);

    void delete(Long rno);

    PageResponseDTO<ReplyDTO> listWithReply(Long id, PageRequestDTO pageRequestDTO);
}
