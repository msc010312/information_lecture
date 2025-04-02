# JSP 내용정리

> JSP개요
+  Java를 기반으로 하는 서버 측 웹 프로그래밍 언어
+ 스크립트 언어로 자바의 기능을 그대로 사용할 수 있음 
+ HTML 코드 안에 Java 코드가 있어서 HTML 코드를 작성하기 쉬움
+ Spring, @MVC 등 다양한 프레임워크와 결합하여 개발이 가능함

> Jsp의 코드 구성 요소

|구분|문법형태|설명|
|----|--------|----|
|지시자|`<%@ ~ %>`|JSP 페이지 전체에 적용되는 설정(page,include,taglib)|
|표현식|`<%= ~ %>`|자바 표현식을 실행하고 결과를 HTML로 출력|
|스크립틀릿|`<% ~ %>`|일반적인 자바코드를 작성하는 영역|
|선언부|`<%! ~ %>`|맴버변수나 메서드를 선언하는 영역(JSP전체에서 사용가능)|

> EL(Expression Language)표현식
+ JSP 페이지에서 Java 코드를 직접 작성하지 않고도 서버 측 데이터를 HTML로 쉽게 출력할 수 있게 도와주는 문법
```
${} // 기본형태(보간법과 유사함에 주의)
${param.expression} //html에서 form으로 보낸값을 받는 형태
```

> 내장객체
+ request : 클라이언트의 요청 정보를 담고 있는 객체
+ response : 클라이언트에게 응답을 받는 객체

> 지시자의 종류

|지시자 종류|형식|설명|
|---|---|---|
|page|`<%@ page 속성 = "값" %>`|JSP 페이지의 전역 속성 설정
|include|`<%@ include file = "파일명" %>|정적인 파일 포함(컴파일시)
|taglib|`<%@ taglib prefix = "접두어" uri="태그라이브러리URI" %>`|커스텀 태그 사용을 위한 태그 라이브러리 선언

+ page
  + import : 자바의 클래스를 연결해줌
  + errorpage : 에러페이지로 이동시킴
  + isErropage : 해당페이지를 에러페이지로 선언
+ include
  + 공통레이아웃을 분할시켜서 어느 한 부분에 넣을때 사용

  ```
  <div class="wrapper>
  <%@ include file = "header.jsp" %>
  </div>
  ```
+ taglib
  + 커스텀 태그 라이브러리를 사용할때 필요함, JSTL을 사용 할 때 자주 등장

  ```
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  ```
> Forward,Redirect
+ 클라이언트의 요청을 다른 리소스로 전달할때 사용하는 방식

## Forward
+ Request내용은 유지한채 또 다른 Page경로로 이동
+ 클라이언트의 URL경로는 최초요청시의 URL로 유지가 됨
+ Request객체의 내용은 최초요청내용이 유지됨(Forward 되는 동안만)

```
request.getRequestDispatcher("./03Page.jsp").forward(request, response);
```

## Redirect
+ 서버가 클라이언트에게 새로운 요청 URL 경로를 전달
+ 클라이언트는 서버가 제시간 URL 경로로 새롭게 페이지요청
+ Request객체와 Response객체는 Redirect 횟수만큼 새로운 값으로 대체

```
response.sendRedirect("03Page.jsp?hobby="+URLEncoder.encode("등산","UTF-8")); // ?부턴 파라미터값을 직접 전달하기 위해 사용했음
 ```

