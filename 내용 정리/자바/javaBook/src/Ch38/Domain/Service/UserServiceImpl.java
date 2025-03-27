package Ch38.Domain.Service;

import java.sql.SQLException;

import Ch38.Domain.Dao.UserDaoImpl;
import Ch38.Domain.Dto.UserDto;

public class UserServiceImpl {
	private UserDaoImpl userDao;
	
	// 싱글톤 패턴처리
	private static UserServiceImpl instance;
	private UserServiceImpl() throws ClassNotFoundException, SQLException {
		userDao = UserDaoImpl.getInStance();
		System.out.println("[Service] userServiceImpl init");
	};
	public static UserServiceImpl getInStance() throws ClassNotFoundException, SQLException {
		if (instance == null) {
			instance = new UserServiceImpl();
		}
		return instance;
	}
	
	// 회원가입
	public boolean userJoin(UserDto userdto) throws SQLException{
		return userDao.insert(userdto) > 0;
	};
	// 조회
	
	// 수정
	
	// 회원탈퇴
	
	// 로그인
	
	// 로그아웃
}
