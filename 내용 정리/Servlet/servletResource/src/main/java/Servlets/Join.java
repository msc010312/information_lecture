package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Utils.OracleDBUtils;
import dto.UserDTO;

@WebServlet("/join.do")
public class Join extends HttpServlet{

	//GET - 	/join.do - /WEB-INF/user/join.jsp 연결
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/join.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 파라미터 받기
		String id = req.getParameter("id");
		String pw = req.getParameter("password");
		
		try {
			int result = OracleDBUtils.getInstance().insertUser(new UserDTO(id,pw));
			if(result > 0) {
				resp.sendRedirect(req.getContextPath() + "/login.do");
				return;
			}
			else {
				req.getRequestDispatcher("WEB-INF/join.jsp").forward(req, resp);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	

	
	
	//POST - /join.do - 회원가입처리(username,password 받아 DBUtils를 이용한 DB INSERT)
	//테이블 : tbl_user(요청 파라미터에 맞게 적절히 생성)
	//성공시 - /login.do 로 리다이렉트
	//실패시 - /join.do 로 포워딩
	
	
}
