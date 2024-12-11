package com.busanit501.bootme.repository;

import com.busanit501.bootme.domain.Board;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class BoardReopositoryTests {

    @Autowired
    // 아무 메소드가 없지만, 기본 탑재된 쿼리 메소드 이용해서, crud  해보기.
    private BoardRepository boardRepository;

    @Test
    public void testInsert() {
        // 더미 데이터, 앞에서, 병렬 처리 기능 사용하기.
        // stream 클래스 이용하기.
        // 1 ~ 99번까지 생성해요.
        IntStream.range(1, 100).forEach(i -> {
            Board board = Board.builder()
                    .title("샘플 제목 : " + i)
                    .content("샘플 내용 : " + i)
                    .writer("샘플 작성자 : lsy " + i)
                    .build();
            // crud, insert , save-> 1차 임시 테이블 저장 -> 실제 테이블 반영
            Board result = boardRepository.save(board);
            log.info("추가된 bno 번호 : " + result);
        });
    }

    @Test
    public void testSelectOne() {
        Long bno = 199L;
        //있으면 해당 인스터스를 가져오고 없으면 null임.
        Optional<Board> result = boardRepository.findById(bno);
        Board board = result.orElseThrow();
        log.info("하나 조회 : " + board);
    }

    @Test
    public void testUpdate() {
        Long bno = 99L;
        Optional<Board> result = boardRepository.findById(bno);
        Board board = result.orElseThrow();
        board.changeTitleContent("유명한 제목","해리포터의 불의잔");
        boardRepository.save(board);

    }

    @Test
    public void testDelete() {
        Long bno = 99L;
        boardRepository.deleteById(bno);
    }

    @Test
    public void testSelectAll() {
        List<Board> result = boardRepository.findAll();
        for (Board board : result) {
            log.info(board);
        }
    }

    @Test
    public void testPaging() {
        Pageable pageable = PageRequest.of(3, 10,
                Sort.by("bno").ascending());
        Page<Board> result = boardRepository.findAll(pageable);
        log.info("result.getTotalElements()전체 페이지의 갯수 : " + result.getTotalElements());
        log.info("result.getTotalPages()총페이지등 :" +result.getTotalPages());
        log.info("result.getTotalPages()페이징된 결과물  :" +result.getContent());
    }
// 방법 1 쿼리 스트링
    @Test
    public void testQueryString() {
        Pageable pageable =  PageRequest.of(1, 10,
                Sort.by("bno").descending());
        Page<Board> result = boardRepository.findByTitleContainingOrderByBnoDesc(
                "샘플",pageable
        );
        log.info("result.getTotalElements()전체 갯수 :" +result.getTotalElements());
        log.info("result.getTotalPages()총페이지등 :" +result.getTotalPages());
        log.info("result.getContent() 페이징된 결과물 10개 :" +result.getContent());
        log.info("result.getNumber() 현재 페이지 번호 :" +result.getNumber());
        log.info("result.getSize() 크기  :" +result.getSize());
    }
// 방법 2 쿼리 어노테이션
    @Test
    public void testQueryAnotation() {
        Pageable pageable =  PageRequest.of(1, 10,
                Sort.by("bno").descending());
        Page<Board> result = boardRepository.findByKeyword("3",pageable);
        log.info("result.getTotalElements()전체 갯수 :" +result.getTotalElements());
        log.info("result.getTotalPages()총페이지등 :" +result.getTotalPages());
        log.info("result.getContent() 페이징된 결과물 10개 :" +result.getContent());
        log.info("result.getNumber() 현재 페이지 번호 :" +result.getNumber());
        log.info("result.getSize() 크기  :" +result.getSize());
    }
    // 방법 3 쿼리dsl
    @Test
    public void testQuerydsl() {
        Pageable pageable = PageRequest.of(1, 10,
                Sort.by("bno").descending());
//        Page<Board> result = boardRepository.search(pageable);
        boardRepository.search(pageable);
    }

}
