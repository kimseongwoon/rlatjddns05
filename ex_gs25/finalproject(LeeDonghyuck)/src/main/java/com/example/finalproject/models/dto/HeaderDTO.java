package com.example.finalproject.models.dto;

import lombok.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.URL;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HeaderDTO {

    private Long id;

    @NotBlank(message = "헤더 이름은 필수입니다.")
    @Size(max = 100, message = "헤더 이름은 최대 100자까지 입력 가능합니다.")
    private String name;  // 헤더의 이름

    @Size(max = 500, message = "설명은 최대 500자까지 입력 가능합니다.")
    private String description;  // 헤더 설명

    @URL(message = "유효한 URL이어야 합니다.")
    @Size(max = 255, message = "이미지 URL은 최대 255자까지 입력 가능합니다.")
    private String imageUrl;  // 헤더 이미지 URL
}
