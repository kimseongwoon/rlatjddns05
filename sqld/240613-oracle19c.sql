-- self join 예제
SELECT * FROM category
;

-- 중분류(대,중)까지만 모두 나오게 하는 쿼리
SELECT a.category_type,
	   a.category_name,
	   b.category_type,
	   b.category_name
FROM CATEGORY a,
     CATEGORY b
WHERE a.category_name = b.parent_category
  AND a.category_type = '대'
;

-- 소분류(대,중,소)까지 모두 나오게 하는 쿼리
SELECT a.category_type,
	   a.category_name,
	   b.category_type,
	   b.category_name,
	   c.category_type,
	   c.category_name
FROM CATEGORY a,
     CATEGORY b,
     CATEGORY c
WHERE a.category_name = b.parent_category
  AND b.category_name = c.parent_category
;

-- 중분류와 소분류만 모두 나오게 하는 쿼리
SELECT a.category_type,
	   a.category_name,
	   b.category_type,
	   b.category_name
FROM CATEGORY a,
     CATEGORY b
WHERE a.category_name = b.parent_category
  AND a.category_type = '중'
;

-- oracle 전용 계층 쿼리(feat. subquery)
SELECT *
FROM (
	SELECT LEVEL AS lv,
		   SYS_CONNECT_BY_PATH('[' || category_type || ']' || category_name, '-') AS PATH,
		   parent_category
	  FROM CATEGORY c
	  START WITH parent_category IS NULL
	  CONNECT BY PRIOR category_name = parent_category
) A ORDER BY lv, parent_category
;

SELECT LEVEL,
	   category_type AS type,
	   category_name AS name,
	   parent_category AS parent,	   
	   SYS_CONNECT_BY_PATH('[' || category_type || ']' || category_name, '-') AS PATH
  FROM CATEGORY c
  START WITH parent_category IS NULL
  CONNECT BY PRIOR category_name = parent_category
  ORDER BY LEVEL
;







-- --------------------------------------------------------------------------------------------
CREATE TABLE entertainer
(
	name		varchar2(20),
	birthday    char(8)
--	job         varchar2(50)
--	site1       varchar2(20),
--	site2       varchar2(20),
--	site3       varchar2(20)
);
DROP TABLE entertainer;
SELECT * FROM entertainer;

SELECT * FROM entertainer WHERE job = '가수';

INSERT INTO entertainer values('이지은', '19930516', '가수,배우,작곡가');
INSERT INTO entertainer values('김향기', '20000809', '배우');
INSERT INTO entertainer values('김태형', '19951230', '가수,작곡가');

INSERT INTO entertainer values('이지은', '19930516', '인스타그램', '페이스북', '유튜브');
INSERT INTO entertainer values('김향기', '20000809', '인스타그램', '트위터', NULL);
INSERT INTO entertainer values('김태형', '19951230', NULL, NULL, NULL);

-- 제1정규화 -> 속성값이 하나가 되도록 엔티티(테이블)를 분리
CREATE TABLE job
(
	name		varchar2(20),
	job         varchar2(20)
);

INSERT INTO job values('이지은', '가수');
INSERT INTO job values('이지은', '배우');
INSERT INTO job values('이지은', '작곡가');

CREATE TABLE site
(
	name		varchar2(20),
	site        varchar2(20)
);

INSERT INTO site values('이지은', '인스타그램');
INSERT INTO site values('이지은', '페이스북');
INSERT INTO site values('이지은', '유튜브');


CREATE TABLE cafe_order
(
	order_no		NUMBER,
	drink_code      char(5),
	order_cnt       NUMBER,
	drink_name      varchar2(50)
);
--DROP TABLE cafe_order;
SELECT * FROM cafe_order;


SELECT 1 * NULL FROM dual;

SELECT count(review_score) FROM review1;



