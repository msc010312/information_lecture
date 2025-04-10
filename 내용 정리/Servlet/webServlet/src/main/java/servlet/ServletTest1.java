package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/TEST_01") // 서블릿 주소 설정
public class ServletTest1 extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		// Servlet 초기화
		System.out.println("init() invoke");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		//service() 메소드를 호출해서 Servlet이 브라우저의 요청을 처리
		System.out.println("service() invoke");
	}

	@Override
	public void destroy() {
		// destroy() 메소드를 호출하여 Servlet을 제거
		System.out.println("destroy() invoke");
	}
}
