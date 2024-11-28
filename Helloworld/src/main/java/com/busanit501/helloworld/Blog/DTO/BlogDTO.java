package com.busanit501.helloworld.Blog.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
// DTO는 내가 화면에 표현할 것들만
// VO는 데이터베이스랑 칼럼들이 모두 있다.
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class BlogDTO {
    private long Bno;
    private String title;
    private String content;
    private Date Bdate;


}
