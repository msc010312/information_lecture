# JSP 내용정리

## JSP개요
+  Java를 기반으로 하는 서버 측 웹 프로그래밍 언어
+ 스크립트 언어로 자바의 기능을 그대로 사용할 수 있음 
+ HTML 코드 안에 Java 코드가 있어서 HTML 코드를 작성하기 쉬움
+ Spring, @MVC 등 다양한 프레임워크와 결합하여 개발이 가능함

## Jsp의 코드 구성 요소

|구분|문법형태|설명|
|----|--------|----|
|지시자|`<%@ ~ %>`|JSP 페이지 전체에 적용되는 설정(page,include,taglib)|
|표현식|`<%= ~ %>`|자바 표현식을 실행하고 결과를 HTML로 출력|
|스크립틀릿|`<% ~ %>`|일반적인 자바코드를 작성하는 영역|
|선언부|`<%! ~ %>`|맴버변수나 메서드를 선언하는 영역(JSP전체에서 사용가능)|

## EL(Expression Language)표현식
+ JSP 페이지에서 Java 코드를 직접 작성하지 않고도 서버 측 데이터를 HTML로 쉽게 출력할 수 있게 도와주는 문법
+ EL표현식 사용법
```
${} // 기본형태(보간법과 유사함에 주의)

<!-- EL : param -->
<!-- request.getParameter()와 동일 -->
<div>username : ${param.userId }</div>

<!-- EL : Attribute -->
<!-- .getAttribute()와 동일 -->
<div>PageContext attr : ${pageName }</div>
<div>PageContext attr : ${pageScope.pageName }</div>
<div>request attr : ${requestName }</div>
<div>request attr : ${requestScope.requestName }</div>
<div>Session attr : ${sessionName }</div>
<div>Session attr : ${sessionScope.sessionName }</div>
<div>application attr : ${appName }</div>
<div>application attr : ${applicationScope.appName }</div>

<!-- 중복키 처리 -->
<!-- 키 값이 중복되면 좁은 범위의 키를 불러온다 -->
<div>Duplicated value : ${dup }</div>

<!-- EL : Object -->
<%
UserDto ud = new UserDto("admin","1234");
request.setAttribute("ud", ud);
%>
<div>표현식 : <%=ud.getUserid() %></div>
<div>EL :  ${ud.userid}</div>

<!-- EL : 연산자 -->
<div>표현식 : <%=1+1 %></div>
<div>EL : ${1+"1" }</div> <!-- 문자열을 자동으로 int변환 해줌 -->

<!-- Null Check -->
<div>Null : ${null }</div>
<div>empty Null : ${empty test }</div> <!-- 값이 비었으면 true 리턴 -->
<div>empty not null : ${!empty test }</div>
```

## 내장객체
+ request : 클라이언트의 요청 정보를 담고 있는 객체
+ response : 클라이언트에게 응답을 받는 객체
+ out : 페이지의 결과를 클라이언트에 전송해주는 출력 스트림객체
+ pageContext : 현재 jsp의 정보, 다른 내부객체에 접근가능하게 해주는 객체

> 내장객체의 영역
+ page : 동일한 페이지에서만 공유, 페이지를 벗어나면  소멸
+ request : 하나의 요청에 의해 호출된 페이지와 forwarding된 페이지까지 공유 새로운 페이지를 요청하면 소멸
+ session : 클라이언트가 처음 접속한 후 웹 브라우저를 닫을 때까지 공유
+ application : 한번 저장되면 웹 애플리케이션이 종료될 때까지 유지

## 지시자의 종류

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
## Forward,Redirect
+ 클라이언트의 요청을 다른 리소스로 전달할때 사용하는 방식

> Forward
+ Request내용은 유지한채 또 다른 Page경로로 이동
+ 클라이언트의 URL경로는 최초요청시의 URL로 유지가 됨
+ Request객체의 내용은 최초요청내용이 유지됨(Forward 되는 동안만)

```
request.getRequestDispatcher("./03Page.jsp").forward(request, response);
```

> Redirect
+ 서버가 클라이언트에게 새로운 요청 URL 경로를 전달
+ 클라이언트는 서버가 제시간 URL 경로로 새롭게 페이지요청
+ Request객체와 Response객체는 Redirect 횟수만큼 새로운 값으로 대체

```
response.sendRedirect("03Page.jsp?hobby="+URLEncoder.encode("등산","UTF-8")); // ?부턴 파라미터값을 직접 전달하기 위해 사용했음
 ```
> 세션
+ 사용자가 웹사이트에 접속해서 일정시간동안 상태(정보)를 서버에 저장하는 방식
+ jsp 실행 시 자동 생성 `<%@ page session="true" %>`

> 세션 사용법
```
- setSession -
session.setAttribute("key","value"); // 세션값 저장 (키-밸류형태)
session.setMaxInactiveInterval(60); // 세션의 유지시간 (0이나 음수를 주면 세션 무제한 유지)

- getSession -
session.getAttrubute("key"); // 세션값 리턴
```

> 쿠키
+ 사용자의 웹브라우저에 저장이 됨
+ Key-Value쌍으로 구성되어 있는 데이터 파일
+ 도메인 당 20개의 쿠키를 가질 수 있음
+ 하나의 쿠키는 4KB(= 4096 byte)까지 저장이 가능함

> 쿠키 사용법
```
- setCookie -
Cookie cookie1 = new Cookie("key","value") // 새로운 쿠키 객체 생성
response.addCookie(cookie1) // 쿠키값 전달
cookie1.setMaxAge(60) // 쿠키의 유지시간(0으로 설정 시 즉시 만료)
cookie1.setPath("/") // 쿠키의 경로제한(상대경로를 기준으로 한다)

- getCookie -
Cookie[] cookies = request.getCookies(); // 모든 쿠키를 배열로 받아옴
${cookie.cookieName} // 키 값 하나만 받아옴
if(cookies != null) { // null체크
 for(Cookie cookie: cookies) {
  System.out.println(cookie.getName() + " : " + cookie.getValue()); // 쿠키의 이름과 밸류 확인
  }
}
```
