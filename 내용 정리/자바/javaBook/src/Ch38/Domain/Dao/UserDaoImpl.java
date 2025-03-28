package Ch38.Domain.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Ch38.Domain.Dao.ConnectionPool.ConnectionItem;
import Ch38.Domain.Dao.ConnectionPool.ConnectionPool;
import Ch38.Domain.Dto.UserDto;

public class UserDaoImpl extends ConnectionDao implements UserDaoInterface {
	// 싱글톤 패턴처리
	private static UserDaoInterface instance;
	private UserDaoImpl() throws Exception { // 예외처리를 컨트롤러 영역으로 넘겨줌
		System.out.println("[DAO] userServiceImpl init");
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		conn = DriverManager.getConnection(url,id,pw);
//		System.out.println("DB 연결완료");
	};
	public static UserDaoInterface getInStance() throws Exception {
		if(instance == null) {
			instance = new UserDaoImpl();
		}
		return instance;
	}
	
	// CRUD
	@Override
	public int insert(UserDto userdto) throws Exception {
		try {
			connectionItem = connectionPool.getConnection();
			Connection conn = connectionItem.getConn();
			pstmt = conn.prepareStatement("insert into tbl_user values(?,?,?,?)");
			pstmt.setString(1, userdto.getUserid());
			pstmt.setString(2, userdto.getUsername());
			pstmt.setString(3, userdto.getPassword());
			pstmt.setString(4, "ROLE_USER");
			
			//Connection release
			connectionPool.releaseConnection(connectionItem);
			
			return pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("userdao insert 예외발생");
		} finally {
			try {pstmt.close();}catch(Exception e2) {}
		}
	}
	
	@Override
	public int update(UserDto userdto) throws Exception {
		try {
			connectionItem = connectionPool.getConnection();
			Connection conn = connectionItem.getConn();
			pstmt = conn.prepareStatement("");
			//Connection release
			connectionPool.releaseConnection(connectionItem);
			return pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("userdao update 예외발생");
		} finally {
			try {pstmt.close();}catch(Exception e2) {}
		}
	}
	
	@Override
	public int delete(UserDto userdto) throws Exception {
		try {
			connectionItem = connectionPool.getConnection();
			Connection conn = connectionItem.getConn();
			pstmt = conn.prepareStatement("");
			//Connection release
			connectionPool.releaseConnection(connectionItem);
			return pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("userdao delete 예외발생");
		} finally {
			try {pstmt.close();}catch(Exception e2) {}
		}
	}
	
	// 단일조회
	@Override
	public UserDto select(UserDto userdto) {
		return null;
	}
	// 복수조회
	@Override
	public List<UserDto> selectAll() {
		return null;
	}
	
	
}
