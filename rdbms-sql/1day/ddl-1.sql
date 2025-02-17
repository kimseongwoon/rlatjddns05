/* 
 * [] -> 옵션
 * 테이블 만들기 문법
 * CREATE TABLE [스키마명].테이블명 (
 *     컬럼명1   컬럼1_데이터타입    [NULL(기본값), NOT NULL],
 *     컬럼명2   컬럼2_데이터타입    [NULL(기본값), NOT NULL],
 *     .
 *     .
 *     .
 * )[TABLESPACE 테이블스페이스명];
 * 
 * 테이블 삭제 문법
 * DROP TABLE [스키마명].테이블명;
 */
-- 

CREATE TABLE ex2_1 (
	"COLUMN1"   CHAR(10),
	COLUMN2   VARCHAR2(10),
	COLUMN3   NVARCHAR2(10),
	COLUMN4   NUMBER
);

-- DROP TABLE ex2_1 CASCADE CONSTRAINTS;

-- 데이터 입력 SQL문
INSERT INTO ex2_1 (COLUMN1, COLUMN2) VALUES ('abc', 'abc');

-- 데이터 조회 SQL문
SELECT column1, column2 FROM ex2_1;
 
SELECT column1, LENGTH(column1) AS len1,
       column2, LENGTH(column2) AS len2
  FROM ex2_1;

-- 문자타입
CREATE TABLE ex2_2 (
	column1		varchar2(9),    -- 디폴트 값이 byte적용
	column2     varchar2(9 byte),
	column3     varchar2(9 char)
);

DROP TABLE ex2_2;

SELECT * FROM ex2_2; -- 모든 컬럼을 조회

INSERT INTO ex2_2 VALUES ('abc', 'abc', 'abc');  -- 모든 컬럼에 데이터 입력시 생략 가능

SELECT column1, LENGTH(column1) AS len1,
       column2, LENGTH(column2) AS len2,
       column3, LENGTH(column3) AS len3,
       column3, LENGTHB(column3) AS byte_len3
  FROM ex2_2;

INSERT INTO ex2_2 VALUES ('홍길동','홍길동','홍길동');


-- 숫자 데이터 타입
CREATE TABLE ex2_3 (
	col_int		integer,        -- 기본 길이 22자리 
	col_dec		decimal,	    -- 기본 길이 22자리
	col_num     NUMBER,         -- number기본 길이는 22자리와 127자리 소수자리
	col_num2    number(7, 2)    -- col_num2는 기본 자연수 길이 7자리와 2자리 소수자리만 허용
);

DROP TABLE ex2_3;

SELECT * FROM ex2_3;

SELECT column_id, column_name, data_type, data_length
FROM user_tab_cols
WHERE table_name = 'EX2_3'
ORDER BY column_id
;

-- 날짜 데이터 타입
CREATE TABLE ex2_5 (
	COL_DATE		DATE,
	COL_TIMESTAMP   TIMESTAMP
);

SELECT * FROM ex2_5;

-- SYSDATE: 현재시각을 DATE로 표현, SYSTIMESTAMP: 현재시각을 TIMESTAMP로 표현
INSERT INTO ex2_5 VALUES (SYSDATE, SYSTIMESTAMP);


-- NOT NULL타입(제약조건)
CREATE TABLE ex2_6(
	col1 	varchar2(10) 	NULL,     -- 값이 없어도 상관없음
	col2    varchar2(10)    NOT NULL  -- 값이 무조건 존재해야 함
);

INSERT INTO ex2_6(col1) VALUES ('abcd'); -- error

-- 해당 스키마에 모든 제약조건 정보 확인(테이블 이름은 대문자여야 함)
SELECT *
FROM user_constraints
WHERE table_name = 'EX2_6'
;

-- UNIQUE제약조건
/*
 * 사용법
 *   1. 컬럼명 데이터타입  UNIQUE
 *   2. CONSTRAINTS 제약조건명 UNIQUE(컬럼명1, 컬럼명2, ...)
 */ 
CREATE TABLE ex2_7 
(
	col_unique_null		varchar2(10)	UNIQUE,
	col_unique_nnull	varchar2(10)	UNIQUE  NOT NULL,
	col_unique          varchar2(10),
	CONSTRAINTS unique_nm1 UNIQUE (col_unique),
	CONSTRAINTS unique_nm2 UNIQUE (col_unique, col_unique_nnull)
);

-- ALTER TABLE ex2_7 DROP CONSTRAINT unique_nm2; -- unique 삭제
-- CREATE UNIQUE INDEX

DROP TABLE ex2_7;

INSERT INTO ex2_7 VALUES ('AA','AA','AA');
INSERT INTO ex2_7 VALUES ('AA','AA','AA');   -- error

SELECT * FROM ex2_7;

INSERT INTO ex2_7 VALUES ('', 'BB', 'BB');
INSERT INTO ex2_7 VALUES ('', 'CC', 'CC');

INSERT INTO ex2_7 VALUES ('', 'DD', 'EE');
INSERT INTO ex2_7 VALUES ('', 'DD', 'FF');

-- 문제1: 온라인 쇼핑몰 시스템의 상품 테이블을 만들어 보세요
-- 테이블 이름 1: PRODUCTS
--
-- 컬럼:
--   PRODUCT_ID: 제품 고유 식별자 (정수)
--   PRODUCT_NAME: 제품 이름 (최대 100자)
--   DESCRIPTION: 제품 설명 (최대 500자)
--   PRICE: 제품 가격 (숫자, 소수점 포함)
--   STOCK: 재고 수량 (정수)
--   CATEGORY: 제품 카테고리 (최대 50자)

CREATE TABLE PRODUCTS(
	PRODUCT_ID 	NUMBER UNIQUE NOT NULL,  -- PRIMARY KEY
	PRODUCT_NAME varchar2(300) NOT NULL,
	DESCRIPTION varchar2(1500),
	PRICE NUMBER(20) NOT NULL,
	STOCK NUMBER NOT NULL,
	CATEGORY VARCHAR2(150) NOT NULL
);

-- 문제2: 도서관 관리 시스템의 도서 테이블을 만들어 보세요
-- 테이블 이름: BOOKS
-- 
-- 컬럼:
--   BOOK_ID: 고유한 책 식별자 (정수)
--   TITLE: 책 제목 (최대 200자)
--   AUTHOR: 저자 이름 (최대 100자)
--   PUBLISHER: 출판사 이름 (최대 100자)
--   PUBLISHED_YEAR: 출판 연도 (4자리 정수)
--   GENRE: 장르 (최대 50자)
--   PRICE: 가격 (숫자, 소수점 포함)
--   QUANTITY: 현재 보유한 책 수량 (정수)
CREATE TABLE BOOKS(
	BOOK_ID 	NUMBER  UNIQUE NOT NULL,
	TITLE       varchar2(600) NOT NULL,
	AUTHOR      varchar2(300) NOT NULL,
	PUBLISHER   varchar2(300)
	PUBLISHED_YEAR NUMBER(4)
	GENRE       varchar2(150),
	QUANTITY    NUMBER NOT NULL
)

