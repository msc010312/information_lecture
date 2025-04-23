package DITest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.app.config.PersonComponent;
import com.example.app.domain.DTO.PersonDTO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
class DItest2 {
	@Autowired
	private PersonDTO personDTO1;

	@Autowired
	private PersonDTO personDTO2;
	
	@Autowired
	private PersonDTO person3;
	
	@Autowired
	private PersonDTO personBean;
	
	@Autowired
	private PersonComponent personComponent;
	
	@Test
	@Disabled
	void test() {
		System.out.println(personDTO1);
		System.out.println(personDTO2);
		System.out.println(person3);
		System.out.println(personBean);
		System.out.println(personComponent);
	}
	
	@Autowired
	private ApplicationContext applicationContext;
	@Test
	void test2() {
		assertNotNull(applicationContext);
		System.out.println(applicationContext.getBean("personComponent"));
	}
}
