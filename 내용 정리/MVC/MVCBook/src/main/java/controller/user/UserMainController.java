package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.SubController;

public class UserMainController implements SubController{
	HttpServletRequest req;
	HttpServletResponse resp;
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
		try {
			req.getRequestDispatcher("/WEB-INF/view/user/user.jsp").forward(req, resp);
		} catch (Exception e) {
			exceptionHandler(e);
		} 
	}
	
	public void exceptionHandler(Exception e) {
		req.setAttribute("status", false);
		req.setAttribute("message", e.getMessage());
		req.setAttribute("exception", e);
	}
}
