package com.busanit501.blog.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BlogVO {
    private Long bno;
    private String title;
    private String content;
    private LocalDate date;
    private String writer;
}