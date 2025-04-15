package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.user.UserCreateController;
import controller.user.UserLoginController;
import controller.user.UserLogoutController;

@WebServlet("/")
public class FrontController extends HttpServlet {
	// 서브컨트롤러 저장 자료구조("/endPoint":서브컨트롤러객체)
	private Map<String, SubController> map = new HashMap();

	@Override
	public void init(ServletConfig config) throws ServletException {
		// 인증(/user/*) - 회원CRUD, 로그인, 로그아웃
		try {
			map.put("/", new HomeController());
			map.put("/index.do", new HomeController());
			map.put("/user/create", new UserCreateController());
			map.put("/user/login", new UserLoginController());
			map.put("/user/logout", new UserLogoutController());
		} catch (Exception e) {
			e.printStackTrace();
//			throw new ServletException("서브컨트롤러 동작오류");
		}
		// 도서(/book/*)
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
		System.out.println("front-controller : service");
		String endpoint = req.getServletPath();
		System.out.println("front-controller endpoint : " + endpoint);
		SubController controller =  map.get(endpoint);
		controller.execute(req, resp);
		} catch(Exception e) {
			e.printStackTrace();
			exceptionHandler(e, req);
			req.getRequestDispatcher("/WEB-INF/view/globalError.jsp").forward(req, resp);
		}
		
	}

	public void exceptionHandler(Exception e,HttpServletRequest req) {
		req.setAttribute("status", false);
		req.setAttribute("message", e.getMessage());
		req.setAttribute("exception", e);
	}

}
