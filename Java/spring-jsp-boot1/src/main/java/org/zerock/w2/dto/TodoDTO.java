package org.zerock.w2.dto;

import lombok.*;

import java.sql.Date;
import java.time.LocalDate;

//@Data  // @Getter @Setter @ToString 이런 것들을 전부 포함한 어노테이션
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoDTO {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
    
    @Override
    public String toString() {
//    	return "할일들 -> tno=" + tno +
//    			       ", title=" + title +
//    			       ", dueDate=" + Date.valueOf(dueDate) +
//    			       ", finished=" + finished
//    			       ;
    	return Date.valueOf(dueDate) + ": " + title + "(마침여부: " + finished + ")";
    			        
    }
}
