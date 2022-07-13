INSERT INTO article(id, title, content) VALUES (1, '제목1', '내용1');
INSERT INTO article(id, title, content) VALUES (2, '제목2', '내용2');
INSERT INTO article(id, title, content) VALUES (3, '제목3', '내용3');

-- article 더미 데이터 추가
INSERT INTO article(id, title, content) VALUES (4, '영화는?', '댓글ㄱㄱ');
INSERT INTO article(id, title, content) VALUES (5, '음식은?', '댓글ㄱㄱ');
INSERT INTO article(id, title, content) VALUES (6, '취미는?', '댓글ㄱㄱ');

-- comment 더미 데이터 추가
---- 4번 게시글의 댓글들
INSERT INTO comment(id, article_id, nickname, body) VALUES (1, 4, 'jeon', '탑건');
INSERT INTO comment(id, article_id, nickname, body) VALUES (2, 4, 'lee', '어벤져스');
INSERT INTO comment(id, article_id, nickname, body) VALUES (3, 4, 'hong', '스파이더맨');

---- 5번 게시글의 댓글들
INSERT INTO comment(id, article_id, nickname, body) VALUES (4, 5, 'jeon', '치킨');
INSERT INTO comment(id, article_id, nickname, body) VALUES (5, 5, 'lee', '피자');
INSERT INTO comment(id, article_id, nickname, body) VALUES (6, 5, 'hong', '소고기');

---- 6번 게시글의 댓글들
INSERT INTO comment(id, article_id, nickname, body) VALUES (7, 6, 'jeon', '골프');
INSERT INTO comment(id, article_id, nickname, body) VALUES (8, 6, 'lee', '농구');
INSERT INTO comment(id, article_id, nickname, body) VALUES (9, 6, 'hong', '스타');