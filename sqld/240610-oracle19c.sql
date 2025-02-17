-- 테이블 생성
-- create와 table 지정어(preserved keyword)
-- tb_rm_tmp는 테이블 이름
-- 2개의 컬럼(rn_cd, rn)
CREATE TABLE tb_rn_tmp  -- 도로명임시
(
	rn_cd varchar2(12)  NOT NULL,   -- 도로명코드(PK)
	rn    varchar2(150) NOT NULL    -- 도로명 이름
);

/*
CREATE TABLE 테이블이름(
	컬럼이름1 데이터타입1 제약조건(option),  -- 아무것도 없으면 기본이 NULL
	컬럼이름2 데이터타입2 제약조건(option),
	컬럼이름3 데이터타입3 제약조건(option),
	컬럼이름4 데이터타입4 제약조건(option)
);
*/

-- char: 고정길이 문자열      -> java에서는 String
-- varchar2: 가변길이 문자열  -> java에서는 String  
-- number: 숫자(소수점 포함)  -> java에서는 int, long, float, double
-- date: 날짜			   -> java에서는 Date, DateTime etc...

-- 테이블 삭제
DROP TABLE tb_rn_tmp
;

/*
DROP TABLE 테이블이름;
*/

-- 기본키 이름 -> pk_tb_subway_statn_tmp
-- 기본키 컬럼 -> subway_statn_no 
-- 기본키는 NULL 입력이 불가능. 중복된 데이터를 보관할 수 없음 
CREATE TABLE tb_subway_statn_tmp  -- 지하철역 임시
(
 	subway_statn_no char(6)           NOT NULL, -- 지하철역번호
 	ln_nm           varchar2(50)      NOT NULL, -- 노선명
 	statn_nm        varchar2(50)      NOT NULL, -- 역명
 	CONSTRAINT pk_tb_subway_statn_tmp PRIMARY KEY(subway_statn_no)
);

DROP TABLE tb_subway_statn_tmp
;

-- 지하철역 승하차임시 테이블 -> tb_subway_stain_tmp(지하철역 임시테이블)의 자식 테이블
CREATE TABLE tb_subway_statn_tk_gff_tmp  
(
	subway_statn_no CHAR(6) 		NOT NULL,
	std_ym          CHAR(6) 		NOT NULL,
	begin_time      CHAR(4) 		NOT NULL,
	end_time        CHAR(4) 		NOT NULL,
	tk_gff_se_cd    VARCHAR2(6) 	NOT NULL,
	tk_gff_cnt      NUMBER(15) 		NOT NULL,
	CONSTRAINT pk_tb_subway_statn_tk_gff_tmp 
		PRIMARY KEY(subway_statn_no, std_ym, begin_time, end_time, tk_gff_cnt)
);

-- 테이블 관련해서 수정
-- 컬럼 추가
ALTER TABLE tb_subway_statn_tk_gff_tmp ADD col1 number(10)
;

-- 컬럼 수정(데이터 타입 등)
ALTER TABLE tb_subway_statn_tk_gff_tmp MODIFY col1 char(10)
;

-- 컬럼이름 변경(col1 -> col2)
ALTER TABLE tb_subway_statn_tk_gff_tmp RENAME COLUMN col1 TO col2
;

-- 컬럼 제약조건 NOT NULL을 추가
ALTER TABLE tb_subway_statn_tk_gff_tmp MODIFY col2 NOT NULL
;

/*
ALTER TABLE 테이블이름 액션키워드(ADD, MODIFY etc) 액션키워드에맞는코드  
*/

-- tb_subway_stain_tmp의 자식 테이블인 tb_subway_statn_tk_gff_tmp와 fk로 연결코드
ALTER TABLE tb_subway_statn_tk_gff_tmp ADD CONSTRAINT fk_tb_subway_statn_tk_gff_tmp1
FOREIGN KEY(subway_statn_no) REFERENCES tb_subway_statn_tmp(subway_statn_no)
;


