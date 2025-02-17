package org.zerock.w2.domain;

import lombok.*;

/**
 * tbl_member테이블의 내용과 관계된 Model의 VO클래스
 */
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {
	private String mid;
	private String mpw;
	private String mname;
	private String uuid;
}
