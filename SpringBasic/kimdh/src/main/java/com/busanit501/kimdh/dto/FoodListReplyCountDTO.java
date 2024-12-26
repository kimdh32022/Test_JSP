package com.busanit501.kimdh.dto;
import lombok.Data;
import java.time.LocalDateTime;
@Data
public class FoodListReplyCountDTO {
    private Long id;
    private String fname;
    private String fmeteral;
    private String writer;
    private LocalDateTime regDate;

    private Long replyCount;
}