------------------------------------------------------------------------------------
-- 데이터 입력 INSERT문
-- 형태 -> INSERT INTO 테이블이름(컬럼1, 컬럼2, ....) VALUES(컬럼1의데이터값, 컬럼2의데이터값, )
INSERT INTO tb_subway_statn_tmp(SUBWAY_STATN_NO, LN_NM, STATN_NM)
VALUES ('000032', '2호선', '강남')
;

INSERT INTO tb_subway_statn_tmp(SUBWAY_STATN_NO, LN_NM, STATN_NM) 
VALUES ('000031', '1호선', '수원')
;

INSERT INTO tb_subway_statn_tmp A
(
	SUBWAY_STATN_NO, 
	LN_NM, 
	STATN_NM
)
VALUES 
(
	'000033', 
	'1호선', 
	'평택'
)
;

-- 데이터 조회 SELECT문
-- 형태 -> SELECT 컬럼1, 컬럼2, ... FROMS 테이블이름 (WHERE 검색조건)
SELECT SUBWAY_STATN_NO, LN_NM, STATN_NM FROM tb_subway_statn_tmp
;

SELECT SUBWAY_STATN_NO, LN_NM FROM tb_subway_statn_tmp
;

-- 모든 컬럼 -> *
-- 모든 데이터 가져오기1
SELECT * FROM tb_subway_statn_tmp
;

-- SELECT문의 alias기능 -> 테이블 옆의 축약할 수 있는 알파벳
-- 모든 데이터 가져오기2
SELECT A.SUBWAY_STATN_NO, A.LN_NM, A.STATN_NM FROM tb_subway_statn_tmp A
;

-- 모든 데이터 가져오기3
SELECT A.* FROM tb_subway_statn_tmp A
;

-- 컬럼명이 STATN_NM인 것의 데이터가 '강남'데이터만 가져오기
SELECT A.* FROM tb_subway_statn_tmp A
WHERE STATN_NM = '강남'
;

-- 데이터 수정 update문
-- 형태 -> UPDATE 테이블이름 SET 컬럼1 = 바꾸어할데이터, 컬럼2 = 바꾸어할데이터, ... (WHERE 검색조건)
UPDATE tb_subway_statn_tmp SET statn_nm = '천안'
;

UPDATE tb_subway_statn_tmp SET statn_nm = '강남' WHERE SUBWAY_STATN_NO = '000032' 
;

UPDATE tb_subway_statn_tmp SET statn_nm = '평택' 
WHERE SUBWAY_STATN_NO = '000033' AND LN_NM = '1호선' 
;

-- 데이터 삭제 delete문
-- 형태 -> DELETE FROM 테이블 이름 (WHERE 검색조건)
DELETE FROM tb_subway_statn_tmp WHERE subway_statn_no = '000034'
;

-- 모든 행 삭제
DELETE FROM tb_subway_statn_tmp
;

------------------------------------------------------------------------------------------
-- SELECT문 심화내용
-- 1. 조회시 컬럼명 변경 -> 컬럼명 AS 바꾸고싶은컬럼명
SELECT subway_statn_no AS 역전코드, ln_nm, statn_nm AS stat_name FROM tb_subway_statn_tmp
;

-- 2. alias 있는 경우 alias를 사용하여 컬럼명에 접근해야 한다.
-- (X) -> SELECT tb_subway_statn_tmp.* FROM tb_subway_statn_tmp A WHERE A.ln_nm = '1호선'
SELECT A.* FROM tb_subway_statn_tmp A WHERE A.ln_nm = '1호선'
;

-- 3. select의 distinct문
-- 중복된 행을 제거하는 용도
SELECT DISTINCT A.LN_NM, A.STATN_NM FROM tb_subway_statn_tmp A
;

SELECT A.* FROM tb_subway_statn_tmp A
;

INSERT INTO tb_subway_statn_tmp A
(
	SUBWAY_STATN_NO, 
	LN_NM, 
	STATN_NM
)
VALUES 
(
	'000034', 
	'1호선', 
	'평택'
)
;

-- 4. select문 합성연산자 -> '||' 사용
-- 만약 statn_nm컬럼의 값의 끝에 '역'이라는 글자 붙이고 싶을 때
SELECT SUBWAY_STATN_NO, LN_NM, STATN_NM || '역' AS station_name FROM tb_subway_statn_tmp
;
SELECT SUBWAY_STATN_NO, LN_NM || '-' || STATN_NM || '역' AS station_name 
FROM tb_subway_statn_tmp
;

