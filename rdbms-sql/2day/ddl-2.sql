/*
 * RDBMS 기본키(Primary Key)
 *   - 기본키는 기본적으로 UNIQUE와 NOT NULL속성을 가짐 
 *   - 만드는 방법1: 컬럼명    데이터타입   PRIMARY KEY
 *   - 만드는 방법2: CONSTRAINTS 제약조건명 PRIMARY KEY(컬럼명1, 컬럼명2, ...)
 */

-- 만드는 방법1
CREATE TABLE ex2_8 (
	col1 	varchar2(10) 	PRIMARY KEY,   -- NOT NULL and UNIQUE
	col2    varchar2(10)
);

SELECT constraint_name, constraint_type, table_name, search_condition
FROM user_constraints
WHERE table_name = 'EX2_8'
;

INSERT INTO ex2_8 VALUES ('', 'AA');   -- error

INSERT INTO ex2_8 VALUES ('AA', 'AA');

SELECT * FROM ex2_8;

-- 만드는 방법2
CREATE TABLE ex2_8_2 (
	col1 	varchar2(10),   
	col2    varchar2(10),
	CONSTRAINTS ex2_8_2_pk PRIMARY KEY(col1)
);

SELECT constraint_name, constraint_type, table_name, search_condition
FROM user_constraints
WHERE table_name = 'EX2_8_2'
;

/*
 * 외래키(Foreign Key)
 *   - 테이블 간의 참조 데이터 무결성을 위한 제약조건(적어도 2개의 테이블이 있을 때 사용)
 *   - 만드는 방법: CONSTRAINT 외래키명 FOREIGN KEY(컬럼명1, 컬럼명2, ...) REFERENCES 참조테이블(참조 테이블컬럼명1, 참조 테이블컬럼명2, ...)
 */
-- 부서 테이블
CREATE TABLE DEPARTMENTS (
	department_id  	 NUMBER 			PRIMARY KEY,   -- 부서번호
	department_name  varchar2(100)      NOT NULL      -- 부서이름
);

INSERT INTO DEPARTMENTS VALUES(1, '개발팀');

SELECT * FROM DEPARTMENTS;

-- 사원 테이블
CREATE TABLE EMPLOYEES (
	employee_id 	NUMBER 				PRIMARY KEY,   -- 사원번호
	emp_name    	varchar2(30)		NOT NULL,	   -- 사원이름
	email			varchar2(200),					   -- 사원 이메일
	department_id   NUMBER              NOT NULL,
	CONSTRAINT department_id_fk1 FOREIGN KEY(department_id) REFERENCES DEPARTMENTS(department_id) -- department_id의 외래키
);

DROP TABLE EMPLOYEES;

INSERT INTO EMPLOYEES VALUES(1, '홍길동', 'hogildong@abc.com', 1);

SELECT * FROM employees; 


-- CHECK 제약조건
-- 사용법: CONSTRAINT(S) 체크명 CHECK(체크조건)
CREATE TABLE ex2_9(
	num1      NUMBER		CONSTRAINTS check1 CHECK (num1 BETWEEN 1 AND 9),
	gender    varchar2(100)	CONSTRAINTS check2 CHECK (gender IN ('MALE', 'FEMALE'))
);

DROP TABLE ex2_9;1

SELECT constraint_name, constraint_type, table_name, search_condition
FROM user_constraints
WHERE table_name = 'EX2_9'
;

INSERT INTO ex2_9 VALUES(10, 'MAN'); -- error
INSERT INTO ex2_9 VALUES(5, 'FEMALE');

-- DEFALUT 제약조건
-- 사용법: DEFAULT 기본값
CREATE TABLE ex2_10 (
	col1 	     varchar2(10)	 NOT NULL,
	col2         varchar2(10)    NULL,
	create_date  DATE            DEFAULT sysdate   -- 데이터 생성시 create_date값이 없을 경우 현재시간 삽입  
);

INSERT INTO ex2_10 (col1, col2) values('AA', 'BB');

SELECT * FROM ex2_10;


-- 테이블  관련 변경
-- 1. 컬럼이름변경 -> ex2_10테이블의 col1컬럼명을 col11로 변경
ALTER TABLE ex2_10 RENAME COLUMN col1 TO col11;

--DESCRIBE EX2_10;
SELECT COLUMN_NAME, DATA_TYPE, DATA_LENGTH
FROM USER_TAB_COLUMNS
WHERE TABLE_NAME = 'EX2_10'
;

-- 2. 컬럼 데이터 변경 -> ex2_10테이블의 col2컬럼의 varchar2(10)에서 varchar2(30)으로 변경
ALTER TABLE ex2_10 MODIFY col2 varchar2(30);

