# MVC
+ Model +  View + Controller의 구조로 이루어진 패턴(동작 방식)

![Image](https://github.com/user-attachments/assets/b07235f7-638a-4dbc-ace5-256a7a952b2b)

## Model
+ 데이터와 비즈니스 로직을 관리/처리
+ 사용자의 요청에 대한 업무를 처리
+ DAO(Data Access Object) 등의 Java class
  
## View
+ 사용자가 보게될 결과 화면을 담당 (레이아웃, 화면 처리 등)
+ HTML, JSP

## Controller
+ 사용자의 입력 처리와 흐름을 제어하고, 사용자에게 받은 명령을 model이나 view로 라우팅
+ 사용자로부터의 입력에 대한 응답으로 모델/뷰를 업데이트하는 로직을 포함
+ Servlet

## 동작 방식
1. 사용자의 action들은 controller가 감지함
2. Controller는 사용자의 action을 확인하고 model을 업데이트함
3. Controller는 model을 나타내줄 view를 선택함
4. View는 model을 이용하여 화면은 나타냄


# Servlet,jsp에서의 MVC

## 구성
+ Model : Biz, DAO
+ View : JSP
+ Controller : Servlet

## 동작방식
1.JSP : 사용자에게 화면을 보여준다.
2.JSP ↔ Controller : DTO로 데이터가 전달된다.
3.Controller : 요청의 유효성을 검증하고, 전체 흐름을 제어한다.
4.Contorller ↔ Biz : DTO로 데이터가 전달된다.
5. Biz
 + DB 관련 로직을 제외한 비즈니스 로직을 구현한다.
 + Connection을 생성/반납하고 commit, rollback 등 transcation을 관리한다.
 + 상황에 적합한 DAO을 호출함으로써 transaction 단위로 connection을 관리할 수 있다.
 + Biz ↔ DAO : Entity로 데이터가 전달된다.
6. DAO
 + DB 관리 로직을 구현한다.
 + 테이블의 CRUD 기능을 제공한다.
 + 보통 1개의 테이블 당 1개의 DAO가 존재한다.
