package com.example.finalproject.models.dto;

import lombok.*;
import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CategoryDTO {

    @NotNull(message = "카테고리 ID는 필수입니다.")
    private Long id;

    @NotBlank(message = "카테고리 이름은 필수입니다.")
    @Size(max = 50, message = "카테고리 이름은 최대 50자까지 입력 가능합니다.")
    private String name;  // 카테고리 이름 (예: 음료, 간식 등)

    @Size(max = 255, message = "설명은 최대 255자까지 입력 가능합니다.")
    private String description;  // 카테고리 설명
}
