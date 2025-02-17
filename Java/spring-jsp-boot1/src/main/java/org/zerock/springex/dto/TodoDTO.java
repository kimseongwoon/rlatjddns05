package org.zerock.springex.dto;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoDTO {
	private Long tno;
	@NotEmpty(message = "타이틀은 비어있을 수 없음")  // 타이틀은 빈 값이 있으면 안됨
    private String title;	
	//@FutureOrPresent		// 할일에 대한 날짜는 현재날짜 포함해서 미래가 될 수 있도록 설정
	@Future		// 할일에 대한 날짜는 현재보다 항상 미래가 될 수 있도록 설정
    private LocalDate dueDate;
    private boolean finished;
    @NotEmpty
    private String writer;  // 새로 추가됨
}