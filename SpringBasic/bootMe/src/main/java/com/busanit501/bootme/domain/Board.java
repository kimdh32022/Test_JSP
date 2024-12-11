package com.busanit501.bootme.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity// JPA를 이용해서 엔티티 클래스로 데이터 베이스 테이블 만들기 놀이.
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Board extends BaseEntity{
    @Id // 기본키 역할 에너테이션
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(length = 2000, nullable = false)
    private String content;

    @Column(length = 50, nullable = false)
    private String writer;
    // 모든 테이블에 공통으로 들어갈 수 있는 등록시간, 수정시간 등
    // 베이스 엔티티에서 작업할 예정


    public void changeTitleContent(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
