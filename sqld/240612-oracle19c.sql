-- 사원.csv, 부서.csv파일 내용을 보고 아래 2개의 테이블 만드는 ddl코드를 작성해 보세요.

-- 사원 테이블
CREATE TABLE employees	--23c버전에서는 IF NOT EXISTS 연산자 지원(ex) CREATE TABLE IF NOT EXISTS employees)
(
	emp_id         varchar2(30) 	PRIMARY KEY,
	name_kor       varchar2(50) 	NOT NULL,
	name_eng       varchar2(50) 	NOT NULL,
	degree1        varchar2(20) 	NOT NULL,
	gender         char(3) 	    	NOT NULL,
	birth_day      char(10)     	NOT NULL,
	enter_day      char(10)     	NOT NULL,
	address1       varchar2(100) 	NOT NULL,
	city           varchar2(20) 	NOT NULL,
	region         varchar2(20) 	NOT NULL,
	phone_home     varchar2(30) 	NOT NULL,
	boss_number    varchar2(30),
	department_id  varchar2(30)
);

DROP TABLE employees;

-- 부서 테이블
CREATE TABLE departments
(
	department_id  varchar2(30) 	PRIMARY KEY,
	name_kor       varchar2(50)     NOT NULL,
	create_day     char(10)     	NOT NULL
);

ALTER TABLE employees ADD CONSTRAINT fk_department_tmp1
FOREIGN KEY(department_id) REFERENCES departments(department_id)
;

-- 부서 데이터 생성
--INSERT INTO DEPARTMENTS d VALUES ('A1', '영업부', '2022-01-01');
INSERT INTO departments values('A1','영업부','2022-01-01');
INSERT INTO departments values('A2','기획부','2023-02-02');
INSERT INTO departments values('A3','개발부','2021-03-03');
INSERT INTO departments values('A4','홍보부','2020-04-04');

SELECT * FROM departments;

-- 사원 데이터 생성
INSERT INTO employees values('E01','이소미','Lee So Mi','사원','여','1985-12-05','43568','강남구 역삼동 36-8','서울특별시','경인','(02)578-8988','E06','A1');
INSERT INTO employees values('E02','배재용','Bae Jae Yong','대표이사','남','1973-02-17','43466','원미동 16-11','부천시','경인','(032)69-0136','','A2');
INSERT INTO employees values('E03','유대현','Yoo Dae Hyeon','사원','남','1988-08-27','43538','광산구 송정동 100-11','광주광역시','호남','(062)73-0256','E06','A1');
INSERT INTO employees values('E04','최소민','Choi So Min','사원','여','1987-09-17','43570','중구 중앙동 57-14','부산광역시','영남','(051)587-4783','E06','A1');
INSERT INTO employees values('E05','안주훈','Ahn Ju Hoon','과장','남','1980-03-01','43463','남구 도화동 276-31','인천광역시','경인','(032)515-0278','E09','A1');
INSERT INTO employees values('E06','이현진','Lee Hyun Jin','대리','남','1983-06-30','43737','대덕구 이현동 577-1','대전광역시','중부','(042)518-3876','E05','A1');
INSERT INTO employees values('E07','오영수','O Yeong Soo','사원','남','1989-05-27','43814','문화동 76-77','청주시','중부','(0431)19-1784','E06','A1');
INSERT INTO employees values('E08','선하라','Seon Ha Ra','전산팀장','여','1982-01-07','43512','덕진구 고랑동 116','전주시','호남','(0652)983-1985','E02','A3');
INSERT INTO employees values('E09','유가을','Yoo Ka Eul','부장','여','1980-01-25','43767','남구 대명동 19-7','대구광역시','영남','(053)465-1248','E02','A1');

SELECT * FROM employees;

-- 스칼라 서브쿼리 -> select절(select안의 컬럼 위치)에 있는 서브쿼리
SELECT e.EMP_ID,
       e.NAME_KOR,
       (SELECT d.name_kor 
       	FROM DEPARTMENTS d 
       	WHERE e.DEPARTMENT_ID = d.DEPARTMENT_ID) AS DEPARTMENT_NAME,
       (SELECT d.create_day
       	FROM DEPARTMENTS d 
       	WHERE e.DEPARTMENT_ID = d.DEPARTMENT_ID) AS DEPARTMENT_CREATE_DAY       	
FROM EMPLOYEES e
;	

-- 인라인뷰 서브쿼리 -> from절
SELECT *
FROM (
	SELECT *
	FROM EMPLOYEES
);

SELECT *
FROM EMPLOYEES e
;

-- 중첩 서브쿼리 -> where 혹은 having절
SELECT *
FROM EMPLOYEES e
WHERE e.emp_id = (SELECT emp_id FROM EMPLOYEES e2 WHERE e2.emp_id = 'E02')
;

SELECT *
FROM EMPLOYEES e
WHERE e.emp_id = 'E02'
;

SELECT *
FROM EMPLOYEES e
WHERE e.emp_id IN ('E02','E01')
;

SELECT *
FROM EMPLOYEES e
WHERE e.emp_id IN (SELECT emp_id FROM EMPLOYEES e2)
;

