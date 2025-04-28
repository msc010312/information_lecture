package DbTests;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.app.domain.dto.MemoDto;
import com.example.app.domain.mapper.MemoMapper;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
class MybatisTests {

	@Autowired
	private MemoMapper memoMapper;
	
	@Autowired
	private SqlSessionFactory sqlsessionfactory; 
	
	@Test
	@Disabled
	void t1() {
		assertNotNull(sqlsessionfactory);
		SqlSession SqlSession = sqlsessionfactory.openSession();
		assertNotNull(SqlSession);
	}
	
	@Test
	@Disabled
	void test() {
//		memoMapper.insert(new MemoDto(1010,"a","a@naver.com",LocalDateTime.now(),null));
//		memoMapper.update(new MemoDto(1010,"saddsa","a@naver.com",LocalDateTime.now(),null));
//		memoMapper.delete(1);
//		System.out.println(memoMapper.selectAt(1010));
//		System.out.println(memoMapper.selectAll());
//		List<MemoDto> list = memoMapper.selectAll();
//		list.forEach(System.out::println);
//		List<Map<String,Object>> list = memoMapper.selectAllResultMap();
//		list.forEach(System.out::println);
		
		//XML
//		memoMapper.insertXml(new MemoDto(2024,"a","a@naver.com",LocalDateTime.now(),null));
//		memoMapper.updateXml(new MemoDto(2024,"sdaasdsa","a@naver.com",LocalDateTime.now(),null));
//		memoMapper.deleteXml(2020);
//		List<Map<String,Object>> list = memoMapper.selectAllResultMapXml();
//		list.forEach(System.out::println);
		
		MemoDto md = new MemoDto(null,"a","a@naver.com",LocalDateTime.now());
		memoMapper.insert(md);

	}

	
	@Test
	void test2() {
		Map<String,Object> param = new HashMap();
		param.put("type", "id");
		param.put("keyword", "20");
//		List<Map<String,Object>> resp = memoMapper.Select_if_xml(param);
//		resp.forEach(System.out::println);
		
		List<Map<String,Object>> resp = memoMapper.Select_when_xml(param);
		resp.forEach(System.out::println);
	}
	
}
