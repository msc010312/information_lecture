package controller.book;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.SubController;
import domain.DTO.BookDTO;
import domain.DTO.Criteria;
import domain.DTO.PageDto;
import domain.service.BookServiceImpl;

public class BookListController implements SubController {

	HttpServletRequest req;
	HttpServletResponse resp;

	private BookServiceImpl bookService;

	public BookListController() throws Exception {
		bookService = BookServiceImpl.getInstance();
//		throw new Exception("adf");
	}

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
		try {
			
			// 파라미터
			String pageno = req.getParameter("pageno");
			String amount = req.getParameter("amount");
			String type = req.getParameter("type");
			String keyword = req.getParameter("keyword");
			
			Criteria criteria = null;
			if(pageno==null) {
				criteria = new Criteria();
			} else {
				
			}
			
			// 서비스
			Map<String,Object> serviceRes = bookService.getAllBooks(criteria);
			boolean status = (boolean)serviceRes.get("status");
			PageDto pageDto = (PageDto)serviceRes.get("pageDto");

			// 뷰
			if(status) {
				List<BookDTO> list = (List<BookDTO>)serviceRes.get("list");
				req.setAttribute("list", list);
				req.setAttribute("pageDto", pageDto);
			} else {
				;
			}
			req.getRequestDispatcher("/WEB-INF/view/book/list.jsp").forward(req, resp);
		} catch (Exception e) {
			exceptionHandler(e);
		}
	}

	public void exceptionHandler(Exception e) {
		req.setAttribute("status", false);
		req.setAttribute("message", e.getMessage());
		req.setAttribute("exception", e);
	}

}
