## Servlet
+ 클라이언트의 요청을 처리하고, 그 결과를 반환하는 Servlet 클래스의 구현 규칙을 지킨 자바 웹 프로그래밍 기술

## Servlet 생명주기
![Image](https://github.com/user-attachments/assets/8b498476-199b-4201-ab4c-fde04f0b3a99)

> init()
+ 서블릿을 처음 메모리에 올릴때 실행되어, 서블릿을 초기화하며 처음에 한번만 실행됨

> service()
+ 요청/응답(request/response)을 처리하며 요청이 GET인지 POST구분하여 doGet(), doPost()메소드로 분기됨

> destroy()
+ 서블릿 종료요청이 있을때 destroy() 메소드가 실행 init()과 마찬가지로 한번만 실행됨

```
@WebServlet("/TEST_01") // 서블릿 주소 설정
public class ServletTest1 extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		// Servlet 초기화
		System.out.println("init() invoke");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		//service() Servlet이 브라우저의 요청을 처리
		System.out.println("service() invoke");
	}

	@Override
	public void destroy() {
		// destroy() Servlet을 제거
		System.out.println("destroy() invoke");
	}
}
```

## doGet, doPost

![Image](https://github.com/user-attachments/assets/1ecf47aa-0eff-4962-93f2-2fec64e3fec2)
![Image](https://github.com/user-attachments/assets/0ac8cb77-10d5-4b55-9986-38c081b37df8)

```
public class ServletTest4 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("GET /join.do");
		req.getRequestDispatcher("/WEB-INF/join.jsp").forward(req, resp); // forward로 경로 연결
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { // post로 날렸던 값 받기
		// 파라미터 받기
		String un = req.getParameter("username");
		String pw = req.getParameter("password");
		
		// 입력값 검증
		
		
		// 세션에 값 저장
		HttpSession session = req.getSession();
		session.setAttribute("username", un);
		session.setAttribute("password", pw);
		
		// redirect (login.do로 전송)
		resp.sendRedirect(req.getContextPath() + "/login.do");
	}
}
```

## Servlet mapping
+ \<servlet> : 브라우저에서 요청하는 매핑 이름에 대해 실제로 실행하는 서블릿 클래스를 설정하는 태그
+ \<sevlet-name> : \<servlet>과 \<servlet-mapping>을 연결 시켜주는 태그
+ \<servlet-class> : 브라우저에 요청하는 매핑 이름에 대해 실제로 기능을 수행하는 서블릿 클래스
+ \<servlet-mapping> : 브라우저에서 요청하는 논리적인 서블릿을 설정
+ \<url-pattern> : 클라이언트가 요청하는 논리적인 서블릿 이름

```
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns="http://xmlns.jcp.org/xml/ns/javaee"
	xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
	version="4.0">
	<display-name>servletFilter</display-name>
	<welcome-file-list> // 페이지가 시작될때 초기값 설정
		<welcome-file>index.html</welcome-file>
		<welcome-file>index.htm</welcome-file>
		<welcome-file>index.jsp</welcome-file>
		<welcome-file>default.html</welcome-file>
		<welcome-file>default.htm</welcome-file>
		<welcome-file>default.jsp</welcome-file>
		<welcome-file>index.do</welcome-file>
	</welcome-file-list>

	<!-- 서블릿 -->
	<servlet>
		<servlet-name>Home</servlet-name> // 이름설정
		<servlet-class>servlet.Home</servlet-class> // 매핑되는 class명
	</servlet>
	<servlet-mapping>
		<servlet-name>Home</servlet-name> // 이름연결
		<url-pattern>/index.do</url-pattern> // url 이름 설정
		<url-pattern>/main.do</url-pattern>
	</servlet-mapping>
```
