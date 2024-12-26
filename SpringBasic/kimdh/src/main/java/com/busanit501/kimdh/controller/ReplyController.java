package com.busanit501.kimdh.controller;

import com.busanit501.kimdh.dto.PageRequestDTO;
import com.busanit501.kimdh.dto.PageResponseDTO;
import com.busanit501.kimdh.dto.ReplyDTO;
import com.busanit501.kimdh.service.ReplyService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.awt.*;
import java.util.Map;

@RestController
@RequestMapping("/replies")
@Log4j2
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;


    @Tag(name = "댓글 등록", description = "댓글 등록진행")
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Map<String,Long>> register(
            @Valid @RequestBody ReplyDTO replyDTO,
            BindingResult bindingResult
    ) throws BindException {
        log.info(" ReplyController replyDTO: ", replyDTO);
        // 확인용, 더미 데이터 ,

        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        }
        Long rno = replyService.register(replyDTO);
        Map<String,Long> map = Map.of("rno",rno);
        return ResponseEntity.ok(map);
    }

    @Tag(name = "댓글 목록 조회",description = "댓글 목록 조회 RESTful get방식")
    @GetMapping(value ="/list/{id}")
    public PageResponseDTO<ReplyDTO> getList(@PathVariable("id") Long id, PageRequestDTO pageRequestDTO)
    {
        PageResponseDTO<ReplyDTO> responseDTO = replyService.listWithReply(id, pageRequestDTO);
        return responseDTO;
    }

    @Tag(name = "댓글 하나 조회",description = "댓글 하나 조회 RESTful get방식")
    @GetMapping(value ="/{rno}")
    public ReplyDTO getRead(@PathVariable("rno") Long rno)
    {
        log.info(" ReplyController getRead: rno={}", rno);
        ReplyDTO replyDTO = replyService.readOne(rno);
        return replyDTO;
    }

    @Tag(name = "댓글 수정 로직처리",description = "댓글 수정 로직처리 RESTful get방식")
    @PutMapping(value ="/{rno}")
    public Map<String,Long> updateReply(
            @Valid @RequestBody ReplyDTO replyDTO,
            BindingResult bindingResult,
            @PathVariable("rno") Long rno) throws BindException {
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        }
        replyService.update(replyDTO);
        Map<String,Long> map = Map.of("rno",rno);
        return map;
    }

    @Tag(name = "댓글 삭제 로직처리",description = "댓글 삭제 로직처리 RESTful get방식")
    @DeleteMapping(value ="/{rno}")
    public Map<String,Long> deleteReply(
            @PathVariable("rno") Long rno) throws BindException {
        replyService.delete(rno);
        Map<String,Long> map = Map.of("rno",rno);
        return map;
    }
}
