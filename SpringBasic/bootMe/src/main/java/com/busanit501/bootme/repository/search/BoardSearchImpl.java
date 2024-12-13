package com.busanit501.bootme.repository.search;

import com.busanit501.bootme.domain.Board;
import com.busanit501.bootme.domain.QBoard;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class BoardSearchImpl extends QuerydslRepositorySupport implements BoardSearch {

    public BoardSearchImpl() {
        super(Board.class);
    }

    @Override
    public Page<Board> search(Pageable pageable) {
        //테이블 조회
        QBoard board = QBoard.board;
        JPQLQuery<Board> query = from(board);
        //where절로 조회
        query.where(board.title.contains("3"));
        //페이징 조건을 추가하기. 쿼리에 페이징 조건을 추가하기
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        booleanBuilder.or(board.title.contains("3"));
        booleanBuilder.or(board.content.contains("7"));
        query.where(booleanBuilder);
        // 추가 조건으로 bno가 0번 보다 큰 경우
        query.where((board.bno.gt(0L)));
        // 제목 ,작성자 검색 조건 추가
        this.getQuerydsl().applyPagination(pageable, query);
        //나타내기
        List<Board> list = query.fetch();
        long total = query.fetchCount();

        return null;
    }

    @Override
    public Page<Board> searchAll(String[] types, String keyword, Pageable pageable) {
        QBoard board = QBoard.board;
        JPQLQuery<Board> query = from(board);
        if (types != null && types.length > 0 && keyword != null) {
            BooleanBuilder booleanBuilder = new BooleanBuilder();
            for (String type : types) {
                switch (type) {
                    case "t":
                        booleanBuilder.or(board.title.contains(keyword));
                    case "c":
                        booleanBuilder.or(board.content.contains(keyword));
                    case "w":
                        booleanBuilder.or(board.writer.contains(keyword));
                }//switch
            }//for
            query.where(booleanBuilder);
        }//if
        query.where((board.bno.gt(0L)));

        this.getQuerydsl().applyPagination(pageable, query);
        //데이터 가져오기
        List<Board> list = query.fetch();
        //검색 조건에 맞는 데이터 갯수 조회
        long total = query.fetchCount();
        //page타입으로 전달하기
        Page<Board> result = new PageImpl<Board>(list, pageable, total);
        return result;
    }
}
