-- SQL ORACLE 함수

-- 1. 숫자 함수
-- abs함수 -> 절대값 반환 함수
SELECT ABS(10) FROM DUAL;      -- 10
SELECT ABS(-10) FROM DUAL;     -- 10
SELECT ABS(-10.123) FROM DUAL;     -- 10.123

SELECT ABS(10), ABS(-10), ABS(-10.123) FROM DUAL;

-- ceil -> 가장 큰 정수 반환(올림함수),   floor -> 가장 낮은 정수 반환(내림함수)
SELECT CEIL(10.123), CEIL(10.541), CEIL(11.001), CEIL(11.000)
  FROM DUAL;
SELECT FLOOR(10.123), FLOOR(10.541), FLOOR(11.001), FLOOR(11.000) 
  FROM DUAL;
 
-- round(n,i) -> 매개변수 n을 소수점 i+1번째에서 반올림하는 함수,  trunc -> 절삭 함수
SELECT ROUND(10.154), ROUND(10.541), ROUND(11.001)
  FROM DUAL;
SELECT ROUND(10.154, 1), ROUND(10.154, 2), ROUND(10.154, 3)
  FROM DUAL;
SELECT ROUND(0, 3), ROUND(115.155, -1), ROUND(115.155, -2)
  FROM DUAL; 
 
-- 2. 문자 함수
-- initcap(단어의 첫문자만 대문자), lower(소문자), upper(대문자) 
SELECT INITCAP('never say goodbye'), INITCAP('never6say*good가bye')
  FROM DUAL;  
SELECT LOWER('NEVER SAY GOODBYE'), UPPER('never say goodbye')
  FROM DUAL;  
 
-- concat(문자 더하기), substr(문자 자르기), substrb(문자byte 자르기)
SELECT CONCAT('I Have', ' A Dream'), 'I Have' || ' A Dream'
  FROM DUAL;
SELECT SUBSTR('ABCD EFG', 1, 4)
  FROM DUAL;
SELECT SUBSTR('ABCDEFG', 1, 4), SUBSTR('ABCDEFG', -1, 4)
  FROM DUAL; 
SELECT SUBSTRB('ABCDEFG', 1, 4), SUBSTRB('가나다라마바사', 1, 4)
  FROM DUAL;
 
-- 3. 날짜 함수(날짜를 더하거나 빼거나 시간을 더하거나 빼거나...)
-- add_months, months_between, last_day, next_day(ex) 30 -> 31, 1)

-- 4. 변환 함수(ex) 문자 -> 날짜, 날짜 -> 문자, 숫자 -> 문자, ...)
-- to_char, to_number, to_date ... 

-- 5. NULL관련 함수(Oracle에 한정)
-- NVL(expr1, expr2) -> NULL(expr1)이면 value값(expr2)으로 대체 ->N(null)VL(value)
-- NVL2(expr1, expr2, expr3) -> NULL(expr1)이면 value값(expr2)이고 아니면  expr3로 대체  
SELECT * FROM EMPLOYEES ORDER BY EMPLOYEE_ID ASC;

SELECT NVL(manager_id, employee_id)  -- manager_id가 NULL이면 employee_id로 표시
  FROM employees
 WHERE manager_id IS NULL;

SELECT employee_id, 
       NVL2(commission_pct, salary + (salary * commission_pct), salary) AS salary2
  FROM employees;

-- COALESCE -> NULL이 아닌 첫 번째 표현식을 반환
SELECT employee_id, 
	   salary, 
	   commission_pct, 
       COALESCE (salary * commission_pct, salary) AS salary2  -- salary * commission_pct 한 값이 NULL이면 salary 아니면 연산한 값
  FROM employees;  

SELECT employee_id, 
	   salary, 
	   commission_pct, 
       NVL2(commission_pct, (salary * commission_pct), salary) AS salary2
  FROM employees;
 
-- LNNVL -> NVL로 다 대체해서 사용이 가능
SELECT *
  FROM employees
 WHERE NVL(commission_pct, 0) < 0.2;
 
SELECT *
  FROM employees
 WHERE LNNVL(commission_pct >= 0.2) ;

-- NULLIF(expr1, expr2) -> expr1과 expr2과 같으면 NULL 아니면 expr1을 반환
SELECT * FROM JOB_HISTORY;

SELECT employee_id,
       TO_CHAR(start_date, 'YYYY') start_year,
       TO_CHAR(end_date, 'YYYY') end_year,
       NULLIF(TO_CHAR(end_date, 'YYYY'), TO_CHAR(start_date, 'YYYY')) nullif_year
FROM job_history;

