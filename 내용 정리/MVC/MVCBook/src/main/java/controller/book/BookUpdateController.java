package controller.book;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.SubController;
import domain.DTO.BookDTO;
import domain.service.BookServiceImpl;

public class BookUpdateController implements SubController {
	HttpServletRequest req;
	HttpServletResponse resp;

	private BookServiceImpl bookService;

	public BookUpdateController() throws Exception {
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
			String bookName = req.getParameter("bookName");
			String publisher = req.getParameter("publisher");
			String isbn = req.getParameter("isbn");
			
			String pageno = req.getParameter("pageno")!=null?req.getParameter("pageno"):"1";
			
			BookDTO bookDto = new BookDTO(bookCode,bookName,publisher,isbn);
			//유효성
			if(!isValid(bookDto)) {
				req.getRequestDispatcher("/WEB-INF/view/book/read.jsp?bookCode="+bookCode).forward(req, resp);
			}
			
			//서비스 
			boolean isUpdate = bookService.modifyBook(bookDto);
			
			//뷰
			resp.sendRedirect(req.getContextPath() + "/book/list?pageno="+pageno);
		} catch (Exception e) {
			exceptionHandler(e);
			try {
				req.getRequestDispatcher("/WEB-INF/view/book/error.jsp").forward(req, resp);
			} catch (Exception e2) {
			}
		}
	}
	
	private boolean isValid(BookDTO bookDto) {

		return true;
	}

	private boolean isValid(String bookCode) {
		if (true) {
			;
		}
		return true;
	}
	public void exceptionHandler(Exception e) {
		req.setAttribute("status", false);
		req.setAttribute("message", e.getMessage());
		req.setAttribute("exception", e);
	}
}
