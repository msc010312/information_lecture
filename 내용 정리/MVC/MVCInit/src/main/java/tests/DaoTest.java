package tests;

import org.junit.jupiter.api.Test;

import domain.DAO.UserDao;
import domain.DAO.UserDaoImpl;
import domain.DTO.UserDTO;

class DaoTest {

	@Test
	void test() throws Exception{
		UserDao userDao = UserDaoImpl.getInstance();
		userDao.insert(new UserDTO("user1235","1234","ROLE_USER"));
	}
}
