package domain.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.DAO.BookDao;
import domain.DAO.BookDaoImpl;
import domain.DAO.BookReplyDaoImpl;
import domain.DTO.BookDTO;
import domain.DTO.Criteria;
import domain.DTO.PageDto;
import domain.DTO.ReplyDTO;

public class BookServiceImpl {

	//
	private BookDao bookDao;
	private BookDTO bookDto;
	private BookReplyDaoImpl bookReplyDaoImpl;

	// 싱글톤 패턴
	private static BookServiceImpl instance;

	private BookServiceImpl() throws Exception {
		bookDao = BookDaoImpl.getInstance();
		bookReplyDaoImpl = BookReplyDaoImpl.getInstance();
	}

	public static BookServiceImpl getInstance() throws Exception {
		if (instance == null)
			instance = new BookServiceImpl();
		return instance;
	}

	// TX 처리 + 비즈니스 유효성검사
	public boolean bookRegistration(BookDTO bookDto) throws Exception {

		int result = bookDao.insert(bookDto);

		return result > 0;

	}

	public Map<String, Object> getAllBooks() throws Exception {
		Map<String, Object> response = new HashMap();
		List<BookDTO> list = bookDao.selectAll();
		if (list.size() != 0) {
			response.put("status", true);
			response.put("list", list);
		} else {
			response.put("stauts", false);
		}
		return response;
	}

	public Map<String, Object> getAllBooks(Criteria criteria) throws Exception {
		Map<String, Object> response = new HashMap();
		if (criteria.getType() == null || criteria.getType().isEmpty()) {
			int offset = (criteria.getPageno() - 1) * criteria.getAmount();

			// 페이지별 표시수
			List<BookDTO> list = bookDao.selectAll(offset, criteria.getAmount());

			// pageDto
			long count = bookDao.count();
			PageDto pd = new PageDto(count, criteria);

			if (list.size() > 0) {
				response.put("status", true);
				response.put("list", list);
				response.put("pageDto", pd);
			} else {
				response.put("stauts", false);
			}
		} else {
			int offset = (criteria.getPageno() - 1) * criteria.getAmount();

			int amount = criteria.getAmount();
			String type = criteria.getType();
			String keyword = criteria.getKeyword();
			List<BookDTO> list = bookDao.selectAll(offset, amount, type, keyword);
			
			// pageDto
			long totalCount = bookDao.count(criteria);
			PageDto pd = new PageDto(totalCount, criteria);
			if (list.size() > 0) {
				response.put("status", true);
				response.put("list", list);
				response.put("pageDto", pd);
			} else {
				response.put("stauts", false);
			}
		}
		return response;
	}

	public Map<String, Object> getBook(String bookCode) throws Exception {
		Map<String, Object> response = new HashMap();

		bookDto = bookDao.select(bookCode);

		if (bookDto == null) {
			response.put("status", false);
		} else {
			response.put("status", true);
			response.put("bookDto", bookDto);
		}
		return response;
	}

	public boolean modifyBook(BookDTO bookDto) throws Exception {
		int result = bookDao.update(bookDto);
		return result > 0;
	}

	public boolean removeBook(String bookCode) throws Exception {
		int result = bookDao.delete(bookCode);
		return result > 0;
	}
	
 	public boolean bookReplyAdd(ReplyDTO replydto) throws Exception {
 		int result = bookReplyDaoImpl.insert(replydto);
 		return result > 0;
 	}

	public List<ReplyDTO> getAllReply(String bookCode) throws Exception{
		List<ReplyDTO> list = bookReplyDaoImpl.selectAll(bookCode);
		return list;
	}
	
	public long bookReplyCount(String bookCode) throws Exception{
		long cnt = bookReplyDaoImpl.count(bookCode);
		return cnt;
	}

}