-- 6. 기타 함수
-- GREATEST(expr1, expr2, ...) -> 가장 큰 expr을 반환(글자 혹은 숫자 상관없이 사용이 가능)
-- LEAST(expr1, expr2, ...) - 가장 작은 expr을 반환(글자 혹은 숫자 상관없이 사용이 가능)
SELECT GREATEST(1, 2, 3, 2),
       LEAST(1, 2, 3, 2) 
  FROM DUAL;
  
SELECT GREATEST('이순신', '강감찬', '세종대왕'),
       LEAST('이순신', '강감찬', '세종대왕')
  FROM DUAL;
 
-- DECODE함수 (CASE WHEN으로 대체 가능)f
SELECT prod_id,
       DECODE(channel_id, 3, 'Direct',    -- channel_id가 3이면 'Direct'표시
                          9, 'Direct',    -- channel_id가 9이면 'Direct'표시
                          5, 'Indirect',  -- channel_id가 5이면 'Indirect'표시
                          4, 'Indirect',  -- channel_id가 4이면 'Indirect'표시
                             'Others') decodes  -- 나머지이면 'Others'표시
 FROM sales
WHERE rownum < 10; 

-- 4장 문제1
SELECT * FROM EMPLOYEES e;
 
SELECT employee_id
      ,REPLACE('(02)' || substr(phone_number, 5), '.', '-') AS phone1
      ,REPLACE(CONCAT('(02)', substr(phone_number, 5)), '.', '-') AS phone2
      ,LPAD(substr(phone_number, 5), 12, '(02)') AS phone3
FROM EMPLOYEES e
;

-- 4장 문제2
SELECT employee_id
      ,emp_name
      ,hire_date
      ,ROUND((sysdate - hire_date) / 365) AS 근속년수
  FROM EMPLOYEES e
 WHERE ROUND((sysdate - hire_date) / 365) >= 10
 ORDER BY hire_date
--ORDER BY 3
;

-- 4장 문제3
SELECT cust_name
     , REPLACE(CUST_MAIN_PHONE_NUMBER,'-','/') new_phone_number 
FROM CUSTOMERS c;

-- 4장 문제4
SELECT cust_name
     , TRANSLATE(CUST_MAIN_PHONE_NUMBER,'0123456789','adsfgasfa') new_phone_number 
FROM CUSTOMERS c;

-- 4장 문제5(30대: 30 ~ 39, 40대: 40 ~ 49, 50대: 50 ~ 59, 나머지는 기타)
SELECT cust_name
     , CUST_YEAR_OF_BIRTH 
     , decode(TRUNC((to_char(sysdate, 'YYYY') - CUST_YEAR_OF_BIRTH) / 10), 
     			3, '30대',
     			4, '40대',
     			5, '50대', '기타') 세대표시
FROM CUSTOMERS c;

-- 4장 문제6
SELECT cust_name
     , CUST_YEAR_OF_BIRTH
     , CASE WHEN to_number(to_char(sysdate, 'YYYY') - CUST_YEAR_OF_BIRTH) >= 1
                 AND to_number(to_char(sysdate, 'YYYY') - CUST_YEAR_OF_BIRTH) <= 9 
                 THEN '영유아'
            WHEN to_number(to_char(sysdate, 'YYYY') - CUST_YEAR_OF_BIRTH) >= 10
                 AND to_number(to_char(sysdate, 'YYYY') - CUST_YEAR_OF_BIRTH) <= 19 
                 THEN '10대'
            WHEN to_number(to_char(sysdate, 'YYYY') - CUST_YEAR_OF_BIRTH) >= 20
                 AND to_number(to_char(sysdate, 'YYYY') - CUST_YEAR_OF_BIRTH) <= 29 
                 THEN '20대'
            WHEN to_number(to_char(sysdate, 'YYYY') - CUST_YEAR_OF_BIRTH) >= 30
                 AND to_number(to_char(sysdate, 'YYYY') - CUST_YEAR_OF_BIRTH) <= 39 
                 THEN '30대'
            WHEN to_number(to_char(sysdate, 'YYYY') - CUST_YEAR_OF_BIRTH) >= 40
                 AND to_number(to_char(sysdate, 'YYYY') - CUST_YEAR_OF_BIRTH) <= 49 
                 THEN '40대'
            WHEN to_number(to_char(sysdate, 'YYYY') - CUST_YEAR_OF_BIRTH) >= 50
                 AND to_number(to_char(sysdate, 'YYYY') - CUST_YEAR_OF_BIRTH) <= 59 
                 THEN '50대'
            WHEN to_number(to_char(sysdate, 'YYYY') - CUST_YEAR_OF_BIRTH) >= 60
                 AND to_number(to_char(sysdate, 'YYYY') - CUST_YEAR_OF_BIRTH) <= 69 
                 THEN '60대'
            ELSE '기타'
       END AS new_generation
FROM CUSTOMERS c;



