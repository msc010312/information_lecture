package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.book.BookCreateController;
import controller.book.BookDeleteController;
import controller.book.BookListController;
import controller.book.BookReadController;
import controller.book.BookReplyCreateController;
import controller.book.BookReplyListController;
import controller.book.BookUpdateController;
import controller.user.AdminMainController;
import controller.user.ManagerMainController;
import controller.user.UserCreateController;
import controller.user.UserLoginController;
import controller.user.UserLogoutController;
import controller.user.UserMainController;

//@WebServlet("/")
public class FrontController extends HttpServlet {
	// 서브컨트롤러 저장 자료구조("/endPoint":서브컨트롤러객체)
	private Map<String, SubController> map = new HashMap();

	@Override
	public void init(ServletConfig config) throws ServletException {
		// 인증(/user/*) - 회원CRUD, 로그인, 로그아웃
		try {
			// 기본
			map.put("/", new HomeController());
			map.put("/index.do", new HomeController());
			
			// role별 메인
			map.put("/user/user", new UserMainController());
			map.put("/user/manager", new ManagerMainController());
			map.put("/user/admin", new AdminMainController());
			
			// 유저 로그인
			map.put("/user/create", new UserCreateController());
			map.put("/user/login", new UserLoginController());
			map.put("/user/logout", new UserLogoutController());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException("서브컨트롤러 동작오류");
		}
		// 도서(/book/*)
		try {
		map.put("/book/list", new BookListController());
		map.put("/book/create", new BookCreateController());
		map.put("/book/read", new BookReadController());
		map.put("/book/update", new BookUpdateController());
		map.put("/book/delete", new BookDeleteController());
		
		// 댓글
		map.put("/book/reply/create", new BookReplyCreateController());
		map.put("/book/reply/list", new BookReplyListController());
		
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException("서브컨트롤러 동작오류");
		}
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
