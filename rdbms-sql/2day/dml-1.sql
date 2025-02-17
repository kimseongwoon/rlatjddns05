-- DML문(SELECT, INSERT, DELETE, UPDATE)

-- SELECT문
-- 사용법: SELECT * 혹은 컬럼 FROM [스키마명].테이블명 혹은 [스키마명].뷰명 
--        WHERE 조건 ORDER BY 컬럼1, 컬럼2...

SELECT * FROM EMPLOYEES;

ALTER TABLE EMPLOYEES ADD SALARY NUMBER;

INSERT INTO EMPLOYEES VALUES(2, '유관순', 'yukwansun@abc.com', 1, 4000);
INSERT INTO EMPLOYEES VALUES(3, '강감찬', 'kang1@abc.com', 1, 3000);
INSERT INTO EMPLOYEES VALUES(4, '신사임당', 'sin1@abc.com', 1, 6000);
INSERT INTO EMPLOYEES VALUES(5, '박정희', 'park1@abc.com', 1, 7000);

-- 급여가 5000원이 넘는 사원들의 id와 이름 가져오기
SELECT employee_id, emp_name
FROM EMPLOYEES
WHERE salary > 5000
;

-- 급여가 5000원이 넘는 사원들의 id와 이름 가져오데 employee_id의 오름차순(기본값)으로 가져오기
SELECT employee_id, emp_name
FROM EMPLOYEES
WHERE salary > 5000
ORDER BY employee_id ASC
;

-- 급여가 5000원이 넘는 사원들의 id와 이름 가져오데 employee_id의 내림차순으로 가져오기
SELECT employee_id, emp_name
FROM EMPLOYEES
WHERE salary > 5000
ORDER BY employee_id DESC
;

-- 급여가 5000원이 넘는 사원들의 id와 이름 가져오데 사원이름이 '박정희'인 데이터만 가져오기
SELECT employee_id, emp_name
FROM EMPLOYEES
WHERE salary > 5000
AND emp_name = '박정희'
;

-- 급여가 5000원이 넘는 사원들의 id와 이름 가져오거나 혹은 사원이름 '강감찬'인 데이터를 모두 가져오기
SELECT employee_id, emp_name
FROM EMPLOYEES
WHERE salary > 5000
OR emp_name = '강감찬'
;

-- AS 사용(alias)
SELECT a.employee_id, a.emp_name, a.DEPARTMENT_ID,
       b.DEPARTMENT_NAME AS dep_name   -- 컬럼에서 'AS'는 생략가능
FROM EMPLOYEES a,
     DEPARTMENTS b
WHERE a.DEPARTMENT_ID = b.DEPARTMENT_ID
;

-- INSERT문
-- 사용법: INSERT INTO [스키마명].테이블명 (컬럼1, 컬럼2, ...) VALUES (값1, 값2, ...)
--    -> 단, 테이블명 괄호는 모든 컬럼에 대한 값이 세팅되었을 때는 생략이 가능
CREATE TABLE ex3_1 (
	col1 	varchar2(10),
	col2 	number,
	col3 	date
);

INSERT INTO ex3_1 VALUES('ABC', 10, SYSDATE);

SELECT * FROM ex3_1;

-- INSERT ~ SELECT형태
-- 사용법: INSERT INTO [스키마명].테이블명 (컬럼1, 컬럼2, ...) SELECT문;
CREATE TABLE ex3_2(
	emp_id 	  NUMBER,
	emp_name  VARCHAR2(100)
);

SELECT * FROM ex3_2;

INSERT INTO ex3_2(emp_id, emp_name) 
SELECT employee_id, emp_name FROM EMPLOYEES e WHERE salary > 5000
;

-- update문
-- 사용법: UPDATE [스키마명].테이블명 SET 컬럼1 = 변경값1, 컬럼2 = 변경값2, ... WHERE 조건

SELECT * FROM ex3_1;

-- INSERT INTO ex3_1 VALUES ('DEF', 20, SYSDATE);
INSERT INTO ex3_1 VALUES ('GHI', 20, '');

UPDATE ex3_1 SET col2 = 50;

UPDATE ex3_1 SET col3 = SYSDATE WHERE col3 IS NULL;

