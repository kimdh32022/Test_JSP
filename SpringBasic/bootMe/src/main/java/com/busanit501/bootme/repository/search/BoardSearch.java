package com.busanit501.bootme.repository.search;

import com.busanit501.bootme.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface BoardSearch {
    //연습용, 자바 문법으로 SQL 문장 전달해보기
    Page<Board> search(Pageable pageable);

    Page<Board> searchAll(String[] types,String keyword, Pageable pageable);
}
