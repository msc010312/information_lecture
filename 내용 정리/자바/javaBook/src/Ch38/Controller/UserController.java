package Ch38.Controller;

import java.util.HashMap;
import java.util.Map;

import Ch38.Domain.Dto.UserDto;
import Ch38.Domain.Service.UserServiceImpl;

public class UserController implements SubController {
	private UserServiceImpl userService;

	public UserController() {
		try {
			userService = UserServiceImpl.getInStance();
		} catch (Exception e) {
			exceptionHandler(e);
		}
	}

	Map<String, Object> res;

	public Map<String, Object> excute(Map<String, Object> params) {
		// 1.회원가입(C) 2.조회(R) 3.수정(U) 4.삭제(D) 5.로그인 6.로그아웃
		System.out.println("[sc] usercontroller excute invoke");
		res = new HashMap();
		// 0
		Integer serviceNum = (Integer) params.get("serviceNum");
		// 1. 파라미터받기
		// 2. 유효성검증
		// 3. 관련 서비스 실행
		// 4. 뷰로 이동
		try {
			switch (serviceNum) {
			case 1:
				System.out.println("[sc] 회원가입 요청확인");
				String userid = (params.get("userid") != null) ? (String) params.get("userid") : null;
				String username = (params.get("username") != null) ? (String) params.get("username") : null;
				String password = (params.get("password") != null) ? (String) params.get("password") : null;
				String role = "ROLE_MANAGER";
				UserDto userdto = new UserDto(userid, username, password, role);
				boolean isValid = isValid(userdto);
				System.out.println("회원가입 유효성 검증 : " + isValid);
				if(!isValid) {
					res.put("status", false);
					return res;
				}
				
				boolean isSuc = userService.userJoin(userdto);

				res.put("status", isSuc);
				res.put("message", "회원가입 성공");
				break;
			case 2:
				System.out.println("[sc] 회원정보조회 요청확인");
				break;
			case 3:
				System.out.println("[sc] 회원정보수정 요청확인");
				break;
			case 4:
				System.out.println("[sc] 회원탈퇴 요청확인");
				break;
			case 5:
				System.out.println("[sc] 로그인 요청확인");
				break;
			case 6:
				System.out.println("[sc] 로그아웃 요청확인");
				break;
			default:
				System.out.println("[sc] 잘못된 서비스번호 요청");
				res.put("status", false);
				res.put("status", "유효하지않은 서비스 요청");
			}
		} catch (Exception e) {
			exceptionHandler(e);
		}
		return res;
	}

	// 유효성 검사 함수
	private boolean isValid(UserDto userdto) {
		if (userdto.getUserid() == null || userdto.getUserid().length() <= 4) {
			res.put("error", "userid는 최소 5글자 이상이어야합니다");
			System.out.println("[invalid] userid는 최소 5글자이상이어야합니다");
			return false;
		}
		if (userdto.getUserid().matches("^[0-9].*")) {
			res.put("erroe", "userid는 첫문자가 숫자로 들어올 수 없습니다");
			System.out.println("[invalid] userid는 첫문자가 숫자로 들어올 수 없습니다");
			return false;
		}
		return true;
	}

	// 예외처리함수
	public Map<String, Object> exceptionHandler(Exception e) {
		if (res == null)
			res = new HashMap();
		res.put("status", false);
		res.put("message", e.getMessage());
		res.put("exception", e);

		return res;
	}
}
