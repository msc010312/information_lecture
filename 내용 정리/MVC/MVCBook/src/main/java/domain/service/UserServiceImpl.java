package domain.service;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import domain.DAO.UserDao;
import domain.DAO.UserDaoImpl;
import domain.DAO.connectionPool.ConnectionPool;
import domain.DTO.UserDTO;

public class UserServiceImpl {

	//
	private UserDao userDao;
	private ConnectionPool connectionPool;

	// 싱글톤 패턴
	private static UserServiceImpl instance;

	private UserServiceImpl() throws Exception {
		userDao = UserDaoImpl.getInstance();
		connectionPool = ConnectionPool.getInstance();
		System.out.println("[SERVICE] UserServiceImpl init...");
	};

	public static UserServiceImpl getInstance() throws Exception {
		if (instance == null)
			instance = new UserServiceImpl();
		return instance;
	}

	// 회원가입(+TX처리필요)
	public boolean userJoin(UserDTO userDto) throws Exception {
		boolean isJoin = false;
		try {

			connectionPool.beginTransaction();
			isJoin = userDao.insert(userDto) > 0; // sql 질의 다수
			connectionPool.commitTransaction();

		} catch (SQLException e) {
			connectionPool.rollbackTransaction();
		}

		return isJoin;

	};

	// 회원조회

	public Map<String, Object> login(UserDTO userDto, HttpSession session) throws Exception {

		Map<String, Object> res = new LinkedHashMap();
		boolean isLogin = false;

		try {

//			connectionPool.beginTransaction();

			UserDTO userDb = userDao.select(userDto.getUsername()); // sql 질의 다수

			if (userDb == null) {
				res.put("isLogin", false);
				res.put("message", "동일한 계정이 존재하지 않습니다");
			} else {
				if (!userDto.getPassword().equals(userDb.getPassword())) {
					res.put("isLogin", false);
					res.put("message", "패스워드가 일치하지 않습니다");
				} else {
					session.setAttribute("isAuth", true);
					session.setAttribute("username", userDb.getUsername());
					session.setAttribute("role", userDb.getRole());
					session.setMaxInactiveInterval(60 * 10);

					res.put("isLogin", true);
					res.put("message", "로그인성공");
				}
			}

//			connectionPool.commitTransaction();

		} catch (SQLException e) {
//			connectionPool.rollbackTransaction();
		}
		return res;
	}

	// 회원정보수정

	// 회원탈퇴

	// 로그인

	// 로그아웃
	public Map<String, Object> logout(HttpSession session) throws Exception  {
		session.invalidate();
		Map<String, Object> response = new LinkedHashMap();
		response.put("isLogout",true);
		return response;
	}

}
