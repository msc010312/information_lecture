package Ch38.Controller;

import java.util.HashMap;
import java.util.Map;

public class FrontController {

	// 서브컨트롤러 저장 자료구조("/endPoint" : 서브컨트롤러 객체)
	private Map<String,SubController> map = new HashMap();
	
	// 싱글톤 패턴처리
	private static FrontController instance;

	private FrontController() {
		System.out.println("[fc] FrontController init");
		init();
	};

	public static FrontController getInStance() {
		if (instance == null) {
			instance = new FrontController();
		}
		return instance;
	}

	// 초기화
	private void init() {
		// 인증요청
		map.put("/user", new UserController());
		map.put("/book", new BookController());
	}
	
	// View
	public Map<String, Object> excute (Map<String,Object> params) {
		String endPoint = (String)params.get("endPoint");
		SubController cont = map.get(endPoint);
		return cont.excute(params);
	}
}
