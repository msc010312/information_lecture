package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter("/index.do")
public class FilterTest1 implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// Request 전 코드
		System.out.println("Index Fliter TEST1 START");
		chain.doFilter(request, response);
		// Response 후 코드
		System.out.println("Index Fliter TEST1 END");
	}
	
}
