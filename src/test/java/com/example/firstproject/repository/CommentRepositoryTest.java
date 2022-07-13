package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest // JPA와 연동한 테스트
class CommentRepositoryTest {

    @Autowired CommentRepository commentRepository;

    @Test
    @DisplayName("특정 게시글의 모든 댓글 조회")
    void findByArticleId() {
        /* Case 1: 4번 게시글의 모든 댓글 조회 */
        {
            // 입력 데이터 준비
            Long articleId = 4L;

            // 실제 수행
            List<Comment> comments = commentRepository.findByArticleId(articleId);

            // 예상 결과
            Article article = new Article(4L, "영화는?", "댓글ㄱㄱ");
            Comment a = new Comment(1L, article, "jeon", "탑건" );
            Comment b = new Comment(2L, article, "lee", "어벤져스" );
            Comment c = new Comment(3L, article, "hong", "스파이더맨" );
            List <Comment> expected = Arrays.asList(a, b, c);

            // 검증
            assertEquals(expected.toString(), comments.toString(), "4번 글의 모든 댓글을 출력");
        }

        /* Case 2: 1번 게시글의 모든 댓글 조회 */
        {
            // 입력 데이터 준비
            Long articleId = 1L;

            // 실제 수행
            List<Comment> comments = commentRepository.findByArticleId(articleId);

            // 예상 결과
            Article article = new Article(1L, "제목1", "내용1");
            List <Comment> expected = Arrays.asList();

            // 검증
            assertEquals(expected.toString(), comments.toString(), "1번 글은 댓글이 없음");
        }

        /* Case 3: 9번 게시글의 모든 댓글 조회 */
        {}
        /* Case 4: 9999번 게시글의 모든 댓글 조회 */
        {}
        /* Case 5: -1번 게시글의 모든 댓글 조회 */
        {}
    }

    @Test
    @DisplayName("특정 닉네임의 모든 댓글 조회")
    void findByNickname() {
        /* Case 1: "jeon"의 모든 댓글 조회 */
        {
            // 입력 데이터를 준비
            String nickname = "jeon";

            // 실제 수행
            List<Comment> comments = commentRepository.findByNickname(nickname);

            // 예상하기
            Comment a = new Comment(1L, new Article(4L, "영화는?", "댓글ㄱㄱ"), nickname, "탑건" );
            Comment b = new Comment(4L, new Article(5L, "음식은?", "댓글ㄱㄱ"), nickname, "치킨" );
            Comment c = new Comment(7L, new Article(6L, "취미는?", "댓글ㄱㄱ"), nickname, "골프" );
            List <Comment> expected = Arrays.asList(a, b, c);

            // 검증
            assertEquals(expected.toString(), comments.toString(), "jeon의 모든 댓글을 출력");
        }
        /* Case 2: "lee"의 모든 댓글 조회 */
        {}
        /* Case 3: null의 모든 댓글 조회 */
        {}
        /* Case 4: " "의 모든 댓글 조회 */
        {}
        /* Case 5: "i"가 포함된 모든 댓글 조회 */
        {}
    }
}