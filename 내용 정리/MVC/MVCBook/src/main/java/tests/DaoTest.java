package tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import domain.DAO.BookDao;
import domain.DAO.BookDaoImpl;
import domain.DAO.UserDao;
import domain.DAO.UserDaoImpl;
import domain.DTO.BookDTO;
import domain.DTO.UserDTO;

class DaoTest {

	@Test
	@Disabled
	void test() throws Exception{
		UserDao userDao = UserDaoImpl.getInstance();
		userDao.insert(new UserDTO("user1235","1234","ROLE_USER"));
	}
	
	@Test
	@Disabled
	void test2() throws Exception {
		UserDao userDao = UserDaoImpl.getInstance();
		System.out.println(userDao.select("admin"));
	}
	
	@Test
	@Disabled
	void test3() throws Exception{
		BookDao bookDao = BookDaoImpl.getInstance();
		bookDao.insert(new BookDTO("111","리눅스","사과", "11-11"));
	}
	
	@Test
	void test4() throws Exception{
		BookDao bookDao = BookDaoImpl.getInstance();
		bookDao.selectAll().forEach(System.out::println);
	}
}
