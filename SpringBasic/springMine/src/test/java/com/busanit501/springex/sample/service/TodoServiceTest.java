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
import java.util.List;

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
    @Test
    public void testGetAll() {
        List<TodoDTO> list = todoService.getAll();
        for (TodoDTO todoDTO:list) {
            log.info("todoDTO : " + todoDTO);
        }
    } //
    @Test
    public void testUpdate() {
        // 업데이트 할 더미 데이터 필요, TodoVO
        TodoDTO todoDTO = TodoDTO.builder()
                .tno(5L)
                .title("수정1")
                .dueDate(LocalDate.now())
                .finished(true)
                .build();

        todoService.update(todoDTO);
    }
//    @Test
//    public void testPageList() {
//        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
//                .page(31)
//                .size(10)
//                .build();
//
//        PageResponseDTO<TodoDTO> list = todoService.selectList(pageRequestDTO);
//        list.getDtolist().stream().forEach(dto -> log.info("dto : " + dto));
//        log.info("list total: " + list.getTotal());
//        log.info("list prev: " + list.isPrev());
//        log.info("list next : " + list.isNext());
//        log.info("list start: " + list.getStart());
//        log.info("list end: " + list.getEnd());
//
//    }



}
