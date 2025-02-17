package org.zerock.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.w2.dao.TodoDAO;
import org.zerock.w2.domain.TodoVO;

import java.time.LocalDate;
import java.util.List;

public class TodoDAOTests {
    private TodoDAO todoDAO;

    @BeforeEach // @Test 메소드를 실행하기전에 무조건 실행하는 어노테이션
    public void ready() {
        todoDAO = new TodoDAO();

        System.out.println("이거 계속 실행이 정말 되니?");
    }

    // getTime() 메소드 테스트
    @Test
    public void testTime() throws Exception {
        // TodoDAO에 있는 getTime메소드를 실행하여 테스트
        System.out.println("현재시간: " + todoDAO.getTime());
    }

    @Test
    public void testTime2() throws Exception {
        // TodoDAO에 있는 getTime2메소드를 실행하여 테스트
        System.out.println("현재시간: " + todoDAO.getTime2());
    }

    @Test
    public void testInsert() throws Exception {
        // builder패턴을 사용한 객체 생성
        TodoVO todoVO = TodoVO.builder()
                .title("Sample Title...")
                .dueDate(LocalDate.of(2021, 12, 31))
                .build();
//        TodoVO todoVO1 = new TodoVO();
//        todoVO1.setTitle("Sample Title...")
//        todoVO1.setDue_date("Sample Title...")

        todoDAO.insert(todoVO);
    }

    @Test
    public void testList() throws Exception {
        List<TodoVO> list = todoDAO.selectAll();

        list.forEach(vo -> System.out.println(vo));
    }

    @Test
    public void testSelectOne() throws Exception {
        TodoVO todoVO = todoDAO.selectOne(1L);
        System.out.println(todoVO);
    }

    @Test
    public void testUpdateOne() throws Exception {
        TodoVO todoVO = TodoVO.builder()
                .tno(1L)
                .title("Sample Title...")
                .dueDate(LocalDate.of(2021,12,31))
                .finished(true)
                .build();

        todoDAO.updateOne(todoVO);
    }
}
