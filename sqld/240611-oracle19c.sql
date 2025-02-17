CREATE TABLE sample2
(
	col1 varchar2(20),
	col2 varchar2(50)
);

INSERT INTO sample2(col1, col2) values('ORACLE', 'DATABASE');
INSERT INTO sample2(col1, col2) values('SQL', 'DEVELOPER');

SELECT * FROM sample2;

-- 문제1
SELECT LENGTH(substr(col1,3,3)) + LENGTH(substr(col2,2)) AS RESULT FROM sample2;

-- 문제2
SELECT LENGTH(rtrim(col1,'LE')) + LENGTH(ltrim(col2,'DE')) AS RESULT FROM sample2;

-- 현재 시
SELECT to_char(sysdate, 'HH') FROM DUAL
;
-- 현재 분
SELECT to_char(sysdate, 'MI') FROM DUAL
;
-- 현재 초
SELECT to_char(sysdate, 'SS') FROM DUAL
;

select systimestamp,
       extract (year from systimestamp) as year,
       extract (month from systimestamp) as month,
       extract (day from systimestamp) as day,
       extract (hour from systimestamp) as hour,
       extract (minute from systimestamp) as minute,
       extract (second from systimestamp) as second
from dual;

SELECT sysdate FROM dual
;

-- SYSDATE : 현재 시스템의 날짜를 출력하는 함수
-- SYSTIMESTAMP : 현재 시스템의 날짜,시각출력 함수

-- 변환함수
-- 1. 명시적 형변환 함수
-- to_number, to_char, to_date

-- error
SELECT to_number('abc') FROM dual
;

SELECT to_char(123) FROM dual
;

-- 2. 암시적 형변환
CREATE TABLE SAMPLE3
(
	birthday char(8)
);

INSERT INTO sample3(birthday) values('20020210');
INSERT INTO sample3(birthday) values('20010312');

-- 내부적으로 birthday컬럼을 to_number함수를 자동으로 만들어 검색을 하도록 한다.
SELECT * FROM SAMPLE3 s WHERE to_number(birthday) = '20020210'
;
SELECT * FROM SAMPLE3 s WHERE birthday = 20020210  
;

CREATE TABLE REVIEW1
(
	product_id   NUMBER NOT NULL,
	member_no    NUMBER,
	review_score NUMBER,
	review       varchar2(1000)
);

/*
INSERT INTO REVIEW1(product_id, member_no, review_score, review) 
values(100001, 1, 5, '넘나 좋다는 것!');
INSERT INTO REVIEW1(product_id, member_no, review_score, review) 
values(100001, 3, NULL, NULL);
INSERT INTO REVIEW1(product_id, member_no, review_score, review) 
values(100001, 4, 1, '별로...');
INSERT INTO REVIEW1(product_id, member_no, review_score, review) 
values(100001, 7, 3, '그냥저냥 쓸만 했음');
*/
INSERT INTO REVIEW1 values(100001, 1, 5, '넘나 좋다는 것!');
INSERT INTO REVIEW1 values(100001, 3, NULL, NULL);
INSERT INTO REVIEW1 values(100001, 4, 1, '별로...');
INSERT INTO REVIEW1 values(100001, 7, 3, '그냥저냥 쓸만 했음');

SELECT * FROM REVIEW1;

DELETE FROM REVIEW1;

-- nvl함수(null인지여부의 컬럼데이터, null인경우 대체할 데이터)
SELECT member_no, nvl(review_score, 0) AS review_score FROM review1
;

-- nullif함수(인수1, 인수2) -> 인수1과 인수2가 같으면 NULL, 아니면 인수1을 반환
SELECT member_no, nullif(review_score, 0) AS review_score, review FROM review1
;

-- coalesce(인수1, 인수2, ...) -> NULL이 아닌 최초의 인수를 반환
SELECT product_id, coalesce(review_score, member_no), review AS coalesce값확인 FROM review1
;

