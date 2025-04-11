package filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import type.Role;

public class LoginRedirectFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		chain.doFilter(req, resp);
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		String method = request.getMethod();
		HttpSession session = request.getSession();
		String myRole = (String) session.getAttribute("role");
		System.out.println(myRole);
		if (method.equals("POST") && myRole != null) {
			if (myRole.equals("ROLE_ADMIN")) {
				response.sendRedirect(request.getContextPath() + "/admin.do");
				return;
			}
			if (myRole.equals("ROLE_MANAGER")) {
				response.sendRedirect(request.getContextPath() + "/manager.do");
				return;
			}
			if (myRole.equals("ROLE_USER")) {
				response.sendRedirect(request.getContextPath() + "/user.do");
				return;
			}
		}
		
	}

}
