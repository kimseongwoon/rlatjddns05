package org.zerock.t9.todo.vo;

import lombok.*;

//import java.sql.Date;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TodoVO {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    //private Date dueDate;
    private boolean finished;
}