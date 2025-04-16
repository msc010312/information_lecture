package domain.DAO;

import java.sql.SQLException;
import java.util.List;

import domain.DTO.UserDTO;

public interface UserDao {

	int insert(UserDTO userDto) throws Exception;

	int update(UserDTO userDto) throws SQLException;

	int delete(UserDTO userDto) throws SQLException;
	//단건조회

	UserDTO select(String username) throws SQLException; 
	//다건조회

	List<UserDTO> selectAll();

}