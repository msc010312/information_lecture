package controller.book;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.SubController;
import domain.DTO.BookDTO;
import domain.service.BookServiceImpl;

public class BookReadController implements SubController{
	HttpServletRequest req;
	HttpServletResponse resp;

	private BookServiceImpl bookService;

	public BookReadController() throws Exception {
		bookService = BookServiceImpl.getInstance();
//		throw new Exception("adf");
	}

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
		try {
			// 파라미터
			String bookCode = req.getParameter("bookCode");
			String pageno = req.getParameter("pageno");
			
			System.out.println("bookcode : " + bookCode);
			System.out.println("pageno : " + pageno);

			// 유효성
			if(!isValid(bookCode)) {
//				req.setAttribute("message", "유효성체크오류");
				resp.sendRedirect(req.getContextPath()+"/book/list");
			}
			
			// 서비스
			Map<String,Object> serviceResponse = bookService.getBook(bookCode);
			
			Boolean status = (Boolean)serviceResponse.get("status");
			if(status) {
				req.setAttribute("bookDto", serviceResponse.get("bookDto"));
			}
			req.setAttribute("pageno", pageno);
			// 뷰
			req.getRequestDispatcher("/WEB-INF/view/book/read.jsp").forward(req, resp);
		} catch (Exception e) {
			exceptionHandler(e);
			try {
				req.getRequestDispatcher("/WEB-INF/view/book/error.jsp").forward(req, resp);
			} catch(Exception e2) {}
		}
	}
	private boolean isValid(String bookCode) {
		if (bookCode.isEmpty()) {
			req.setAttribute("bookCode", "코드 유효성 오류");
		}
		return true;
	}
	public void exceptionHandler(Exception e) {
		req.setAttribute("status", false);
		req.setAttribute("message", e.getMessage());
		req.setAttribute("exception", e);
	}
}
