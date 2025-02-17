-- 5장. 그룹 관련된 쿼리

-- count(expr)함수 -> 조건에 맞는 행의 개수를 반환
SELECT * FROM EMPLOYEES e;                         -- 107
SELECT COUNT(*) AS CNT FROM EMPLOYEES e;           -- 107
SELECT COUNT(EMPLOYEE_ID) AS CNT FROM EMPLOYEES e; -- 107
SELECT COUNT(DEPARTMENT_ID) AS CNT FROM EMPLOYEES e; -- 106

-- distinct -> unique값들만 체크
SELECT COUNT(DISTINCT department_id) FROM EMPLOYEES e;

SELECT count(*) FROM DEPARTMENTS d;

SELECT DISTINCT department_id FROM EMPLOYEES e;

-- sum(expr)함수 -> 조건에 맞는 행 및 열의 값을 더한 수를 반환
SELECT sum(salary) FROM EMPLOYEES e;

SELECT sum(salary), sum(DISTINCT salary) FROM EMPLOYEES e;

-- avg(expr)함수 -> 조건에 맞는 행 및 열의 값의 평균값을 반환
SELECT avg(salary), avg(DISTINCT salary) FROM EMPLOYEES e;

-- min(expr)함수 -> 조건에 맞는 행 및 열의 값의 가장 작은 값을 반환
-- max(expr)함수 -> 조건에 맞는 행 및 열의 값의 가장 큰 값을 반환
SELECT MIN(salary), MAX( salary)
  FROM employees;       
  
SELECT MIN(DISTINCT salary), MAX(DISTINCT salary)
  FROM employees;   


SELECT sum(salary) FROM EMPLOYEES e WHERE DEPARTMENT_ID = 10;
SELECT sum(salary) FROM EMPLOYEES e WHERE DEPARTMENT_ID = 20;
SELECT sum(salary) FROM EMPLOYEES e WHERE DEPARTMENT_ID = 30;
SELECT sum(salary) FROM EMPLOYEES e WHERE DEPARTMENT_ID = 40;
...

-- group by절
-- 부서별로 봉급을 합한 데이터를 가져오는 쿼리
SELECT department_id, sum(salary)
  FROM EMPLOYEES e
 GROUP BY DEPARTMENT_ID
 ORDER BY DEPARTMENT_ID;

SELECT * 
FROM kor_loan_status
WHERE PERIOD = '201310'
AND REGION = '경북'
;


-- 2013년도 지역별 가계대출의 총 잔액을 가져오는 쿼리
SELECT period, region, sum(LOAN_JAN_AMT) AS total_jan
FROM kor_loan_status
WHERE PERIOD LIKE '2013%'
GROUP BY PERIOD, REGION
ORDER BY period, region
;

SELECT period, region, sum(LOAN_JAN_AMT) AS total_jan
FROM kor_loan_status
WHERE PERIOD = '201311'
GROUP BY REGION
ORDER BY region
;  -- error

-- having절 -> group by의 조건절
-- 2013년 11월의 대출잔액이 100조이상건 만 추출하는 쿼리
SELECT period, region, sum(LOAN_JAN_AMT) AS total_jan
FROM kor_loan_status
WHERE PERIOD = '201311'
GROUP BY period, REGION
HAVING sum(LOAN_JAN_AMT) > 100000
ORDER BY region
;

-- 5장 문제 1
SELECT to_char(hire_date, 'YYYY') AS hire
      ,count(hire_date) AS hire_cnt
FROM EMPLOYEES e
GROUP BY to_char(hire_date, 'YYYY')
ORDER BY to_char(hire_date, 'YYYY')
;

-- 5장 문제 2
SELECT PERIOD, REGION, sum(LOAN_JAN_AMT) AS loan_jan_sum
FROM KOR_LOAN_STATUS kls
WHERE PERIOD LIKE '2012%'
GROUP BY PERIOD, REGION
ORDER BY PERIOD, REGION
;

-- rollup(expr1, expr2, ...) -> expr로 명시한 표현식을 기준으로 추가적인 집계를 반환
SELECT period, gubun, sum(LOAN_JAN_AMT) AS total_jan
FROM kor_loan_status
WHERE PERIOD LIKE '2013%'
GROUP BY PERIOD, gubun
ORDER BY period
;

