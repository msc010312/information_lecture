package Ch38.tests.Service;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import Ch38.Domain.Dto.UserDto;
import Ch38.Domain.Service.UserServiceImpl;

class ServiceTest {
	
	
	@Test
	void test() throws ClassNotFoundException, SQLException {
		UserServiceImpl userService = UserServiceImpl.getInStance();
		userService.userJoin(new UserDto("bbb","남길동","1234","ROLE_USER"));
	}
	
	@Test
	void test2() {
		
	}

}
