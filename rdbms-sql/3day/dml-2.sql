SELECT * 
FROM CHANNELS c
WHERE CHANNEL_CLASS = 'Direct'
;

SELECT * 
FROM COUNTRIES c2
WHERE COUNTRY_SUBREGION = 'Western Europe'
;

SELECT * 
FROM CUSTOMERS c
;

-- 의사컬럼(Pseudo Column) -> 오라클에서만 사용 가능
-- NEXTVAL, CURRVAL -> 시퀀스에서 사용하는 의사컬럼
CREATE SEQUENCE my_seq1 INCREMENT BY 1 START WITH 1;

SELECT my_seq1.NEXTVAL FROM DUAL
;

SELECT my_seq1.CURRVAL FROM DUAL
;

-- ROWNUM, ROWID -> 각 행들에 대한 순서값을 표현해줌
SELECT ROWNUM, employee_id
  FROM EMPLOYEES e
;

SELECT *
  FROM EMPLOYEES e
;

SELECT ROWNUM, employee_id
  FROM EMPLOYEES e
 WHERE ROWNUM < 5 
;

SELECT ROWID, employee_id
  FROM EMPLOYEES e
;

-- 수식 연산자 -> +,-,*,/
SELECT 1 + 1 AS plus FROM DUAL
;

-- 문자 더하기 연산자 -> ||
SELECT employee_id || '-' || emp_name AS employee_info
FROM EMPLOYEES e
WHERE ROWNUM < 5
;

-- 관계 및 논리연산자 -> >, <, >=, <=, !=(같지 않다), <>(같지 않다), =
SELECT employee_id || '-' || emp_name AS employee_info
FROM EMPLOYEES e
WHERE EMPLOYEE_ID <> 101 
;

-- CASE WHEN 연산자 -> c# if 혹은 switch 문과 비슷
-- 사용법: CASE WHEN 조건1 THEM 값1
--            WHEN 조건2 THEM 값2
--            ...
--            [ELSE 기타 값]    
--        END [AS 컬럼명]
SELECT employee_id, salary, 
	   CASE WHEN salary <= 5000 THEN 'C등급'
	        WHEN salary > 5000 AND salary <= 15000 THEN 'B등급'
	        ELSE 'A등급'
	   END AS salary_grade
  FROM employees
;

-- 비교 조건식 -> ANY, SOME, ALL  (AND,OR와 같이 비교)
-- ANY == SOME -> OR를 여러개 한 것
SELECT employee_id, salary
  FROM EMPLOYEES e
 WHERE salary = ANY(2000, 3000, 4000)   -- 2000 혹은 3000 혹은 4000인 것 가져오기
-- WHERE salary = 2000 OR salary = 3000 OR salary = 4000
 ORDER BY employee_id
;

-- ALL -> AND를 여러개 한 것
SELECT employee_id, salary
  FROM EMPLOYEES e
 WHERE salary = ALL(2000, 3000, 4000)   -- 2000 그리고 3000 그리고 4000인 것 가져오기
-- WHERE salary = 2000 AND salary = 3000 AND salary = 4000
 ORDER BY employee_id
;

-- NOT 논리 조건식
SELECT employee_id, salary
  FROM EMPLOYEES e
 WHERE NOT(salary >= 2500)    -- == salary < 2500
 ORDER BY employee_id
;

-- NULL 조건식
-- NULL 경우에는 '= NULL','<> NULL'연산자 사용하지 말고 'IS NULL' 혹은 'IS NOT NULL'을 사용하자 
SELECT *
FROM EMPLOYEES e
WHERE DEPARTMENT_ID IS NOT NULL
;

-- BETWEEN AND 조건식
-- 급여가 2000에서 2500사이에 해당하는 사원을 조회
SELECT employee_id, salary
  FROM EMPLOYEES e
-- WHERE SALARY >= 2000 AND SALARY <= 2500
 WHERE SALARY BETWEEN 2000 AND 2500
 ORDER BY employee_id
;

