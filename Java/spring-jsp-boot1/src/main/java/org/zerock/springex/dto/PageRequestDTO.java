package org.zerock.springex.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {
	// 보여줄 page 쪽
	@Builder.Default
	@Min(value = 1)
	@Positive
	private int page = 1;
	
	// 보여줄 page size
	@Builder.Default
	@Min(value = 10)
	@Positive
	private int size = 10;
	
	private String link;
	
	public int getSkip() {
		return (page - 1) * size;
	}
	
	public String getLink() {
		if(link == null) {
			 StringBuilder builder = new StringBuilder();
			 builder.append("page=" + this.page);
			 builder.append("&size=" + this.size);
			 link = builder.toString();
		}
		
		return link;
	}
}
