package Ch38.tests.Service;

import org.junit.jupiter.api.Test;

import Ch38.Domain.Dto.BookDto;
import Ch38.Domain.Dto.UserDto;
import Ch38.Domain.Service.BookServiceImpl;
import Ch38.Domain.Service.UserServiceImpl;

class ServiceTest {
	
	
	@Test
	void test() throws ClassNotFoundException, Exception {
		UserServiceImpl userService = UserServiceImpl.getInStance();
		userService.userJoin(null);
//		userService.userJoin(new UserDto("bbb","남길동","1234","ROLE_USER"));
	}
	
	@Test
	void test2() throws ClassNotFoundException, Exception {
		BookServiceImpl bookService = BookServiceImpl.getInStance();
		bookService.bookRegi(new BookDto("12345","aaa","bbb","ccc"));
	}

}