-- 5. dual테이블을 활용한 임시 연산
SELECT 1+1 FROM dual
;
SELECT ((1+1)*3) / 6 AS "연산결과값" FROM dual
;

CREATE TABLE sample
(
	col1 NUMBER,
	col2 NUMBER
);

SELECT * FROM sample
;

INSERT INTO sample(col1, col2) VALUES (10, 5);
INSERT INTO sample(col1) VALUES (20);  -- INSERT INTO sample(col1, col2) VALUES (20, NULL);
INSERT INTO sample(col1, col2) VALUES (NULL, NULL);


-- col1이 null인 것만 가져오기
SELECT * FROM sample WHERE col1 IS NULL;	 -- col1의 값이 NULL인 경우의 데이터만 가져오기
SELECT * FROM sample WHERE col1 IS NOT NULL; -- col1의 값이 NOT NULL인 경우의 데이터만 가져오기

SELECT col1 + col2 FROM sample;  -- null인 경우의 더하기는 NULL

-- null인 경우 숫자로 변환해서 null인 안되게 숫자처리 하는 방법 -> nvl함수 -> nvl(컬럼, null인 경우 대체할 값)
SELECT nvl(col1, 0) + nvl(col2, 0) AS col FROM sample; -- col1이 NULL인 경우 0, col2가 NULL인 경우 0


-------------------------------------------------------------------------------------------------
-- 오라클 함수 예제들
-- 1. CHR함수 -> ASCII코드 128개의 숫자를 문자로 표현하기 위해 정의한 함수
SELECT CHR(65) FROM DUAL  		-- ascii 코드표에서 65는 'A'
;

-- 2. LOWER함수 -> 영어인 경우 대문자로 된 것을 소문자로 변경해주는 함수
SELECT LOWER('ABCabc') FROM dual;   -- abcabc

-- 3. UPPER함수 -> 영어인 경우 소문자로 된 것을 대문자로 변경해주는 함수
SELECT UPPER('ABCabc') FROM dual;   -- ABCABC

-- 4. LTRIM함수 -> 왼쪽에 공백을 없애주는 함수
SELECT LTRIM('    JENNIE') FROM dual;   -- JENNIE
SELECT LTRIM('블랙핑크', '블랙') FROM dual;   -- 핑크
SELECT '    JENNIE' FROM dual;          --     JENNIE

-- 5. RTRIM함수 -> 오른쪽에 공백을 없애주는 함수
SELECT RTRIM('JENNIE     ') FROM dual;   -- JENNIE
SELECT RTRIM('블랙핑크', '핑크') FROM dual;   -- 블랙
SELECT 'JENNIE     ' FROM dual;          -- JENNIE

SELECT RTRIM(LTRIM('  SQ L D   ')) FROM dual;

SELECT RTRIM(LTRIM('SQL DEVELOPER', 'S'), 'SQL') FROM dual;
;  -- RTRIM('QL DEVELOPER', 'SQL') -> QL DEVELOPER

-- 6. TRIM함수 -> 문자열 양 옆의 빈 공백을 없애주는 함수
SELECT TRIM('   JENNIE   ') FROM dual;  -- JENNIE

-- 7. SUBSTR함수 -> substr(문자열, 시작점, [길이]) -> 문자열을 원하는 부분만 잘라서 반환(시작점은 1부터 시작)
SELECT SUBSTR('블랙핑크제니', 3, 2) FROM dual;		-- 핑크
SELECT SUBSTR('블랙핑크제니', 3) FROM dual;		-- 핑크제니
SELECT SUBSTR('블랙핑크제니', 3, 4) FROM dual;		-- 핑크제니

SELECT SUBSTR('블랙핑크제니', 3, 4) FROM dual;		-- 핑크제니

-- 8. LENGTH함수 -> 문자열 길이 반환
SELECT LENGTH('블랙핑크제니') FROM dual;	-- 6
SELECT LENGTH('JENNIE') FROM dual;		-- 6




