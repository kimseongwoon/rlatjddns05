package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service    // 서비스 객체 생성
public class AricleService {
    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> index() {
        return articleRepository.findAll();
    }

    public Article show(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Article create(ArticleForm formDto) {
        Article article = formDto.toEntity();
        if (article != null && article.getId() != null) {
            return null;
        }

        return articleRepository.save(article);
    }

    public Article update(Long id, ArticleForm dto) {
        // 1. DTO(ArticleForm)를 엔티티(Article)로 변환
        Article articleEntity = dto.toEntity();
        log.info("id: {}, article: {}", id, articleEntity.toString());

        // 2. 타깃 조회하기
        Article target = articleRepository.findById(id).orElse(null);

        // 3. 타깃의 값을 체크해서 잘못된 요청 처리하기
        if (target == null || id != articleEntity.getId() ) {
            return null;
        }

        // 4. 타깃의 값을 실제 변경하기
        target.patch(articleEntity);
        Article updated = articleRepository.save(target);  // 엔티티를 DB에 저장(갱신)

        return updated;
    }
}
