package controller.book;

import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import controller.SubController;
import domain.DTO.ReplyDTO;
import domain.service.BookServiceImpl;

public class BookReplyListController implements SubController{
	HttpServletRequest req;
	HttpServletResponse resp;

	private BookServiceImpl bookService;

	public BookReplyListController() throws Exception {
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
			
			if(!isValid(bookCode)) {
				
			}
			
			// 서비스
			List<ReplyDTO> serviceRes = bookService.getAllReply(bookCode);
			long cnt = bookService.bookReplyCount(bookCode);

			Map<String,Object> respEntity = new LinkedHashMap();
			respEntity.put("replyCnt", cnt);
			respEntity.put("replyList", serviceRes);
			
			// 뷰(data 전달 json)
			resp.setContentType("application/json");
			ObjectMapper objectMapper = new ObjectMapper();
			
			objectMapper.registerModule(new JavaTimeModule());
			objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
			String JsonData = objectMapper.writeValueAsString(respEntity);
			
			PrintWriter out = resp.getWriter();
			out.write(JsonData);
			
		} catch (Exception e) {
			exceptionHandler(e);
		}
	}

	private boolean isValid(String bookCode) {
		return true;
	}

	public void exceptionHandler(Exception e) {
		req.setAttribute("status", false);
		req.setAttribute("message", e.getMessage());
		req.setAttribute("exception", e);
	}
}
