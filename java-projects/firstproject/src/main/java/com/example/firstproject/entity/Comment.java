package com.example.firstproject.entity;

import com.example.firstproject.dto.CommentDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity     // 해당 클래스가 엔티티임을 선언, 클래스 필드를 바탕으로 DB에 테이블 생성
@AllArgsConstructor // 모든 필드를 매개변수로 갖는 생성자 자동 생성
@NoArgsConstructor  // 매개변수가 아무것도 없는 기본 생성자 자동 생성
@ToString   // 모든 필드를 출력할 수 있는 toString 메소드 자동 생성
@Getter    // 모든 필드에 대한 getter 메소드 자동 생성
//@Table(name = "\"comment\"")    // 엔티티와 매핑할 테이블 지정
public class Comment {
    // 댓글 번호(대표키 및 기본키)
    @Id     // 기본키(엔티티의 대표값 지정)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 자동 생성 추가
    private Long id;

    // 댓글 닉네임
    @Column
    private String nickname;

    // 댓글 내용
    @Column
    private String body;

    // 댓글에 연계된 Article정보
    @ManyToOne  // Comment(댓글)과 Article(게시글)은 다대일 관계로 설정
    @JoinColumn(name = "article_id") // 외래키를 지정
    private Article article;    // 해당 댓글의 부모 게시글

    public static Comment createComment(
            CommentDto commentDto,
            Article article) {
        // Article의 id와 Comment의 articleId는 같아야 한다. 다르면 예외처리
        if (article.getId() != commentDto.getArticleId())
            throw new IllegalArgumentException("댓글 생성 실패! 게시글의 id가 잘못되었습니다.");
        if (commentDto.getId() != null)
            throw new IllegalArgumentException("댓글 생성 실패! 댓글의 id가 없어야 합니다.");

        // article.getId() == commentDto.getArticleId()
        // commentDto.getId() == null
        return new Comment(
                null, //commentDto.getId(),
                commentDto.getNickname(),
                commentDto.getBody(),
                article);
    }

    public void patch(CommentDto commentDto) {
        if(this.id != commentDto.getId())
            throw new IllegalArgumentException("댓글 수정 실패! 댓글의 id가 일치하지 않습니다.");

        if (commentDto.getNickname() != null) {     // 수정할 닉네임 정보가 있으면
            this.nickname = commentDto.getNickname();   // 실제 닉네임 변경
        }
        if (commentDto.getBody() != null) {         // 수정할 본문 데이터가 있으면
            this.body = commentDto.getBody();           // 실제 본문 변경
        }
    }
}
