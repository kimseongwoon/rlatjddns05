package com.example.finalproject.models.dto;

import lombok.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.URL;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DifferentiatedProductDTO {

    private Long id;

    @NotBlank(message = "상품 이름은 필수입니다.")
    @Size(max = 100, message = "상품 이름은 최대 100자까지 입력 가능합니다.")
    private String name;  // 상품 이름

    @NotNull(message = "가격은 필수입니다.")
    @Positive(message = "가격은 양수여야 합니다.")
    private double price;  // 상품 가격

    @Size(max = 500, message = "설명은 최대 500자까지 입력 가능합니다.")
    private String description;  // 상품 설명

    @URL(message = "유효한 URL이어야 합니다.")
    @Size(max = 255, message = "이미지 URL은 최대 255자까지 입력 가능합니다.")
    private String imageUrl;  // 상품 이미지 URL

    @NotBlank(message = "카테고리는 필수입니다.")
    @Size(max = 50, message = "카테고리는 최대 50자까지 입력 가능합니다.")
    private String category;  // 카테고리 (예: 유어스, 프레시 푸드 등)
}