SELECT *
FROM EMPLOYEES e
WHERE (department_id, enter_day) IN (SELECT DEPARTMENT_ID, create_day FROM DEPARTMENTS d)
;

-- View(뷰) -> 읽기전용 테이블
CREATE OR REPLACE VIEW dept_member AS
	SELECT department_id, name_kor FROM departments
;

SELECT * FROM dept_member WHERE department_id = 'A2'
;

DROP VIEW dept_member;	-- VIEW 삭제

-- 집합연산자(union all, union, intersect, minus/except)
CREATE TABLE running_man
(
	CAST 		varchar2(50),
	gender		varchar2(50),
	job 		varchar2(50)
);

--DROP TABLE running_man;
SELECT * FROM running_man;

INSERT INTO running_man values('유재석', '남', '개그맨');
INSERT INTO running_man values('지석진', '남', '개그맨');
INSERT INTO running_man values('김종국', '남', '가수');
INSERT INTO running_man values('전소민', '여', '배우');
INSERT INTO running_man values('송지효', '여', '배우');
INSERT INTO running_man values('이광수', '남', '배우');
INSERT INTO running_man values('하하', '남', '가수');
INSERT INTO running_man values('양세찬', '남', '개그맨');

CREATE TABLE infinite_challenge
(
	CAST 		varchar2(50),
	gender		varchar2(50),
	job 		varchar2(50)
);

--DROP TABLE infinite_challenge;
SELECT * FROM infinite_challenge;

INSERT INTO infinite_challenge values('유재석', '남', '개그맨');
INSERT INTO infinite_challenge values('박명수', '남', '개그맨');
INSERT INTO infinite_challenge values('정준하', '남', '개그맨');
INSERT INTO infinite_challenge values('하하', '남', '가수');
INSERT INTO infinite_challenge values('양세형', '남', '개그맨');
INSERT INTO infinite_challenge values('조세호', '남', '개그맨');


SELECT * FROM RUNNING_MAN rm 
UNION ALL
SELECT * FROM INFINITE_CHALLENGE ic 
;

SELECT * FROM RUNNING_MAN rm 
UNION
SELECT * FROM INFINITE_CHALLENGE ic 
;

SELECT * FROM RUNNING_MAN rm 
INTERSECT
SELECT * FROM INFINITE_CHALLENGE ic 
;

SELECT * FROM RUNNING_MAN rm 
MINUS
SELECT * FROM INFINITE_CHALLENGE ic 
;

-- full outer join
SELECT A."CAST" AS R_CAST,
       B."CAST" AS L_CAST
  FROM running_man a FULL JOIN INFINITE_CHALLENGE b 
    ON a."CAST" = b."CAST"
;

-- natural join(oracle에서 지원) -> intersact 집합연산자 사용하여도 처리가 가능하여 해당 연산자는 많이 사용하지 않음
SELECT * FROM running_man
NATURAL JOIN infinite_challenge
;


-- ----------------------------------------------------------------------------------------------------
-- Top-N쿼리 학습
CREATE TABLE exam_score
(
	이름      varchar2(20),
	국어      NUMBER,
	영어      NUMBER,
	수학      NUMBER
);
-- DROP TABLE exam_score
SELECT * FROM EXAM_SCORE es;

INSERT INTO exam_score values('김기탁', 116, 77, 75);
INSERT INTO exam_score values('김재덕', 101, 69, 80);
INSERT INTO exam_score values('노정인', 118, 62, 60);
INSERT INTO exam_score values('이솔', 96, 72, 70);
INSERT INTO exam_score values('박형준', 103, 77, 55);
INSERT INTO exam_score values('신재석', 78, 66, 61);
INSERT INTO exam_score values('김동엽', 85, 72, 75);
INSERT INTO exam_score values('서인지', 99, 70, 53);
INSERT INTO exam_score values('박혜진', 105, 75, 69);
INSERT INTO exam_score values('안률', 117, 68, 73);

SELECT rownum, 이름, 국어, 영어, 수학 FROM EXAM_SCORE es;

SELECT rownum, 이름, 국어, 영어, 수학 FROM EXAM_SCORE es WHERE rownum = 5; -- DATA 안나옴

SELECT rownum, 이름, 국어, 영어, 수학 FROM EXAM_SCORE es WHERE rownum <= 5; -- 순위일 경우에는 DATA 나옴

SELECT rownum, 이름, 국어, 영어, 수학 
FROM 
	(SELECT 이름, 국어, 영어, 수학 FROM EXAM_SCORE ORDER BY 국어 DESC, 영어 DESC, 수학 DESC)
WHERE rownum <= 5
;

SELECT rownum, 이름, 국어, 영어, 수학 
FROM EXAM_SCORE
WHERE rownum <= 5 
ORDER BY 국어 DESC, 영어 DESC, 수학 DESC
;

-- 순위함수 -> row_number, rank, dense_rank
SELECT *
FROM (
	SELECT row_number() OVER(ORDER BY 국어 DESC, 영어 DESC, 수학 DESC) AS rnum,
	 	   이름,
	 	   국어,
	 	   영어,
	 	   수학
	  FROM EXAM_SCORE es 
) WHERE rnum <= 5
;

