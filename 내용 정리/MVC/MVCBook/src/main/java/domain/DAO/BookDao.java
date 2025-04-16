package domain.DAO;

import java.sql.SQLException;
import java.util.List;

import domain.DTO.BookDTO;
import domain.DTO.Criteria;
import domain.DTO.UserDTO;

public interface BookDao {

	int insert(BookDTO bookDto) throws Exception;

	int update(BookDTO bookDto) throws SQLException;

	int delete(BookDTO bookDto) throws SQLException;
	//단건조회

	UserDTO select(BookDTO bookDto) throws SQLException;
	//다건조회

	public List<BookDTO> selectAll() throws Exception;

	public List<BookDTO> selectAll(int offset, int amount) throws Exception;

	public long count() throws Exception;
}