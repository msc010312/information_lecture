package Ch38.tests.Dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import Ch38.Domain.Dao.BookDaoImpl;
import Ch38.Domain.Dao.BookDaoInterface;
import Ch38.Domain.Dao.UserDaoImpl;
import Ch38.Domain.Dao.UserDaoInterface;
import Ch38.Domain.Dto.BookDto;
import Ch38.Domain.Dto.UserDto;

class DaoTests {

	@Test
	void test1() throws Exception {
		
		UserDaoInterface userDaoImpl = UserDaoImpl.getInStance();
	}

	@Test
	void test2() throws Exception{
		UserDaoInterface userDaoImpl = UserDaoImpl.getInStance();
		userDaoImpl.insert(new UserDto("dddd","홍길동","1234",""));
	}
	
	@Test
	void test3() throws Exception {
		BookDaoInterface bookDaoImpl = BookDaoImpl.getInStance();
		bookDaoImpl.insert(new BookDto("abc","ccc","aaa","bbb"));
	}
}
