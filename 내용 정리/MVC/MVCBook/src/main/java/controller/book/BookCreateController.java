package controller.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.SubController;
import domain.DTO.BookDTO;
import domain.service.BookServiceImpl;

public class BookCreateController implements SubController {
	HttpServletRequest req;
	HttpServletResponse resp;

	private BookServiceImpl bookService;

	public BookCreateController() throws Exception {
		bookService = BookServiceImpl.getInstance();
//		throw new Exception("adf");
	}

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
		try {
			String uri = req.getMethod();
			if (uri.equals("GET")) {
				req.getRequestDispatcher("/WEB-INF/view/book/create.jsp").forward(req, resp);
				return;
			}

			// 파라미터
			String bookCode = req.getParameter("bookCode");
			String bookName = req.getParameter("bookName");
			String publisher = req.getParameter("publisher");
			String isbn = req.getParameter("isbn");

			BookDTO bookdto = new BookDTO(bookCode, bookName, publisher, isbn);
			// 유효성
			if (!isValid(bookdto)) {
				req.getRequestDispatcher("/WEB-INF/view/book/create.jsp").forward(req, resp);
				return;
			}
			// 서비스
			boolean isadded = bookService.bookRegistration(bookdto);
						
			// 뷰
			if(isadded) {
				resp.sendRedirect(req.getContextPath()+"/book/list");
			} else {
				req.getRequestDispatcher("/WEB-INF/view/book/create.jsp").forward(req, resp);
			}
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
