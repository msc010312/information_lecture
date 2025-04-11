package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/index.do", "/main.do"})
public class Home extends HttpServlet{

	//GET - /index.do - /WEB-INF/index.jsp 연결
	//GET - /main.do - /WEB-INF/main.jsp 연결
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getServletPath() == "/index.do") {
		req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
		}
		if(req.getServletPath() == "/main.do") {
		req.getRequestDispatcher("/WEB-INF/main.jsp").forward(req, resp);
		}
	}
	
}
