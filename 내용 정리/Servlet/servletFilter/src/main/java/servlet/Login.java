package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Utils.OracleDBUtils;
import dto.UserDTO;

//@WebServlet("/login.do")
public class Login extends HttpServlet{

	//GET - 	/login.do - /WEB-INF/user/login.jsp 연결
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 파라미터 받기
		String id = req.getParameter("id");
		String pw = req.getParameter("password");
		
		try {
			UserDTO user = OracleDBUtils.getInstance().selectUser(id);
			if(user!= null && user.getPassword().equals(pw)) {
				HttpSession session = req.getSession();
				session.setAttribute("id", id);
				resp.sendRedirect(req.getContextPath() + "/main.do");
			}
			else {
				req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	//POST - 	/login.do - 회원가입처리(username,password 받아 DBUtils를 이용한 DB INSERT)
	//테이블 : tbl_user
	//성공시 : /main.do 로 리다이렉트
	//실패시 : /login.do로 포워딩
	
}
