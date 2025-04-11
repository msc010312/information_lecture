package filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import type.Role;

public class PermissionFilter implements Filter{

	private Map<String,Role> pageGradeMap = new HashMap();
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		pageGradeMap.put("/admin.do", Role.ROLE_ADMIN);
		pageGradeMap.put("/manager.do", Role.ROLE_MANAGER);
		pageGradeMap.put("/user.do", Role.ROLE_USER);
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		// 전
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		
		HttpSession session = request.getSession();
		String myRole = (String)session.getAttribute("role");
		if(myRole==null) {
			response.sendRedirect(request.getContextPath()+"/login.do?msg=not authenticated");
			return;
		}
		
		Role my = null;
		switch(myRole) {
		case "ROLE_ADMIN" :
			my = Role.ROLE_ADMIN;
			break;
		case "ROLE_MANAGER" :
			my = Role.ROLE_MANAGER;
			break;
		case "ROLE_USER":
			my = Role.ROLE_USER;
			break;
		default:
			my = Role.ROLE_ANONYMOUS;
			break;
		}
		
		String requestURI = request.getServletPath();
		Role pageRole = pageGradeMap.get(requestURI);
		
		System.out.printf("url : %s, myrole : %d, pagerole : %d\n",requestURI,my.ordinal(),pageRole.ordinal());
		
		
		if(my.ordinal() < pageRole.ordinal()) {
			throw new ServletException("해당권한으로는 접근이 불가능한 페이지 입니다");
		}
		
		
		chain.doFilter(req, resp);
		// 후
	}

}