-- nvl2함수(인수1, 인수2, 인수3) -> 인수1이 NULL이 아닌 경수 인수2를 반환하고 NULL인 경우 인수3을 반환
-- 조건식 ? 참인경우 : 거짓인경우 -> 인수1 != null ? 인수2 : 인수3
SELECT member_no, nvl2(review_score, '리뷰있음', '리뷰없음') AS review_check FROM review1
;

-- case제어문, decode함수(오라클만 해당) -> switch case
CREATE TABLE subway_info
(
	subway_line NUMBER,
	start_point varchar2(20),
	end_point varchar2(20)
);

INSERT INTO subway_info values(1, '인천', '소요산');
INSERT INTO subway_info values(2, '순환선', '순환선');
INSERT INTO subway_info values(3, '대화', '오금');
INSERT INTO subway_info values(4, '오이도', '당고개');
INSERT INTO subway_info values(5, '방화', '마천,상일동');

SELECT * FROM subway_info;

SELECT subway_line, 
		CASE WHEN subway_line = 1 THEN 'BLUE' 
			 WHEN subway_line = 2 THEN 'GREEN'
			 WHEN subway_line = 3 THEN 'ORANGE'
--			 ELSE 'GRAY'
		END AS line_color
FROM subway_info
;

SELECT subway_line, 
	   decode(subway_line, 1, 'BLUE', 2, 'GREEN', 3, 'ORANGE', 'GRAY') AS line_color
FROM subway_info
;

-- 비교연산자
SELECT * FROM SUBWAY_INFO si WHERE subway_line >= 2
;

SELECT * FROM SUBWAY_INFO si WHERE start_point = '순환선'
;

-- 부정비교연산자(!=, ^=, <>, not 컬럼명=, not컬럼명>)
SELECT * FROM SUBWAY_INFO si WHERE NOT start_point != '순환선'
;

-- NULL과 함께한 연산자는 전부 NULL
SELECT 1 / NULL FROM dual;

-- SQL 연산자(between, like, in, is null)
CREATE TABLE play_list
(
	play_id 	NUMBER,
	name    	varchar2(100),
	favorites   char(1)
);

INSERT INTO play_list values(1, 'Music', 'Y');
INSERT INTO play_list values(2, 'Movies', 'Y');
INSERT INTO play_list values(3, 'TV Shows', 'N');
INSERT INTO play_list values(4, 'Audiobooks', 'N');
INSERT INTO play_list values(5, '90''s Music', 'Y');
INSERT INTO play_list values(6, 'zxcvcxzv', 'Y');
INSERT INTO play_list values(7, 'sdfadsfas', 'Y');
INSERT INTO play_list values(8, 'sdfdsafsd', 'Y');
INSERT INTO play_list values(9, 'Music Videos', 'Y');
INSERT INTO play_list values(10, 'fzdfsadf', 'Y');
INSERT INTO play_list values(11, 'Brazilian Music', 'N');
INSERT INTO play_list values(12, 'Classical', 'N');
INSERT INTO play_list values(13, 'Classical 101 - Deep Cuts', 'N');
INSERT INTO play_list values(14, 'Classical 101 - Next Steps', 'N');
INSERT INTO play_list values(15, 'Classical 101 - The Basics', 'N');

DELETE FROM play_list;

SELECT * FROM play_list;

SELECT * FROM play_list WHERE play_id BETWEEN 1 AND 5; 
SELECT * FROM play_list WHERE play_id >= 1 AND play_id <= 5;

SELECT * FROM play_list WHERE name LIKE 'Classical%';
SELECT * FROM play_list WHERE name LIKE '%Music';

-- 왼쪽 끝에 문자가 M으로 시작하고 오른쪽 끝에 s로 끝나는 데이터들을 조회
SELECT * FROM play_list WHERE name LIKE 'M%s';

-- 중간에 101가 있는 모든 데이터를 가져오기
SELECT * FROM play_list WHERE name LIKE '%101%';

