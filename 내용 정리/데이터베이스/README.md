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

> select 구문
+ select * from '테이블명' where '칼럼명' = '값'; : where / 조건생성
+ select * from '테이블명' where '칼럼명' = '값' and '칼럼명' = '값' : and 연산자
+ select * from '테이블명' where '칼럼명' = '값' or '칼럼명' = '값' : or 연산자
+ select * from '테이블명' where '칼럼명' IN('값','값'); : IN / 그룹생성
+ select * from '테이블명' where '칼럼명' like '값%'; : like / % : 모든문자,길이제한X
+ select * from '테이블명' where '칼럼명' like '값__'; : like / _ : 모든문자, _만큼의 길이
+ select * from '테이블명' where '칼럼명' IS NULL; : NULL값 체크
+ select * from '테이블명' where '칼럼명' IS NOT NULL; : NULL이 아닌 값 체크
+ select DISTINCT '칼럼명' from '테이블명'; : DISTINCT / 중복열 제거
+ select '칼럼명' as '별명' from '테이블명'; : ALIAS / 별명부여

> GROUP BY
+ GROUP BY 절은 데이터를 그룹화하여 집계 함수(SUM, AVG, COUNT, MAX, MIN 등)와 함께 사용함
```
select '칼럼명' ,sum('칼럼명'+'칼럼명') from '테이블명' group by '칼럼명';
```

> ORDER BY
+ ORDER BY 절은 그룹화된 데이터를 정렬할때 사용함
```
select birthyear, COUNT(*) as 인원수 from usertbl GROUP BY birthyear ORDER BY birthyear; -- 내림차순
select birthyear, COUNT(*) as 인원수 from usertbl GROUP BY birthyear ORDER BY birthyear desc; -- 오름차순
select birthyear,height,COUNT(*) as 인원수 from usertbl GROUP BY birthyear, height ORDER BY height asc, birthyear desc; -- 내림차순,오름차순
```

> HAVING
+ HAVING 절은 그룹화된 데이터에 조건을 걸 때 사용함
+ where 절과의 차이점은 그룹화의 여부임
```
select '칼럼명', ,sum('칼럼명'+'칼럼명') from '테이블명' group by '칼럼명' having sum('칼럼명'+'칼럼명')>=1000;
```

> 단일행 함수 : 행별로 하나의 결과를 반환
+ 문자형 함수
  + LOWER, UPPER, INITCAP : 대소문자 변환
  + LENGTH, LENGTHB : 문자열 길이 반환
  + SUBSTR : 문자열 일부 추출
  + INSTR : 특정 문자 위치 찾기
  + LPAD, RPAD : 문자열 채우기
  + TRIM, LTRIM, RTRIM : 공백 제거
  + REPLACE : 문자열 치환
  + CONCAT : 문자열 연결
+ 숫자형 함수
  + ROUND : 반올림
  + TRUNC : 절삭
  + CEIL, FLOOR : 올림, 내림
  + MOD : 나머지 구하기
  + ABS : 절대값
  + SIGN : 부호 확인
  + POWER : 제곱
  + SQRT : 제곱근
+ 날짜형 함수
  + SYSDATE, CURRENT_DATE : 현재 날짜
  + ADD_MONTHS : 월 더하기
  + MONTHS_BETWEEN : 월 차이 계산
  + NEXT_DAY : 다음 요일 날짜
  + LAST_DAY : 월의 마지막 날짜
  + EXTRACT : 날짜 요소 추출
+ 변환형 함수
  + TO_CHAR  : 숫자 또는 날짜를 문자로 변환
  + TO_NUMBER  : 문자를 숫자로 변환
  + TO_DATE  : 문자를 날짜로 변환
+ NULL 관련 함수
  + NVL : NULL 값을 다른 값으로 대체
  + NVL2 : NULL 여부에 따라 값 반환
  + NULLIF : 두 표현식이 같으면 NULL 반환
  + COALESCE : 최초의 NULL이 아닌 값 반환
+ 조건형 함수
  + DECODE: 조건에 따른 값 선택 (Oracle)
  + CASE: 조건에 따른 값 선택 (표준 SQL)
 
> join
+ 두개이상의 테이블을 결합하여 데이터를 출력하는 것

> inner join
+ 테이블간에 조건을 만족하는 데이터만 출력
  ```
  
  -- usertbl과 buytbl중 prodName이라는 컬럼의 밸류값이 "책"인 컬럼만 출력
  select * from usertbl u join buytbl b on u.userid = b.userid where b.prodName='책';
  
  ```
> left /right outer join
+ 테이블간에 왼쪽 혹은 오른쪽의 데이터중 조건에 만족하지 않는 데이터를 출력
  ```
  -- 왼쪽 테이블인 studenttbl의 데이터가 없는 경우도 출력
  select * from studenttbl s left outer join examtbl e on s.studentid = e.studentid;

  -- 오른쪽 테이블인 examtbl의 데이터가 없는 경우도 출력
  select * from studenttbl s right outer join examtbl e on s.studentid = e.studentid;
  
  ```
> full outer join
+ 테이블간에 조건을 만족하지 않는 데이터를 출력
  ```
  
  -- studenttbl과 examtbl중 데이터가 없는 컬럼을 출력
  select * from studenttbl s full outer join examtbl e on s.studentid = e.studentid;
  
  ```
# 인증 및 권한부여

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

# ER다이어그램 연습

> **도서대여서비스 ER다이어그램**
![Image](https://github.com/user-attachments/assets/1f9597a0-1392-43b5-ac62-f1871a16b6ef)

> **학교 홈페이지 ER다이어그램**
![Image](https://github.com/user-attachments/assets/b6911845-67d7-41b7-b6d4-60596cc4a53b)
