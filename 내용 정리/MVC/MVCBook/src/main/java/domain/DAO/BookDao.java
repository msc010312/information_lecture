package domain.DAO;

import java.sql.SQLException;
import java.util.List;

import domain.DTO.BookDTO;
import domain.DTO.UserDTO;

public interface BookDao {

	int insert(BookDTO bookDto) throws Exception;

	int update(UserDTO userDto) throws SQLException;

	int delete(UserDTO userDto) throws SQLException;
	//단건조회

	UserDTO select(UserDTO userDto);
	//다건조회

	List<UserDTO> selectAll();

}