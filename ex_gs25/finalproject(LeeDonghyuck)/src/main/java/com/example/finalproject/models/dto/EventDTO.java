package com.example.finalproject.models.dto;

import lombok.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.URL;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EventDTO {

    @NotNull(message = "행사 ID는 필수입니다.")
    private Long id;

    @NotBlank(message = "행사 이름은 필수입니다.")
    @Size(max = 100, message = "행사 이름은 최대 100자까지 입력 가능합니다.")
    private String name;  // 행사 이름

    @NotNull(message = "행사 시작일은 필수입니다.")
    @FutureOrPresent(message = "행사 시작일은 현재 또는 미래여야 합니다.")
    private LocalDate startDate;  // 행사 시작 날짜

    @NotNull(message = "행사 종료일은 필수입니다.")
    @Future(message = "행사 종료일은 미래 날짜여야 합니다.")
    private LocalDate endDate;  // 행사 종료 날짜

    @Size(max = 500, message = "설명은 최대 500자까지 입력 가능합니다.")
    private String description;  // 행사 설명

    @URL(message = "유효한 URL이어야 합니다.")
    @Size(max = 255, message = "이미지 URL은 최대 255자까지 입력 가능합니다.")
    private String imageUrl;  // 행사 이미지 URL
}
