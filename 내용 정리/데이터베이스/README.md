# 데이터베이스 내용 정리

> DDL(Data Definition Language)
+ 데이터를 생성, 수정, 삭제하는 등의 데이터의 전체의 골격을 결정하는 역할
  + create : 데이터베이스, 테이블등을 생성
  + alter : 테이블을 수정
  + drop : 데이터베이스, 테이블을 삭제
  + truncate : 테이블을 초기화

> DML(Data Manipulation Language)
+ 정의된 데이터베이스에 입력된 레코드를 조회하거나 수정하거나 삭제하는 등의 역할을 하는 언어.
  + select : 데이터 조회
  + insert : 데이터 삽입
  + update : 데이터 수정
  + delete : 데이터 삭제

> DCL(Data Control Language)
+ 데이터베이스에 접근하거나 객체에 권한을 주는등의 역할을 하는 언어
  + grant : 특정 데이터베이스 사용자에게 특정 작업에 대한 수행 권한을 부여
  + revoke : 특정 데이터베이스 사용자에게 특정 작업에 대한 수행 권한을 박탈, 회수
  + commit : 트랜잭션의 작업을 저장
  + rollback : 트랜잭션의 작업을 취소, 원래대로 복구

`Information_schema : 메타데이터 제공,데이터베이스 정보 제공`

`Performance_schema : 시스템 성능 관련정보 제공`

`mysql : 인증정보`

`sys : Information_schema,Performance_schema의 분석을 돕기위해 만들어진 DB`


> qurry 명령어
  + show databases : 데이터베이스 확인
  + show tables : 테이블 확인
  + desc 테이블명 : 테이블 구조 확인

  + create databases 'db명'; : 데이터베이스 생성
  + create table '테이블명'(열이름,자료형,제약조건); : 테이블 생성
  + alter table '테이블명' add column '열이름' 자료형 (제약조건) : 테이블 추가 
  + alter table '테이블명' change column '기존열이름' '바꿀이름' 자료형 (제약조건) : 테이블 변경
  + alter table '테이블명' drop column '열이름' : 테이블 삭제

  + insert into '테이블명'(열1,열2...) values(값1,값2...);  : 삽입
  + update '테이블명' set '열이름'=값,'열이름'=값 where '열이름'=값;  : 수정
  + delete from '테이블명' where '열이름'=값; : 삭제
  + select * from '테이블명'; : 조회

# 인증및권한부여

**사용자 계정 확인**
-----------------------
use mysql;

show tables;

select user,host from user;

flush privileges;	// 새로고침

-----------
**로컬전용계정**
-----------
create user '유저명'@localhost identified by '비밀번호'; // 로컬접속 유저


**외부접속허용**
-----------
create user '유저명'@'%' identified by '비밀번호';	// 외부접근 허용 유저

**계정 추가**
-----------
create user '유저명'@'%' identified by '비밀번호';

**읽기**
-----------
grant select on test1.* to '유저명'@'%';

**쓰기**
-----------
grant select,insert on test1.* to '유저명'@'%';

**수정**
-----------
grant select,insert,update on test.% to '유저명'@'%';

**모든권한**
-----------
grant all privileges on test1.* to '유저명'@'%';

**권한 확인**
-----------
show grants for '유저명'@'%';
