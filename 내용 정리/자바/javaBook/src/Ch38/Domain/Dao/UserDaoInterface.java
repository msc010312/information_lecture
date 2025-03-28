package Ch38.Domain.Dao;

import java.sql.SQLException;
import java.util.List;

import Ch38.Domain.Dto.UserDto;

public interface UserDaoInterface {

	// CRUD
	int insert(UserDto userdto) throws Exception;

	int update(UserDto userdto) throws Exception;

	int delete(UserDto userdto) throws Exception;

	// 단일조회
	UserDto select(UserDto userdto);

	// 복수조회
	List<UserDto> selectAll();

}