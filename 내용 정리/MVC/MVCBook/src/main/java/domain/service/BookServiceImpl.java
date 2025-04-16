package domain.service;

import domain.DAO.BookDao;
import domain.DAO.BookDaoImpl;
import domain.DTO.BookDTO;

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
		
		return bookDao.insert(bookDto)>0;
		
	}
	
	
}