SELECT period, gubun, sum(LOAN_JAN_AMT) AS total_jan
FROM kor_loan_status
WHERE PERIOD LIKE '2013%'
GROUP BY ROLLUP(period, gubun)
ORDER BY period
;

-- partial(분할) rollup
SELECT period, gubun, sum(LOAN_JAN_AMT) AS total_jan
FROM kor_loan_status
WHERE PERIOD LIKE '2013%'
GROUP BY period, ROLLUP(gubun)
ORDER BY period
;

SELECT period, gubun, sum(LOAN_JAN_AMT) AS total_jan
FROM kor_loan_status
WHERE PERIOD LIKE '2013%'
GROUP BY ROLLUP(period), gubun
;

-- cube
 SELECT period, gubun, SUM(loan_jan_amt) totl_jan
  FROM kor_loan_status
 WHERE period LIKE '2013%' 
 GROUP BY CUBE(period, gubun);

CREATE TABLE exp_goods_asia (
       country VARCHAR2(10),
       seq     NUMBER,
       goods   VARCHAR2(80)
);

INSERT INTO exp_goods_asia VALUES ('한국', 1, '원유제외 석유류');
INSERT INTO exp_goods_asia VALUES ('한국', 2, '자동차');
INSERT INTO exp_goods_asia VALUES ('한국', 3, '전자집적회로');
INSERT INTO exp_goods_asia VALUES ('한국', 4, '선박');
INSERT INTO exp_goods_asia VALUES ('한국', 5,  'LCD');
INSERT INTO exp_goods_asia VALUES ('한국', 6,  '자동차부품');
INSERT INTO exp_goods_asia VALUES ('한국', 7,  '휴대전화');
INSERT INTO exp_goods_asia VALUES ('한국', 8,  '환식탄화수소');
INSERT INTO exp_goods_asia VALUES ('한국', 9,  '무선송신기 디스플레이 부속품');
INSERT INTO exp_goods_asia VALUES ('한국', 10,  '철 또는 비합금강');

INSERT INTO exp_goods_asia VALUES ('일본', 1, '자동차');
INSERT INTO exp_goods_asia VALUES ('일본', 2, '자동차부품');
INSERT INTO exp_goods_asia VALUES ('일본', 3, '전자집적회로');
INSERT INTO exp_goods_asia VALUES ('일본', 4, '선박');
INSERT INTO exp_goods_asia VALUES ('일본', 5, '반도체웨이퍼');
INSERT INTO exp_goods_asia VALUES ('일본', 6, '화물차');
INSERT INTO exp_goods_asia VALUES ('일본', 7, '원유제외 석유류');
INSERT INTO exp_goods_asia VALUES ('일본', 8, '건설기계');
INSERT INTO exp_goods_asia VALUES ('일본', 9, '다이오드, 트랜지스터');
INSERT INTO exp_goods_asia VALUES ('일본', 10, '기계류');

SELECT * FROM EXP_GOODS_ASIA ega;

SELECT goods FROM EXP_GOODS_ASIA ega WHERE COUNTRY = '한국';
SELECT goods FROM EXP_GOODS_ASIA ega WHERE COUNTRY = '일본';

-- UNION -> 중복된 데이터는 1개씩만 행으로 반환, 컬럼의 개수는 일치하여야 함
SELECT goods FROM EXP_GOODS_ASIA ega WHERE COUNTRY = '한국'
UNION
SELECT goods FROM EXP_GOODS_ASIA ega WHERE COUNTRY = '일본';

-- UNION ALL -> 중복된 것이라도 행으로 표현, 컬럼의 개수는 일치하여야 함
SELECT goods FROM EXP_GOODS_ASIA ega WHERE COUNTRY = '한국'
UNION ALL
SELECT goods FROM EXP_GOODS_ASIA ega WHERE COUNTRY = '일본';

-- INTERSECT -> 중복된 것만 행으로 표현, 컬럼의 개수는 일치하여야 함
SELECT goods FROM EXP_GOODS_ASIA ega WHERE COUNTRY = '한국'
INTERSECT
SELECT goods FROM EXP_GOODS_ASIA ega WHERE COUNTRY = '일본';

