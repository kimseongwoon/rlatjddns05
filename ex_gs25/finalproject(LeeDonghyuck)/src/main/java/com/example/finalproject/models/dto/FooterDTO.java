package com.example.finalproject.models.dto;

import lombok.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.URL;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FooterDTO {

    private Long id;

    @NotBlank(message = "푸터 이름은 필수입니다.")
    @Size(max = 100, message = "푸터 이름은 최대 100자까지 입력 가능합니다.")
    private String name;  // 푸터의 이름

    @Size(max = 500, message = "설명은 최대 500자까지 입력 가능합니다.")
    private String description;  // 푸터 설명

    @URL(message = "유효한 URL이어야 합니다.")
    @Size(max = 255, message = "이미지 URL은 최대 255자까지 입력 가능합니다.")
    private String imageUrl;  // 푸터 이미지 URL
}