-- ----------------------------------------------------------------------------------------------------
-- join학습
CREATE TABLE product
(
	product_code      char(6)			PRIMARY KEY,
	product_name      varchar2(500)     NOT NULL,
	price			  number			NOT NULL
);
--DROP TABLE product;
SELECT * FROM product;

INSERT INTO product values('100001', '무소음 무선 마우스', 29500);
INSERT INTO product values('100002', '기계식 게이밍 키보드', 32600);
INSERT INTO product values('100003', '무결점 패널 광시야각 모니터', 179000);

CREATE TABLE product_review
(
	review_no         number			PRIMARY KEY,
	product_code      char(6)     		NOT NULL,
	member_id		  varchar2(100)		NOT NULL,
	content		  	  clob				NOT NULL,
	regdate		  	  char(8)	   	    NOT NULL
);
--DROP TABLE product_review;
SELECT * FROM product_review;

INSERT INTO product_review values(1, '100001', 'sqlbaby01', '무소음인데 소음이 조금 있는 듯?', '20210320');
INSERT INTO product_review values(2, '100002', 'sqlchild02', '무선이라 정말 편하네요!', '20210324');
INSERT INTO product_review values(3, '100003', 'sqladult03', '게임할 맛 납니다', '20210329');

CREATE TABLE event
(
	event_no          number			PRIMARY KEY,
	event_name        varchar2(100) 	NOT NULL,
	start_date	  	  char(8)	   	    NOT NULL,
	end_date	  	  char(8)	   	    NOT NULL
);
--DROP TABLE event;
SELECT * FROM event;

INSERT INTO event values(1, '20% 할인쿠폰 증정', '20210314', '20210324');
INSERT INTO event values(2, '마우스패드 증정', '20210325', '20210331');
INSERT INTO event values(3, '벚꽃축제 페스티벌', '20210414', '20210430');


-- inner equi join
SELECT a.product_code,
       a.product_name,
       a.price,
       b.review_no,
       b.member_id,
       b.content,
       b.regdate
FROM product a,
	 product_review b
;

SELECT a.product_code,
       a.product_name,
       a.price,
       b.review_no,
       b.member_id,
       b.content,
       b.regdate
FROM product a INNER JOIN product_review b	-- 표준 INNER JOIN SQL(inner는 생략가능)
  ON a.PRODUCT_CODE = b.PRODUCT_CODE		
WHERE a.PRODUCT_CODE = '100001'
;

-- inner non-equi join
SELECT a.event_name,
       b.member_id,
       b.content,
       b.regdate
FROM event a,
     product_review b
WHERE b.REGDATE BETWEEN a.START_DATE AND a.END_DATE		-- non-equi join
;

-- inner equi && non-equi join
SELECT a.product_code,
	   a.product_name,
       b.member_id,
       b.content,
       c.event_name
FROM product a,
	 product_review b,
	 event c
WHERE a.PRODUCT_CODE = b.PRODUCT_CODE	 				-- equi join
  AND b.REGDATE BETWEEN c.START_DATE AND c.END_DATE		-- non-equi join
;


-- outer join
UPDATE product_review SET product_code = '100001' WHERE product_code = '100002'
;
UPDATE product_review SET product_code = '100002' WHERE product_code = '100003'
;

SELECT * FROM product;
SELECT * FROM product_review;

SELECT a.product_code,
       a.product_name,
       b.member_id,
       b.content,
       b.regdate
  FROM product a,
       product_review b
 WHERE a.PRODUCT_CODE = b.PRODUCT_CODE(+)		-- OUTER LEFT JOIN -> (+) 오라클 전용 연산자
;

SELECT a.product_code,
       a.product_name,
       b.member_id,
       b.content,
       b.regdate
  FROM product a LEFT OUTER JOIN product_review b
    ON a.PRODUCT_CODE = b.PRODUCT_CODE		    -- OUTER LEFT JOIN -> 표준 SQL 연산자(outer는 생략 가능)
;


-- 셀프 조인(self join)
CREATE TABLE category
(
	category_type     char(3) 			NOT NULL,
	category_name     varchar2(50) 		NOT NULL,
	parent_category   varchar2(50)
);
-- DROP TABLE category;
SELECT * FROM category;

INSERT INTO category values('대', '컴퓨터/디지털/가전', NULL);
INSERT INTO category values('중', '컴퓨터', '컴퓨터/디지털/가전');
INSERT INTO category values('중', '디지털', '컴퓨터/디지털/가전');
INSERT INTO category values('중', '가전', '컴퓨터/디지털/가전');
INSERT INTO category values('소', '노트북/PC', '컴퓨터');
INSERT INTO category values('소', '모니터/프린터', '컴퓨터');
INSERT INTO category values('소', '모바일/태블릿', '디지털');
INSERT INTO category values('소', '카메라', '디지털');
INSERT INTO category values('소', '영상가전', '가전');
INSERT INTO category values('소', '음향가전', '가전');
