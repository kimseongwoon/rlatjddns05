package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class ArticleForm {
    private Long id;        // id를 받을 필드(속성)
    private String title;   // 제목을 받을 필드(속성)
    private String content; // 내용을 받을 필드(속성)

    public Article toEntity() {
        return new Article(id, title, content);
    }
}
