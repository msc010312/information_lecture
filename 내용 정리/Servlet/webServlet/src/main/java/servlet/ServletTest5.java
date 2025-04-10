package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.buf.StringUtils;

@WebServlet("/login.do")
public class ServletTest5 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("12321");
		req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 파라미터 받기
		String un = req.getParameter("username");
		String pw = req.getParameter("password");

		// 세션에 있는 값과 대조
		HttpSession session = req.getSession();
		String dbun = (String)session.getAttribute("username");
		String dbpw = (String)session.getAttribute("password");
		
		if(!un.equals(dbun)) {
			req.setAttribute("username_msg", "ID가 일치하지 않습니다");
		}
		if(!pw.equals(dbpw)) {
			req.setAttribute("password_msg", "비밀번호가 일치하지 않습니다");
		}
		if(!un.equals(dbun) || !pw.equals(dbpw)) {
			req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
			return;
		}
		
		resp.sendRedirect(req.getContextPath() + "/main.do");
	}
}
