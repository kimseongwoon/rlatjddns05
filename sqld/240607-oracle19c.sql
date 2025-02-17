SELECT * FROM DUAL
; 
-- 한줄 sql주석
-- crtl + enter
-- 41 ~ 42page

ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE
;

-- 1. 사용자 계정 생성
CREATE USER test1 IDENTIFIED BY 1234
;

-- 2. 사용자 계정 삭제
-- DROP USER test1
-- ;

-- 3. 계정 잠금 해제
ALTER USER test1 account unlock
;

-- 4. 계정 권한 부여
GRANT resource, dba, CONNECT TO test1
;

-- test1계정에 테이블 생성 권한 부여
GRANT CREATE ANY TABLE TO test1
;
--GRANT ALTER ANY TABLE TO test1;
--GRANT DROP ANY TABLE TO test1;

/*
CREATE USER test2 IDENTIFIED BY 1234
;
DROP USER test2 CASCADE
;
*/

SELECT PROFILE, LIMIT FROM DBA_PROFILES WHERE RESOURCE_NAME = 'IDLE_TIME'
;

ALTER PROFILE DEFAULT LIMIT IDLE_TIME 120
;

SELECT * FROM test1.student_score
;


-- 0.
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE
;

-- 1. 사용자 계정 생성
CREATE USER test2 IDENTIFIED BY 1234
;

-- 2. 사용자 계정 삭제
-- DROP USER test2 CASCADE
-- ;

-- 3. 계정 권한 부여
GRANT resource, dba, CONNECT TO test2
;

-- 4. test2계정에 테이블 생성 권한 부여
GRANT CREATE ANY TABLE TO test2
;


-- ------------------------------------------------------
CREATE USER sunggun IDENTIFIED BY sunggun
;

GRANT resource, dba, CONNECT TO sunggun
;

GRANT CREATE ANY TABLE TO sunggun
;

-- ------------------------------------------------------
--CREATE USER jintae IDENTIFIED BY jintae
--;
--
--DROP USER jintae CASCADE
--;
--
--GRANT resource, dba, CONNECT TO jintae
--;
--
--GRANT CREATE ANY TABLE TO jintae
--;

--show parameter processes;
--show parameter sessions;

-- ------------------------------------------------------
-- 1. 사용자 계정 생성
CREATE USER semi_2405_team3 IDENTIFIED BY 1234
;

-- 2. 사용자 계정 삭제
--DROP USER semi_2405_team1 CASCADE
--;

-- 3. 계정 권한 부여
GRANT resource, dba, CONNECT TO semi_2405_team3
;

-- 4. SEMI_2405_TEAM1계정에 테이블 생성 권한 부여
GRANT CREATE ANY TABLE TO semi_2405_team3
;

-- 현재 연결되어있는 모든 세션
SELECT * FROM v$session
;

-- 최대 세션수 변경(커넥션?)
--alter system set sessions=4096 scope=spfile
--;
-- 최대 프로세스수 변경(커넥션?)
--alter system set processes=4096 scope=SPFILE
--;

select * from v$resource_limit
;
select * from v$license
;

--shutdown IMMEDIATE
--;
--startup
--;


-- 다른 것보다 우선시 실행해~
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE
;

CREATE USER boarduser1 IDENTIFIED BY 1234
;

GRANT resource, dba, CONNECT TO boarduser1
;

GRANT CREATE ANY TABLE TO boarduser1
;




