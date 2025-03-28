package Ch38.Domain.Service;

import java.sql.SQLException;

import Ch38.Domain.Dao.UserDaoImpl;
import Ch38.Domain.Dao.UserDaoInterface;
import Ch38.Domain.Dao.ConnectionPool.ConnectionPool;
import Ch38.Domain.Dto.UserDto;

public class UserServiceImpl {
	private UserDaoInterface userDao;
	private ConnectionPool connectionPool;

	// 싱글톤 패턴처리
	private static UserServiceImpl instance;

	private UserServiceImpl() throws Exception {
		userDao = UserDaoImpl.getInStance();
		connectionPool = ConnectionPool.getInstance();
		System.out.println("[Service] userServiceImpl init");
	};

	public static UserServiceImpl getInStance() throws Exception {
		if (instance == null) {
			instance = new UserServiceImpl();
		}
		return instance;
	}

	// 회원가입
	public boolean userJoin(UserDto userdto) throws Exception {
		boolean isjoin = false;
		try {
			connectionPool.beginTransaction();
			isjoin = userDao.insert(userdto) > 0;
//			userDao.insert(new UserDto("aaaaaa","","",""));
//			userDao.insert(new UserDto("aaaaab","","",""));
//			userDao.insert(new UserDto("aaaaaa","","",""));
			connectionPool.commitTransaction();
		} catch (Exception e) {
			connectionPool.rollbackTransaction();
		}
		return isjoin;
	};
	// 조회

	// 수정

	// 회원탈퇴

	// 로그인

	// 로그아웃
}
