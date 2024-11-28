package com.busanit501.helloworld.Member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class MemberDTO {
    private Long Uno;
    private String ID;
    private String Password;
    private String Uname;

}