-- MINUS -> 위에서 아래 테이블의 데이터의 중복된 것 행을 제외한 나머지 행들만 반환, 컬럼의 개수는 일치하여야 함
SELECT goods FROM EXP_GOODS_ASIA ega WHERE COUNTRY = '한국'
MINUS
SELECT goods FROM EXP_GOODS_ASIA ega WHERE COUNTRY = '일본';

SELECT goods FROM EXP_GOODS_ASIA ega WHERE COUNTRY = '일본'
MINUS
SELECT goods FROM EXP_GOODS_ASIA ega WHERE COUNTRY = '한국';

-- 5장 문제3
-- 아래 rollup을 집합연산자로 변경
SELECT period, gubun, SUM(loan_jan_amt) totl_jan
  FROM kor_loan_status
 WHERE period LIKE '2013%' 
 GROUP BY period, ROLLUP( gubun );

SELECT period, gubun, SUM(loan_jan_amt) totl_jan
  FROM kor_loan_status
 WHERE period LIKE '2013%' 
 GROUP BY period, gubun
UNION
SELECT period, '', SUM(loan_jan_amt) totl_jan
  FROM kor_loan_status
 WHERE period LIKE '2013%' 
 GROUP BY period
;

-- 5장 문제4
SELECT period, 
       CASE WHEN gubun = '주택담보대출' THEN SUM(loan_jan_amt) ELSE 0 END 주택담보대출액,
       CASE WHEN gubun = '기타대출'     THEN SUM(loan_jan_amt) ELSE 0 END 기타대출액 
  FROM kor_loan_status
 WHERE period = '201311' 
 GROUP BY period, gubun;

SELECT period, 
       SUM(loan_jan_amt) AS 주택담보대출액,
       0 AS 기타대출액
  FROM kor_loan_status
 WHERE period = '201311' 
   AND gubun = '주택담보대출'
 GROUP BY period, gubun
UNION 
 SELECT period, 
 		0 AS 주택담보대출액,
        SUM(loan_jan_amt) AS 기타대출액
  FROM kor_loan_status
 WHERE period = '201311' 
   AND gubun = '기타대출'
 GROUP BY period, gubun
;

-- 5장 문제5
---------------------------------------------------------------------------------------
지역   201111   201112    201210    201211   201212   201310    201311
---------------------------------------------------------------------------------------
서울   
부산
...
...
---------------------------------------------------------------------------------------

SELECT REGION AS 지역
      ,SUM(LOAN_JAN_AMT) AS amt
FROM KOR_LOAN_STATUS
GROUP BY REGION
;

SELECT PERIOD
      ,SUM(LOAN_JAN_AMT) AS amt
FROM KOR_LOAN_STATUS
GROUP BY PERIOD
;

SELECT REGION
	  ,sum(amt_201111) AS "201111"
	  ,sum(amt_201112) AS "201112"
	  ,sum(amt_201210) AS "201210"
	  ,sum(amt_201211) AS "201211"
	  ,sum(amt_201212) AS "201212"
	  ,sum(amt_201310) AS "201310"
	  ,sum(amt_201311) AS "201311"
FROM (
	SELECT REGION
	      , CASE WHEN PERIOD = '201111' THEN LOAN_JAN_AMT ELSE 0 END amt_201111
          , CASE WHEN PERIOD = '201112' THEN LOAN_JAN_AMT ELSE 0 END amt_201112
          , CASE WHEN PERIOD = '201210' THEN LOAN_JAN_AMT ELSE 0 END amt_201210
          , CASE WHEN PERIOD = '201211' THEN LOAN_JAN_AMT ELSE 0 END amt_201211
          , CASE WHEN PERIOD = '201212' THEN LOAN_JAN_AMT ELSE 0 END amt_201212
          , CASE WHEN PERIOD = '201310' THEN LOAN_JAN_AMT ELSE 0 END amt_201310
          , CASE WHEN PERIOD = '201311' THEN LOAN_JAN_AMT ELSE 0 END amt_201311
	FROM KOR_LOAN_STATUS
)
GROUP BY REGION
;