-- 문제
-- 테이블 ex3_1에서 컬럼 col1의 값이 'DEF'인 것만 col2의 값을 30으로 변경하세요.
UPDATE ex3_1 SET col2 = 30 WHERE col1 = 'DEF';

-- 문제
-- 테이블 ex3_1에서 컬럼 col2의 값이 30인 것만 가져와서 col2의 값을 10으로 변경하세요.
UPDATE ex3_1 SET col2 = 10 WHERE col2 = 30;


-- DELETE문
-- 사용법: DELETE FROM [스키마명].테이블명 WHERE 조건
SELECT * FROM ex3_1;

DELETE FROM ex3_1;

DELETE FROM ex3_1 WHERE col3 IS NULL;

-- COMMIT, ROLLBACK -> 트랜잭션(transaction) 
CREATE TABLE ex3_4 ( employee_id NUMBER );

INSERT INTO ex3_4 VALUES (100);

SELECT * FROM ex3_4;

COMMIT;

DELETE FROM ex3_4;

SELECT * FROM ex3_4;

ROLLBACK;

-- 데이터 완전히 삭제
TRUNCATE TABLE ex3_4;

-- MERGE문 -> INSERT와 UPDATE를 같이 사용할 때 사용. 데이터가 없으면 INSERT, 데이터가 있으면 UPDATE 혹은 DELETE문  실행
-- 사용법: MERGE INTO [스키마명].테이블명 USING (upsert 데이터 원천) ON (조건)
--        WHEN MATCHED THEN SET 컬럼1 = 값1, 컬럼2 = 값2, ... WHERE 조건 [DELETE WHERE 조건]
--        WHEN NOT MATCHED THEN INSERT (컬럼1, 컬럼2, ...) VALUES (값1, 값2, ...) WHERE 조건
--        
CREATE TABLE ex3_3 (
	employee_id 	NUMBER,
	bonus_amt       NUMBER 		DEFAULT 0
);

SELECT * FROM EMPLOYEES e;   -- employee_id가 1 ~ 5까지 존재

INSERT INTO ex3_3 (employee_id)
SELECT employee_id FROM EMPLOYEES e;

DELETE FROM ex3_3 e WHERE EMPLOYEE_ID = 4 OR EMPLOYEE_ID = 5; 

SELECT * FROM ex3_3;         -- employee_id가 1 ~ 3까지 존재

MERGE INTO ex3_3 d 
	USING (SELECT employee_id, salary FROM EMPLOYEES) b ON (d.employee_id = b.employee_id)
WHEN MATCHED THEN 
	UPDATE SET d.bonus_amt = b.salary * 0.01		-- employee_id값이 같은게 있을 때 
WHEN NOT MATCHED THEN 
	INSERT (d.employee_id, d.bonus_amt) VALUES(b.employee_id, b.salary * 0.001) -- employee_id값이 같지 않을 때
;

-- 문제
-- 테이블 ex3_3_1를 만들고 해당 테이블에 2개의 데이터로 employee_id 1과 2인 데이터를 생성
-- 기존 테이블인 employees테이블을 같이 사용하여 merge into문을 구현
-- (ex3_3_1 테이블의 컬럼에는 employee_id와 penalty_amt컬럼을 만들어 기존 salary데이터의 5% 감소한 금액을 저장하는 sql문을 생성)
CREATE TABLE ex3_3_1 (
	employee_id 	  NUMBER,
	penalty_amt       NUMBER 		DEFAULT 0
);

INSERT INTO ex3_3_1 (employee_id) VALUES (1);
INSERT INTO ex3_3_1 (employee_id) VALUES (2);

SELECT * FROM ex3_3_1;

MERGE INTO ex3_3_1 d 
	USING (SELECT employee_id, salary FROM EMPLOYEES) b ON (d.employee_id = b.employee_id)
WHEN MATCHED THEN 
	UPDATE SET d.penalty_amt = -b.salary * 0.05		-- employee_id값이 같은게 있을 때 
WHEN NOT MATCHED THEN 
	INSERT (d.employee_id, d.penalty_amt) VALUES(b.employee_id, -b.salary * 0.05) -- employee_id값이 같지 않을 때
;

DROP TABLE EMPLOYEES;

DROP TABLE DEPARTMENTS;


