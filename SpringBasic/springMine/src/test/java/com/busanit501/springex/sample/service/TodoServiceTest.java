package com.busanit501.springex.sample.service;

import com.busanit501.springex.dto.TodoDTO;
import com.busanit501.springex.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@Log4j2
@ExtendWith(SpringExtension.class) //JUnit5 테스트 설정.
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoServiceTest {

    @Autowired
    private TodoService todoService;


    @Test
    public void testRegister() {
        TodoDTO todoDTO = TodoDTO.builder()
                .title("데이터2")
                .dueDate(LocalDate.now())
                .writer("김도현")
                .build();

        todoService.register(todoDTO);
    }



}
