package com.busanit501.bootme.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//data만 제공
@Log4j2
public class SampleRestController {

    @GetMapping("/hiRest")
    public String[] hiRest() {
        return new String[]{"hi", "Kimdohyeon"};
    }


}
