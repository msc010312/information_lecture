package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/join.do")
public class ServletTest4 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("GET /join.do");
		req.getRequestDispatcher("/WEB-INF/join.jsp").forward(req, resp); // forward로 경로 받기
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
