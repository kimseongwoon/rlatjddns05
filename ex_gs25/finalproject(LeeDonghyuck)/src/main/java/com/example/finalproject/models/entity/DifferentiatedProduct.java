package com.example.finalproject.models.entity;

import jakarta.persistence.*;
import lombok.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.URL;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DifferentiatedProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "상품 이름은 필수입니다.")
    private String name;  // 상품 이름

    @Column(nullable = false)
    @Positive(message = "가격은 양수여야 합니다.")
    private double price;  // 상품 가격

    @Column(length = 500)
    @Size(max = 500, message = "설명은 최대 500자까지 입력 가능합니다.")
    private String description;  // 상품 설명

    @Column(length = 255)
    @URL(message = "유효한 URL이어야 합니다.")
    @Size(max = 255, message = "이미지 URL은 최대 255자까지 입력 가능합니다.")
    private String imageUrl;  // 상품 이미지 URL

    @Column(length = 50)
    @NotBlank(message = "카테고리는 필수입니다.")
    private String category;  // 카테고리 (예: 유어스, 프레시 푸드 등)
}