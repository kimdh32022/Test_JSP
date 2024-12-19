package com.busanit501.kimdh.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FoodDTO {
    private Long id;
    private String fname;
    private String fmeteral;
    private String writer;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
}
