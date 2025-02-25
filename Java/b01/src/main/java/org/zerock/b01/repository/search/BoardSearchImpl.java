package org.zerock.b01.repository.search;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.zerock.b01.domain.Board;
import org.zerock.b01.dto.BoardListReplyCountDTO;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardSearchImpl implements BoardSearch {
    private final EntityManager entityManager;

    // JPQL
    @Override
    public Page<Board> searchAll(String[] types, String keyword, Pageable pageable) {
        // JPQL로 작성 - 게시글 리스트를 조회하는 로직
        StringBuilder jpql = new StringBuilder("SELECT b FROM Board b WHERE b.bno > 0");

        // 동적 검색 조건 추가
        if ((types != null && types.length > 0) && keyword != null) {
            jpql.append(" AND (");

            for (int i = 0; i < types.length; i++) {
                String type = types[i];
                switch (type) {
                    case "t":
                        jpql.append("b.title LIKE :keyword");
                        break;
                    case "c":
                        jpql.append("b.content LIKE :keyword");
                        break;
                    case "w":
                        jpql.append("b.writer LIKE :keyword");
                        break;
                }

                // 각 조건 사이에 "OR" 추가
                if (i < types.length - 1) {
                    jpql.append(" OR ");
                }
            }
            jpql.append(")");
        }
        jpql.append(" ORDER BY bno DESC");

        // JPQL로 쿼리 생성
        TypedQuery<Board> query = entityManager.createQuery(jpql.toString(), Board.class);
        TypedQuery<Long> countQuery = entityManager.createQuery(
                jpql.toString().replace("SELECT b", "SELECT COUNT(b)"), Long.class
        );

        // 파라미터 바인딩
        if ((types != null && types.length > 0) && keyword != null) {
            query.setParameter("keyword", "%" + keyword + "%");
            countQuery.setParameter("keyword", "%" + keyword + "%");
        }

        // 페이징 처리
        query.setFirstResult((int) pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());

        // 결과 조회
        List<Board> list = query.getResultList();
        long count = countQuery.getSingleResult();

        return new PageImpl<>(list, pageable, count);
    }

    @Override
    public Page<BoardListReplyCountDTO> searchWithReplyCount(String[] types, String keyword, Pageable pageable) {
        // JPQL로 작성 - 게시글과 댓글 수를 함께 조회하는 로직
        StringBuilder jpql = new StringBuilder("SELECT new org.zerock.b01.dto.BoardListReplyCountDTO (");
        jpql.append("b.bno, b.title, b.writer, b.regDate, count(r)) ");
        jpql.append("FROM Board b LEFT JOIN Reply r ON r.board = b ");
        jpql.append("WHERE b.bno > 0 ");

        // 동적 검색 조건 추가
        if ((types != null && types.length > 0) && keyword != null) {
            jpql.append(" AND (");

            for (int i = 0; i < types.length; i++) {
                String type = types[i];
                switch (type) {
                    case "t":
                        jpql.append("b.title LIKE :keyword");
                        break;
                    case "c":
                        jpql.append("b.content LIKE :keyword");
                        break;
                    case "w":
                        jpql.append("b.writer LIKE :keyword");
                        break;
                }

                // 각 조건 사이에 "OR" 추가
                if (i < types.length - 1) {
                    jpql.append(" OR ");
                }
            }
            jpql.append(") ");
        }
        jpql.append(" GROUP BY b ");    // 게시글에 따른 댓글 카운트를 가져오기 위한 group by사용
        jpql.append("   ORDER BY b.bno DESC");
        // JPQL로 쿼리 생성
        TypedQuery<BoardListReplyCountDTO> query = entityManager.createQuery(jpql.toString(), BoardListReplyCountDTO.class);

        // JPQL로 카운트 쿼리 생성
        StringBuilder countJpql = new StringBuilder("SELECT count(distinct b) FROM Board b ");
        // 동적 검색 조건 추가
        if ((types != null && types.length > 0) && keyword != null) {
            countJpql.append(" WHERE ");

            for (int i = 0; i < types.length; i++) {
                String type = types[i];
                switch (type) {
                    case "t":
                        countJpql.append("b.title LIKE :keyword");
                        break;
                    case "c":
                        countJpql.append("b.content LIKE :keyword");
                        break;
                    case "w":
                        countJpql.append("b.writer LIKE :keyword");
                        break;
                }

                // 각 조건 사이에 "OR" 추가
                if (i < types.length - 1) {
                    countJpql.append(" OR ");
                }
            }
        }
        // JPQL로 쿼리 생성
        TypedQuery<Long> countQuery = entityManager.createQuery(countJpql.toString(), Long.class);

        // 파라미터 바인딩
        if ((types != null && types.length > 0) && keyword != null) {
            query.setParameter("keyword", "%" + keyword + "%");
            countQuery.setParameter("keyword", "%" + keyword + "%");
        }
        // 페이징 처리
        query.setFirstResult((int) pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());

        // 결과 조회
        List<BoardListReplyCountDTO> list = query.getResultList();
        long count = countQuery.getSingleResult();

        return new PageImpl<>(list, pageable, count);
    }
}
