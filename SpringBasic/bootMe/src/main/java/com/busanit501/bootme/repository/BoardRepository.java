package com.busanit501.bootme.repository;

import com.busanit501.bootme.domain.Board;
import com.busanit501.bootme.repository.search.BoardSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//extends JpaRepository<Board, Long> -> 기본 쿼리 메소드 이용해서,
// 간단한 crud 디비 작업은, 메서드를 이용해서 처리가 가능함.

public interface BoardRepository extends JpaRepository<Board, Long>, BoardSearch{
//public interface BoardRepository extends JpaRepository<Board, Long>{
    Page<Board> findByTitleContainingOrderByBnoDesc(String title, Pageable pageable);

    @Query("select b from Board b where b.title like concat('%',:keyword,'%')")
    Page<Board> findByKeyword(String keyword, Pageable pageable);





}
