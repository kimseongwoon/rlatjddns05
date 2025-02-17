-- 내부조인의 동등조인
-- 사원들이 속한 모든 부서정보의 이름과 사원의 일반적인 정보(사원이름, 입사일자, 급여...)를 가져오는 쿼리
SELECT a.employee_id
     , a.emp_name
     , a.department_id
     , b.department_name
  FROM employees a,
       departments b
 WHERE a.department_id = b.department_id   -- 동등 조인
;

SELECT * FROM EMPLOYEES e;
SELECT * FROM DEPARTMENTS d;

-- 내부조인의 세미조인
-- EXISTS, IN 연산자를 사용하여 서브쿼리와 함께 사용하는 쿼리
-- 급여가 300만원보다 큰 급여를 가지는 사원이 있는 부서들의 정보를 조회하는 쿼리
SELECT department_id
     , department_name
  FROM departments a
 WHERE EXISTS (SELECT * 
                 FROM employees b
                WHERE a.department_id = b.department_id
                  AND b.salary > 3000)
ORDER BY a.department_name;

SELECT department_id, department_name
  FROM departments a
 WHERE a.department_id IN (SELECT b.department_id
                               FROM employees b
                              WHERE b.salary > 3000)
ORDER BY department_name;

-- 6장 문제1 
-- 사번(employees의 employee_id), 사원명(employees의 emp_name)
-- job명칭(jobs의 job_title), job시작일자(job_history의 start_date)
-- job종료일자(job_history의 end_date), job수행부서명(departmets의 department_name)
SELECT e.employee_id
      ,e.emp_name
      ,jh.START_DATE
      ,jh.END_DATE
      ,j.JOB_TITLE
      ,d.DEPARTMENT_NAME
FROM EMPLOYEES e,
     JOB_HISTORY jh,
     JOBS j,
     DEPARTMENTS d
WHERE e.EMPLOYEE_ID = jh.EMPLOYEE_ID
  AND j.JOB_ID = jh.JOB_ID
  AND d.DEPARTMENT_ID = jh.DEPARTMENT_ID
  AND e.EMPLOYEE_ID = 101
;

SELECT * FROM jobs;
SELECT * FROM job_history;

