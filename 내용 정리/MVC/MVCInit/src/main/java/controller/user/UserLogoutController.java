package controller.user;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.SubController;
import domain.DTO.UserDTO;
import domain.service.UserServiceImpl;
//FrontController -> UserLogoutController 등록 (URI : /user/logout)
// UserLogoutController
//  - 1 파라미터받기 생략 
//	- 2 session 안 속성 정보(isAuth , role , username) 꺼내오고 유효성 체크
//  - isAuth == false 라면 포워딩 /WEB-INF/login.jsp   session에 message 속성 추가 "로그인상태가 아닙니다"
// UserService
//  - logout함수 내 처리
//		- session invalid 처리 하기
//		- Map<String,Object> 로 return "isLogout",true , "message","로그아웃성공"

// UserLogoutController
//	- isLogout 정보를 확인하여 로그아웃 성공/실패 둘다  /login.do
//  - message는 session 에 저장
public class UserLogoutController implements SubController {
	HttpServletRequest req;
	HttpServletResponse resp;
	HttpSession session;

	private UserServiceImpl userService;

	public UserLogoutController() throws Exception {
		userService = UserServiceImpl.getInstance();
//		throw new Exception("adf");
	}

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
		
		try {
			session = req.getSession();
			
			Boolean sAuth = (Boolean) session.getAttribute("isAuth") != null?(Boolean) session.getAttribute("isAuth"):null;
			String sRole = (String) session.getAttribute("role");
			String sUserName = (String) session.getAttribute("username");
			
			if(sAuth==null || sAuth==false) {
				req.getRequestDispatcher("/WEB-INF/view/user/login.jsp").forward(req, resp);
				return;
			}
			
			boolean isOK = isValid(sAuth, sRole, sUserName);
			
			Map<String, Object> serviceResponse = userService.logout(req.getSession());
			Boolean isLogout = (Boolean)serviceResponse.get("isLogout");
			
			HttpSession newSession = req.getSession(true);
			if(isLogout != null && isLogout==true) {
				newSession.setAttribute("message", "로그아웃 성공");
			}else {
				newSession.setAttribute("message", "로그아웃 실패");
			}
			
			resp.sendRedirect(req.getContextPath() + "/login");

		} catch (Exception e) {
			exceptionHandler(e);
			try {
				req.getRequestDispatcher("/WEB-INF/view/user/error.jsp").forward(req, resp);
			} catch (Exception e2) {
			}
		}
	}

	private boolean isValid(Boolean sAuth, String sRole, String sUserName ) {
		if (sAuth == false || sAuth == null) {
			req.setAttribute("message", "로그인상태가 아닙니다");
			return false;
		}
		if (sRole == null) {
			return false;
		}
		if (sUserName == null) {
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
