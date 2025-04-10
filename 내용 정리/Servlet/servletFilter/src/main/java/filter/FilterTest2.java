package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter("/main.do")
public class FilterTest2 implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// Request 전 코드
		System.out.println("Main Fliter TEST2 START");
		chain.doFilter(request, response);
		// Response 후 코드
		System.out.println("Main Fliter TEST2 END");
	}
	
}
