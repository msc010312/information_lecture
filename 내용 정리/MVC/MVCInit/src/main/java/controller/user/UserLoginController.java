package controller.user;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.SubController;
import domain.DTO.UserDTO;
import domain.service.UserServiceImpl;

public class UserLoginController implements SubController{
	HttpServletRequest req;
	HttpServletResponse resp;
	
	private UserServiceImpl userService;
	
	public UserLoginController() throws Exception {
		userService = UserServiceImpl.getInstance();
//		throw new Exception("adf");
	}
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
		try {
		String uri = req.getMethod();
		if(uri.equals("GET")) {
			req.getRequestDispatcher("/WEB-INF/view/user/login.jsp").forward(req, resp);
			return;
		}

		String username = req.getParameter("username");
		String pw = req.getParameter("password");
		String role = "ROLE_USER";
		
		UserDTO ud = new UserDTO(username,pw,role);
		boolean isOK = isValid(ud);
		
		if(!isOK) {
			req.getRequestDispatcher("/WEB-INF/view/user/create.jsp").forward(req, resp);
			return;
		}
		
		boolean isLogin = false;
		Map<String,Object> serviceResponse = userService.login(ud, req.getSession());
		isLogin = (boolean) serviceResponse.get("isLogin");
		String message = (String) serviceResponse.get("message");
		
		PrintWriter out = resp.getWriter();
		if(isLogin) {
			resp.sendRedirect(req.getContextPath()+"/index.do?message="+message);
		} else {
			req.getRequestDispatcher("/WEB-INF/view/user/login.jsp").forward(req, resp);
		}
		
		} catch(Exception e) {
			exceptionHandler(e);
			try {
			req.getRequestDispatcher("/WEB-INF/view/user/error.jsp").forward(req, resp);
			} catch(Exception e2) {}
		}
	}

	private boolean isValid(UserDTO ud) {
		if (ud.getUsername() == null || ud.getUsername().length() <= 4) {
			req.setAttribute("username_err", "userid의 길이는 최소 5자이상이어야합니다");
			System.out.println("[INVALID] userid의 길이는 최소 5자이상이어야합니다");
			return false;
		}
		if (ud.getUsername().matches("^[0-9].*")) {
			System.out.println("[INVALID] userid의 첫문자로 숫자가 들어올수 없습니다");
			req.setAttribute("username_err", "userid의 userid의 첫문자로 숫자가 들어올수 없습니다");
			return false;
		}

		return true;
	}
	
	public void exceptionHandler(Exception e) {
		req.setAttribute("status", false);
		req.setAttribute("message", e.getMessage());
		req.setAttribute("exception", e);
	}

}
