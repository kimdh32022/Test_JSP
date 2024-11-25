package com.busanit501.helloworld.Blog.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class BlogVO {
    private long Bno;
    private String title;
    private String content;
    private Date Bdate;

}
