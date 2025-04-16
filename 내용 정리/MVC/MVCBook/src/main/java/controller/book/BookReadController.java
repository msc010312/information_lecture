package controller.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.SubController;
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
			String uri = req.getMethod();
			if (uri.equals("GET")) {
				req.getRequestDispatcher("/WEB-INF/view/book/read.jsp").forward(req, resp);
				return;
			}
		} catch (Exception e) {
			exceptionHandler(e);
			try {
				req.getRequestDispatcher("/WEB-INF/view/book/errro.jsp").forward(req, resp);
			} catch(Exception e2) {}
		}
	}

	public void exceptionHandler(Exception e) {
		req.setAttribute("status", false);
		req.setAttribute("message", e.getMessage());
		req.setAttribute("exception", e);
	}
}