SELECT * FROM play_list WHERE name LIKE '_lassical%'; -- '_' 1개를 지칭


SELECT * FROM review1;

INSERT INTO review1 values(100001, 5, 4, '200% 만족합니다');
INSERT INTO review1 values(100001, 6, 3, '정말 좋네요 GOOD_JOB!!');

SELECT * FROM review1 WHERE review LIKE '%#%%' ESCAPE '#'; -- '%'를 포함한 모든 데이터를 조회
-- SELECT * FROM review1 WHERE review LIKE '%';	-- 사용은 가능하시만 비추천
SELECT * FROM review1 WHERE review LIKE '%@_%' ESCAPE '@'; -- '_'를 포함한 모든 데이터를 조회

SELECT * FROM play_list WHERE play_id = 11 OR play_id = 12;
SELECT * FROM play_list WHERE play_id IN (11, 12);
SELECT * FROM play_list 
WHERE name IN ('Brazilian Music', 'Classical', 'Classical 101 - Deep Cuts');

SELECT * FROM review1 WHERE review_score IS NULL;  -- '='로 NULL체크못함


-- group by(집계함수(avg, sum, count, min, max)와 같이 사용), having절
CREATE TABLE student_score
(
	student_no NUMBER,
	math_score NUMBER,
	english_score NUMBER
);
INSERT INTO student_score values(1, 90, 85);
INSERT INTO student_score values(2, 70, 80);
INSERT INTO student_score values(3, 82, 63);
INSERT INTO student_score values(4, 95, 91);
INSERT INTO student_score values(5, 75, 96);
INSERT INTO student_score values(6, 80, 80);
INSERT INTO student_score values(7, 80, 76);

SELECT * FROM student_score;

SELECT avg(math_score) FROM STUDENT_SCORE ss; -- 평균 구하는 함수
SELECT sum(math_score) FROM STUDENT_SCORE ss; -- 합계 구하는 함수
SELECT count(math_score) FROM STUDENT_SCORE ss; -- 개수 구하는 함수
SELECT min(math_score) FROM STUDENT_SCORE ss; -- 최소값 구하는 함수
SELECT max(math_score) FROM STUDENT_SCORE ss; -- 최대값 구하는 함수

INSERT INTO student_score values(3, 80, 70);
INSERT INTO student_score values(4, 40, 65);


-- 3 ~ 6번까지의 번호를 가진 학생들의 수학평균 점수가 70점 이상만 가져오는 쿼리
SELECT student_no
	   --,avg(math_score)
	  ,math_score
FROM student_score
WHERE student_no BETWEEN 3 AND 6
--GROUP BY student_no
--HAVING avg(math_score) >= 70   -- 조건절(집계함수를 사용하여 원하는 데이터만 가져오도록 조건을 설정하는 키워드)
ORDER BY student_no DESC, math_score DESC
;

-- 트랜잭션 활용
-- 상태를 transaction상태로 세팅
INSERT INTO student_score values(5, 77, 87);

INSERT INTO student_score values(6, 78, 69);

INSERT INTO student_score values(7, 60, 70);

SELECT * FROM student_score;

COMMIT;

ROLLBACK;

DROP TABLE sample4;

CREATE TABLE sample4
(
	col1 NUMBER,
	col2 char(3),
	col3 char(1)
);

INSERT INTO sample4 values(1, '가', 'A');
INSERT INTO sample4 values(2, '나', 'B');
INSERT INTO sample4 values(3, '다', 'C');

SELECT * FROM sample4;

DELETE FROM sample4;
COMMIT;


BEGIN
	INSERT INTO sample4 values(4, '라', 'D');
	SAVEPOINT A;
	
	UPDATE sample4 SET col2 = '나' WHERE col1 IN (1,3);
	SAVEPOINT B;
	
	DELETE FROM sample4 WHERE col2 = '라';
	ROLLBACK TO A;
	
	DELETE FROM sample4 WHERE col2 = '나';
	COMMIT;
END;


