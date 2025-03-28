package Ch38.Domain.Dao;

import java.sql.SQLException;
import java.util.List;

import Ch38.Domain.Dto.BookDto;

public interface BookDaoInterface {

	// CRUD
	int insert(BookDto bookdto) throws Exception;

	int update(BookDto bookdto) throws Exception;

	int delete(BookDto bookdto) throws Exception;

	// 단일조회
	BookDto select(BookDto bookdto);

	// 복수조회
	List<BookDto> selectAll();

}