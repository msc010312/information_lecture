# MVC
+ Model +  View + Controller의 구조로 이루어진 패턴(동작 방식)

![Image](https://github.com/user-attachments/assets/b07235f7-638a-4dbc-ace5-256a7a952b2b)

> Model
+ 데이터와 비즈니스 로직을 관리/처리
+ 사용자의 요청에 대한 업무를 처리
+ DAO(Data Access Object) 등의 Java class
  
> View
+ 사용자가 보게될 결과 화면을 담당 (레이아웃, 화면 처리 등)
+ HTML, JSP

> Controller
+ 사용자의 입력 처리와 흐름을 제어하고, 사용자에게 받은 명령을 model이나 view로 라우팅
+ 사용자로부터의 입력에 대한 응답으로 모델/뷰를 업데이트하는 로직을 포함
+ Servlet
