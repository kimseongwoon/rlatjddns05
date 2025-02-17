package org.zerock.w2.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
	private String mid;
	private String mpw;
	private String mname;
	private String uuid;
}
