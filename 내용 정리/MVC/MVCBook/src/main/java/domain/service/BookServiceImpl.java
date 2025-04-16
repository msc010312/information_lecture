package domain.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.DAO.BookDao;
import domain.DAO.BookDaoImpl;
import domain.DTO.BookDTO;
import domain.DTO.Criteria;
import domain.DTO.PageDto;

public class BookServiceImpl {

	//
	private BookDao bookDao;
	
	//싱글톤 패턴
	private static BookServiceImpl instance;
	private BookServiceImpl() throws Exception{	
		bookDao = BookDaoImpl.getInstance();
	}
	public static BookServiceImpl getInstance() throws Exception{
		if(instance==null)
			instance = new BookServiceImpl();
		return instance;
	}
	
	
	//TX 처리 + 비즈니스 유효성검사
	public boolean bookRegistration(BookDTO bookDto) throws Exception{
		
		int result = bookDao.insert(bookDto);
		
		return result>0;
		
	}
	
	public Map<String,Object> getAllBooks() throws Exception {
		Map<String,Object> response = new HashMap();
		List<BookDTO> list = bookDao.selectAll();
		if(list.size()!=0) {
			response.put("status", true);
			response.put("list", list);
		} else {
			response.put("stauts", false);
		}
		return response;
	}
	
	public Map<String,Object> getAllBooks(Criteria criteria) throws Exception {
		Map<String,Object> response = new HashMap();
		int offset = (criteria.getPageno()-1)*criteria.getAmount();
		
		// 페이지별 표시수
		List<BookDTO> list = bookDao.selectAll(offset,criteria.getAmount());
		
		// pageDto
		long count = bookDao.count();
		PageDto pd = new PageDto(count,criteria);
		
		if(list.size()!=0) {
			response.put("status", true);
			response.put("list", list);
			response.put("pageDto", pd);
		} else {
			response.put("stauts", false);
		}
		return response;
	}
	
}