-- IN, NOT IN 조건식
SELECT employee_id, salary
  FROM EMPLOYEES e
 WHERE salary IN (2000, 3000, 4000)   -- ANY와 같은 효과
 ORDER BY employee_id
;

SELECT employee_id, salary
  FROM EMPLOYEES e
 WHERE salary NOT IN (2000, 3000, 4000)   -- <> ALL 같은 효과
 ORDER BY employee_id
;

-- EXISTS 조건식 -> 서브쿼리에서 사용
SELECT employee_id, salary, 
       (SELECT SALARY FROM EMPLOYEES e2 WHERE EMPLOYEE_ID IN (101)) AS e101_salary
  FROM EMPLOYEES e
WHERE e.salary = 3000
;

-- 봉급이 3000원 보다 큰 사원들의 부서ID와  부서명을 가져오는 쿼리
SELECT DEPARTMENT_ID, DEPARTMENT_NAME
  FROM DEPARTMENTS a
 WHERE EXISTS (
 			SELECT * 
 			  FROM EMPLOYEES b 
 			 WHERE a.DEPARTMENT_ID = b.DEPARTMENT_ID AND b.SALARY > 3000
 	   )
 ORDER BY a.DEPARTMENT_NAME	
;

SELECT DEPARTMENT_ID, DEPARTMENT_NAME
  FROM DEPARTMENTS a
;

SELECT * FROM EMPLOYEES e;

-- LIKE 연산자 조건식 -> 문자 비교 및 패턴시 많이 사용
-- 사원이름이 'A'로 시작되는 사원을 조회
SELECT *
  FROM EMPLOYEES e
 WHERE EMP_NAME LIKE 'A%'
 ORDER BY emp_name
;

-- 사원이름이 'Al'로 시작되는 사원을 조회
SELECT *
  FROM EMPLOYEES e
 WHERE EMP_NAME LIKE 'Al%'
 ORDER BY emp_name
;

-- 사원이름이 'nt'로 끝나는 사원을 조회
SELECT *
  FROM EMPLOYEES e
 WHERE EMP_NAME LIKE '%nt'
 ORDER BY emp_name
;

-- 사원이름이 'as'가 있는 사원을 조회
SELECT *
  FROM EMPLOYEES e
 WHERE EMP_NAME LIKE '%as%'
 ORDER BY emp_name
;

CREATE TABLE ex3_5 (
	names varchar2(30)
);

INSERT INTO ex3_5 VALUES ('홍길동');
INSERT INTO ex3_5 VALUES ('홍길용');
INSERT INTO ex3_5 VALUES ('홍길상');
INSERT INTO ex3_5 VALUES ('홍길상동');

SELECT *
  FROM ex3_5
 WHERE names LIKE '홍길%';   -- '%'는 모든 글자를 뜻함
 
 SELECT *
  FROM ex3_5
 WHERE names LIKE '홍길_';   -- '_'는 한 글자만 해당

-- 책 3장 문제1
CREATE TABLE ex3_6 (
	employee_id   number(6),
	emp_name      varchar2(80),
	salary        number(8),
	manager_id    number(6)
);
INSERT INTO ex3_6
SELECT employee_id, emp_name, salary, manager_id FROM EMPLOYEES e
WHERE e.manager_id = 124 AND e.salary >= 2000 AND e.SALARY <= 3000
;

SELECT * FROM ex3_6;

-- 책 3장 문제3
SELECT EMPLOYEE_ID, EMP_NAME FROM EMPLOYEES e
WHERE COMMISSION_PCT IS NULL;

-- 책 3장 문제4
SELECT EMPLOYEE_ID, EMP_NAME FROM EMPLOYEES e
WHERE SALARY >= 2000 AND SALARY <= 2500;

-- 책 3장 문제5
SELECT employee_id, salary 
  FROM employees
WHERE salary = ANY(2000, 3000, 4000)
ORDER BY employee_id;

SELECT employee_id, salary 
  FROM employees
WHERE salary <> ALL(2000, 3000, 4000)
ORDER BY employee_id;


