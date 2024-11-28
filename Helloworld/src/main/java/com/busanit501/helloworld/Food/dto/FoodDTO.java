package com.busanit501.helloworld.Food.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data //get,set,toString,hashCode, equals
@AllArgsConstructor
@NoArgsConstructor

public class FoodDTO {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;

}