-- 3. 컬럼 추가 -> ex2_10테이블의 col3컬럼을 number타입으로 추가
ALTER TABLE ex2_10 ADD col3 number;

-- 4. 컬럼 삭제 -> ex2_10테이블의 col3컬럼을 삭제
ALTER TABLE ex2_10 DROP COLUMN col3;

-- 5. 제약조건 추가 -> ex2_10테이블의 col11컬럼에 기본키를 추가
ALTER TABLE ex2_10 ADD CONSTRAINTS pk_ex2_10 PRIMARY KEY (col11);

SELECT constraint_name, constraint_type, table_name, search_condition
FROM user_constraints
WHERE table_name = 'EX2_10'
;

-- 6. 제약조건 삭제 -> ex2_10테이블의 기본키 삭제
ALTER TABLE ex2_10 DROP CONSTRAINTS pk_ex2_10;

-- 테이블 복사
-- 사용법: CREATE TABLE [스키마명].테이블명 AS SELECT 컬럼1, 컬럼2, ... FROM 복사할테이블명
CREATE TABLE ex2_9_1 AS SELECT * FROM ex2_9;

SELECT * FROM ex2_9_1;

-- 뷰(view) 생성
-- 사용법: CREATE OR REPLACE VIEW [스키마명].뷰명 AS SELECT 문장;
CREATE OR REPLACE VIEW dept_v1 AS SELECT * FROM departments;

SELECT * FROM dept_v1;

-- 뷰(view) 삭제
DROP VIEW dept_v1;

-- 인덱스(index) 생성
-- 사용법: CREATE [UNIQUE] INDEX [스키마명].인덱스명 ON [스키마명].테이블명(컬럼1, 컬럼2, ...)
CREATE UNIQUE INDEX ex2_10_ix01 ON ex2_10 (col11);

SELECT INDEX_NAME, TABLE_NAME, UNIQUENESS
FROM USER_INDEXES
WHERE TABLE_NAME = 'EX2_10';

-- 결합 인덱스(2개의 이상인 컬럼)
CREATE INDEX ex2_10_ix02 ON ex2_10 (col11, col2);

DROP INDEX ex2_10_ix02;

-- 시퀀스(SEQUENCE) 생성 -> 기본키 만들 때 많이 사용
-- 사용법: CREATE SEQUENCE [스키마명].시퀀스명 INCREMENT BY 증감숫자 START WITH 시작숫자
--        MINVALUE 최솟값 MAXVALUE 최대값
CREATE SEQUENCE my_seq1 INCREMENT BY 1 START WITH 1;

-- 데이터 삭제
DELETE FROM ex2_8;

ALTER TABLE ex2_8 MODIFY col1 NUMBER;

SELECT * FROM ex2_8;

INSERT INTO ex2_8(col1) VALUES (my_seq1.NEXTVAL);

-- 현재시간만 가져오기
SELECT SYSDATE FROM DUAL;
-- 현재 my_seq1시퀀스 값 가져오기
SELECT my_seq1.CURRVAL FROM DUAL;

-- 시퀀스 삭제
DROP SEQUENCE my_seq1;

-- 1번문제
CREATE TABLE ORDERS (
	ORDER_ID      NUMBER(12,0)    PRIMARY KEY,
	ORDER_DATE    DATE,
	ORDER_MODE    VARCHAR2(8 BYTE) CONSTRAINTS order_mode_check2 CHECK (ORDER_MODE IN ('direct', 'online')),
	ORDER_TOTAL   NUMBER(8,2)     DEFAULT 0,
	CUSTOMER_ID   NUMBER(2,0)
);

-- 2번문제
CREATE TABLE ORDER_ITEMS(
	ORDER_ID      NUMBER(12,0),
	LINE_ITEM_ID  NUMBER(3,0),
	UNIT_PRICE    NUMBER(8,2)     DEFAULT 0,
	QUANTITY      NUMBER(8,0)     DEFAULT 0,
	CONSTRAINTS order_items_pk1 PRIMARY KEY(ORDER_ID, LINE_ITEM_ID)
);

-- 3번문제
CREATE TABLE PROMOTIONS(
	PROMO_ID      NUMBER(6,0) 	PRIMARY KEY,
	PROMO_NAME    VARCHAR2(20)
)

-- 5번문제
CREATE SEQUENCE ORDERS_SEQ 
INCREMENT BY 1 
START WITH 1000
MINVALUE 1 
MAXVALUE 99999999
;

-- 백업한거 복원
imp test1/1234 FILE=expall.dmp log=empall.log ignore=y grants=y rows=y indexes=y full=y




