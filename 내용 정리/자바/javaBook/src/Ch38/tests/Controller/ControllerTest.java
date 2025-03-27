package Ch38.tests.Controller;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import Ch38.Controller.FrontController;

class ControllerTest {

	FrontController fc = FrontController.getInStance();

	@Test
	void test() {
		// view에서 요청정보 담기
		Map<String, Object> params = new HashMap();
		params.put("endPoint", "/user");
		params.put("serviceNum", 1);
		Map<String, Object> res = fc.excute(params);
		params.put("userid", "ccccc");
		params.put("username", "홍길동");
		params.put("password", "1234");

		// 응답확인
		for (String key : res.keySet()) {
			System.out.println(key + " : " + res.get(key));
		}
	}

	@Test
	void test2() {
		// view에서 요청정보 담기
		Map<String, Object> params = new HashMap();
		params.put("endPoint", "/book");
		params.put("serviceNum", 1);
		Map<String, Object> res = fc.excute(params);
		params.put("bookCode", "12345678");
		params.put("bookName", "모비딕");
		params.put("publisher", "aaa");
		params.put("isbn", "abc-de");

		// 응답확인
		for (String key : res.keySet()) {
			System.out.println(key + " : " + res.get(key));
		}
	}

}
