SELECT Host,User,plugin,authentication_string FROM mysql.user
;

CREATE USER 'root'@'%' identified by '1234'
;

GRANT ALL PRIVILEGES ON *.* to 'root'@'%'
;

-- test1계정에 테이블 생성 권한 부여
GRANT CREATE ANY TABLE TO test1
;

flush privileges
;



