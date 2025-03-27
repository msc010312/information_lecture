package Ch38.Domain.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Ch38.Domain.Dto.UserDto;

public class UserDaoImpl {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private String id = "root";
	private String pw = "1234";
	private String url = "jdbc:mysql://localhost:3306/bookdb";
	// 싱글톤 패턴처리
	private static UserDaoImpl instance;
	private UserDaoImpl() throws SQLException, ClassNotFoundException { // 예외처리를 컨트롤러 영역으로 넘겨줌
		System.out.println("[DAO] userServiceImpl init");
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url,id,pw);
		System.out.println("DB 연결완료");
	};
	public static UserDaoImpl getInStance() throws ClassNotFoundException, SQLException {
		if(instance == null) {
			instance = new UserDaoImpl();
		}
		return instance;
	}
	
	// CRUD
	public int insert(UserDto userdto) throws SQLException {
		try {
			pstmt = conn.prepareStatement("insert into tbl_user values(?,?,?,?)");
			pstmt.setString(1, userdto.getUserid());
			pstmt.setString(2, userdto.getUsername());
			pstmt.setString(3, userdto.getPassword());
			pstmt.setString(4, "ROLE_USER");
			return pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("userdao insert 예외발생");
		} finally {
			try {pstmt.close();}catch(Exception e2) {}
		}
	}
	
	public int update(UserDto userdto) throws SQLException {
		try {
			pstmt = conn.prepareStatement("");
			return pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("userdao update 예외발생");
		} finally {
			try {pstmt.close();}catch(Exception e2) {}
		}
	}
	
	public int delete(UserDto userdto) throws SQLException {
		try {
			pstmt = conn.prepareStatement("");
			return pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("userdao delete 예외발생");
		} finally {
			try {pstmt.close();}catch(Exception e2) {}
		}
	}
	
	// 단일조회
	public UserDto select(UserDto userdto) {
		return null;
	}
	// 복수조회
	public List<UserDto> selectAll() {
		return null;
	}
	
	
}
