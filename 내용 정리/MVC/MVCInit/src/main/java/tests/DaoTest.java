package tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import domain.DAO.UserDao;
import domain.DAO.UserDaoImpl;
import domain.DTO.UserDTO;

class DaoTest {

	@Test
	@Disabled
	void test() throws Exception{
		UserDao userDao = UserDaoImpl.getInstance();
		userDao.insert(new UserDTO("user1235","1234","ROLE_USER"));
	}
	
	@Test
	void test2() throws Exception {
		UserDao userDao = UserDaoImpl.getInstance();
		System.out.println(userDao.select("admin"));
	}
}
