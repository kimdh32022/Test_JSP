package com.busanit501.helloworld.Member.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class MemberVO {
    private Long Uno;
    private String ID;
    private String Password;
    private String Uname;

}