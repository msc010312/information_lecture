package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import domain.DTO.BookDTO;
import domain.service.BookServiceImpl;

class ServiceTests {

	@Test
	void test() throws Exception{
		BookServiceImpl.getInstance().bookRegistration(new BookDTO("222","java","오랜지","22-22"));
	}

}
