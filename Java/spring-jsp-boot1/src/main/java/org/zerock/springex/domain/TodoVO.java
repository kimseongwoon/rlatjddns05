package org.zerock.springex.domain;

import lombok.*;

import java.time.LocalDate;

@Getter   // 멤버필드에 있는 속성에 대한 getter메소드를 생성
@Builder  // Builder패턴을 생성 -> TodoVO.builder().속성1.속성2.build()
@ToString // ToString() 메소드 생성
@NoArgsConstructor
@AllArgsConstructor
public class TodoVO {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private String writer;
    private boolean finished;
}
