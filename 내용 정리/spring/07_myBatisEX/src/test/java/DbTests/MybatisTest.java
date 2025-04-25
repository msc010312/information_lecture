package DbTests;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.app.domain.dto.UserDTO;
import com.example.app.domain.mapper.UserMapper;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
class MybatisTest {

	@Autowired
	UserMapper userMapper;

	@Test
	void test() {
//		userMapper.insertXml(new UserDTO("user3","aaa","12345","ROLE_USER"));
//		userMapper.updateXml(new UserDTO("user3","bbb","12345","ROLE_USER"));
//		userMapper.deleteXml("user3");

//		List<Map<String, Object>> list = userMapper.selectAllResultMapXml();
//		list.forEach(System.out::println);

//		UserDTO dto1 = UserDTO.builder().userid("abab").username("홍길동").password("1234").build();
//		UserDTO dto2 = UserDTO.builder().userid("cdcd").username("남길동").password("1234").build();
//
//		userMapper.insertXml(dto1);
//		userMapper.insertXml(dto2);
//		dto1.setAddr1("대구");
//		userMapper.updateXml(dto1);
//		userMapper.deleteXml("cdcd");

//		System.out.println(userMapper.selectAtXml("user1"));

//		List<UserDTO> list1 = userMapper.selectAllXml();
//		list1.forEach(System.out::println);
//
//		List<Map<String, Object>> list2 = userMapper.selectAllResultMapXml();
//		list2.forEach(System.out::println);
	}

}
