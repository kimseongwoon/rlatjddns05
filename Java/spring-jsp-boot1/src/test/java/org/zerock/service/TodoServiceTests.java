package org.zerock.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.w2.dto.TodoDTO;
import org.zerock.w2.service.TodoService;

import java.time.LocalDate;

@Log4j2
public class TodoServiceTests {
    private TodoService todoService;

    @BeforeEach // @Test 메소드를 실행하기전에 무조건 실행하는 어노테이션
    public void ready() {
        todoService = TodoService.INSTANCE;
    }

    @Test
    public void testRegister() throws Exception {
        TodoDTO todoDTO = TodoDTO.builder()
                .title("JDBC Test Title")
                .dueDate(LocalDate.now())
                .build();

        log.info("--------------------------");
        log.info(todoDTO);

        todoService.register(todoDTO);
    }
}
