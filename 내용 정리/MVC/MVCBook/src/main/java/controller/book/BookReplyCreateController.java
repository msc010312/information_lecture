package controller.book;

import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialException;

import controller.SubController;
import domain.DTO.BookDTO;
import domain.DTO.ReplyDTO;
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
			String bookCode = req.getParameter("bookCode");
			String username = null;
			String content = req.getParameter("content");
			LocalDateTime createAt = LocalDateTime.now();
			
			HttpSession session = req.getSession();
			username = (String) session.getAttribute("username");
			if(username == null) {
				throw new SerialException("로그인이 필요합니다");
			}
			ReplyDTO replyDto = new ReplyDTO(-1,bookCode,username,content,createAt);
			// 유효성
			if(!isValid(replyDto)) {
				
			}
			// 서비스
			boolean isAdded = bookService.bookReplyAdd(replyDto);
						
			// 뷰(json 데이터 전달)
			if(isAdded) {
				PrintWriter out = resp.getWriter();
				out.println("{\"message\":\"success\"}");
			} else {
				PrintWriter out = resp.getWriter();
				out.println("{\"message\":\"fail\"}");
			}
			
			
		} catch (Exception e) {
			exceptionHandler(e);
			try {
				req.getRequestDispatcher("/WEB-INF/view/book/error.jsp").forward(req, resp);
			} catch (Exception e2) {
			}
		}
	}

	private boolean isValid(ReplyDTO reDto) {
		return true;
	}

	public void exceptionHandler(Exception e) {
		req.setAttribute("status", false);
		req.setAttribute("message", e.getMessage());
		req.setAttribute("exception", e);
	}
}
