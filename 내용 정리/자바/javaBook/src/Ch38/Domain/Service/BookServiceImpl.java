package Ch38.Domain.Service;

import java.sql.SQLException;

import Ch38.Domain.Dao.BookDaoImpl;
import Ch38.Domain.Dao.BookDaoInterface;
import Ch38.Domain.Dto.BookDto;

public class BookServiceImpl {
	
	private BookDaoInterface bookDao;

	// 싱글톤 패턴
	private static BookServiceImpl instance;

	private BookServiceImpl() throws Exception {
		bookDao = BookDaoImpl.getInStance();
	};

	public static BookServiceImpl getInStance() throws Exception {
		if (instance == null) {
			instance = new BookServiceImpl();
		}
		return instance;
	}
	
	public boolean bookRegi(BookDto bookdto) throws Exception {
		return bookDao.insert(bookdto) > 0;
	}
}
