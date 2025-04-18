package controller.book;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.SubController;
import domain.DTO.BookDTO;
import domain.service.BookServiceImpl;

public class BookReplyCreateController implements SubController{
	HttpServletRequest req;
	HttpServletResponse resp;

	private BookServiceImpl bookService;

	public BookReplyCreateController() throws Exception {
		bookService = BookServiceImpl.getInstance();
//		throw new Exception("adf");
	}

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
		try {
			// 파라미터
		
			// 유효성
		
			// 서비스
			
						
			// 뷰(json 데이터 전달)
			PrintWriter out = resp.getWriter();
			out.println("{\"message\":\"success\"}");
			
		} catch (Exception e) {
			exceptionHandler(e);
			try {
				req.getRequestDispatcher("/WEB-INF/view/book/error.jsp").forward(req, resp);
			} catch (Exception e2) {
			}
		}
	}

	private boolean isValid(BookDTO bookdto) {
		if (bookdto.getBookCode().isEmpty()) {
			req.setAttribute("bookCode", "책 코드를 입력하세요");
		}
		if (bookdto.getBookName().isEmpty()) {
			req.setAttribute("bookName", "책 이름을 입력하세요");
		}
		if (bookdto.getPublisher().isEmpty()) {
			req.setAttribute("publisher", "출판사 명을 입력하세요");
		}
		if (bookdto.getIsbn().isEmpty()) {
			req.setAttribute("isbn", "분류 코드를 입력하세요");
		}
		if (bookdto.getBookCode().isEmpty() || bookdto.getBookName().isEmpty() || bookdto.getPublisher().isEmpty() || bookdto.getIsbn().isEmpty())
			return false;

		return true;
	}

	public void exceptionHandler(Exception e) {
		req.setAttribute("status", false);
		req.setAttribute("message", e.getMessage());
		req.setAttribute("exception", e);
	}
}
