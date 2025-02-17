import oracledb         # oracledb 라이브러리 임포트(불러오기)

con = oracledb.connect(user="boarduser1", password="1234", dsn="localhost:1521/orcl")   # DB에 연결 (호스트이름 대신 IP주소 가능)
cursor = con.cursor()   # 연결된 DB 지시자(커서) 생성

print('데이터베이스 연결 성공~!!!')

cursor.execute("select * from board")       # DB 명령 실행 (cursor가 임시 보관)
out_data = cursor.fetchall()   # cursor가 임시 보관한 내용을 out_data에 저장 (결과는 리스트)
# out_data 내용 출력해보기
for record in out_data :
	# print(record[2])
    print(record)
	
con.close()   # DB 연결 해제


#################################################################################################################################

# con = oracledb.connect(user="system", password="oracle", dsn="localhost:1521/XEPDB1") # 데이터베이스에 연결
# cursor = con.cursor() # 연결된 데이터베이스 지시자 생성

# print('데이터베이스 연결 성공~!!!')

# # 1. emp테이블의 내용 확인
# cursor.execute("select * from emp") # 데이터베이스 명령 실행( cursor가 임시로 보관)
# out_data = cursor.fetchall() # 커서의 내용을 out_data에 저장 
# for record in out_data: # out_data의 내용을 출력
#     print(record)
# print('-'*50)

# # 2. dept테이블에 2개의 레코드를 삽입 후 승인
# cursor.execute("insert into dept values(50, 'DEVELOPER','LA')")
# cursor.execute("insert into dept values(60, 'DEVELOPER','ATL')")
# cursor.execute('commit') # sqldeveloper에 커밋
# cursor.execute("select * from dept")
# out_data2 = cursor.fetchall()
# for record in out_data2:
#     print(record)
# print('-'*50)
    
# # 3. dept 테이블에서 dname이 "DEVELOPER"인 레코드 삭제 후 승인
# cursor.execute("delete from dept where dname = 'DEVELOPER'")
# cursor.execute("commit")
# cursor.execute("select * from dept")
# out_data2 = cursor.fetchall()
# for record in out_data2:
#     print(record)
# print('-'*50)

# # 4. emp 테이블과 dept 테이블을 inner join 수행
# cursor.execute("select e.empno, e.ename, e.mgr, d.deptno, d.dname from emp e, dept d where e.deptno = d.deptno")
# out_data = cursor.fetchall()
# for record in out_data:
#     print(record)
# print('-'*50)

# # 5. dept테이블의 구조와 내용을 이용하여 dept_ddl 테이블을 생성하시오. (단, create와 select를 활용하시오.)
# cursor.execute("create table dept_ddl as select * from dept")
# cursor.execute("select * from dept_ddl")
# out_data = cursor.fetchall()
# for record in out_data:
#     print(record)
# print('-'*50)

# con.close() # 데이터베이스 연결 해제