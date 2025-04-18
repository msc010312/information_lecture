package domain.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import domain.DAO.connectionPool.ConnectionItem;
import domain.DAO.connectionPool.ConnectionPool;
import domain.DTO.UserDTO;

public class UserDaoImpl extends Dao implements UserDao {
	// DB Attr
//	private Connection conn;
//	private PreparedStatement pstmt;
//	private ResultSet rs;
//	
//	private String id="root";
//	private String pw="1234";
//	private String url="jdbc:mysql://localhost:3306/bookDB";

	// CONNECTION POOL
//	private ConnectionPool connectionPool;
//	private ConnectionItem connectionItem;

	// 싱글톤 패턴처리
	private static UserDao instance;

	private UserDaoImpl() throws Exception {
		System.out.println("[DAO] UserDaoImpl init...");
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		conn = DriverManager.getConnection(url,id,pw);
//		System.out.println("UserDaoImpl DB Connection Success");
//		connectionPool =ConnectionPool.getInstance();

	};

	public static UserDao getInstance() throws Exception {
		if (instance == null)
			instance = new UserDaoImpl();
		return instance;
	}

	// CRUD

	@Override
	public int insert(UserDTO userDto) throws Exception {
		try {
			connectionItem = connectionPool.getConnection();
			Connection conn = connectionItem.getConn();

			pstmt = conn.prepareStatement("insert into tbl_user values(?,?,?)");
			pstmt.setString(1, userDto.getUsername());
			pstmt.setString(2, userDto.getPassword());
			pstmt.setString(3, "ROLE_USER");

			// Connection release
			connectionPool.releaseConnection(connectionItem);

			return pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("USERDAO's INSERT SQL EXCEPTION!!");
		} finally {
			try {
				pstmt.close();
			} catch (Exception e2) {
			}
		}
	}

	@Override
	public int update(UserDTO userDto) throws SQLException {
//		try {
//			pstmt = conn.prepareStatement("");
//			
//			return pstmt.executeUpdate();
//			
//		}catch(SQLException e) {
//			e.printStackTrace();
//			throw new SQLException("USERDAO's UPDATE SQL EXCEPTION!!");
//		}finally {
//			try {pstmt.close();}catch(Exception e2) {}
//		}
		return 0;
	}

	@Override
	public int delete(UserDTO userDto) throws SQLException {
//		try {
//			pstmt = conn.prepareStatement("");
//			
//			return pstmt.executeUpdate();
//			
//		}catch(SQLException e) {
//			e.printStackTrace();
//			throw new SQLException("USERDAO's DELETE SQL EXCEPTION!!");
//		}finally {
//			try {pstmt.close();}catch(Exception e2) {}
//		}
		return 0;
	}
	// 단건조회

	@Override
	public UserDTO select(String username) throws SQLException {
		try {
			connectionItem = connectionPool.getConnection();
			Connection conn = connectionItem.getConn();

			String sql = "select * from tbl_user where username=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			UserDTO userdto = null;
			if (rs.next() && rs!=null) {
				userdto = new UserDTO(rs.getString(1),rs.getString(2),rs.getString(3));
			}
			// Connection release
			connectionPool.releaseConnection(connectionItem);

			return userdto;
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException("USERDAO's INSERT SQL EXCEPTION!!");
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (Exception e2) {
			}
		}
	}
	// 다건조회

	@Override
	public List<UserDTO> selectAll() {
		return null;
	}

}
