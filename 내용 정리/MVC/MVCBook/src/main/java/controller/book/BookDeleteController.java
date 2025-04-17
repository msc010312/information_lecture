package controller.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.SubController;
import domain.DTO.BookDTO;
import domain.service.BookServiceImpl;

public class BookDeleteController implements SubController {
	HttpServletRequest req;
	HttpServletResponse resp;

	private BookServiceImpl bookService;

	public BookDeleteController() throws Exception {
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
			String pageno = req.getParameter("pageno") != null ? req.getParameter("pageno") : "1";

			// 유효성
			if (!isValid(bookCode)) {
				resp.sendRedirect(req.getContextPath()+"/book/read?bookCode="+bookCode);
			}

			// 서비스
			boolean isDel = bookService.removeBook(bookCode);

			resp.sendRedirect(req.getContextPath()+"/book/list?pageno"+pageno);
		} catch (Exception e) {
			exceptionHandler(e);
			try {
				req.getRequestDispatcher("/WEB-INF/view/book/error.jsp").forward(req, resp);
			} catch (Exception e2) {
			}
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
