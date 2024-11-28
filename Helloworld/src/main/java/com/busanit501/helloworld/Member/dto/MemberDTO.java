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
    private Long uno;
    private String id;
    private String password;
    private String uname;

}
