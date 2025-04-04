package ch09;

import java.net.Authenticator.RequestorType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import ch04.UserDto;

public class DBUtils {
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "system";
	private String password = "1234";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//싱글톤
	private static DBUtils instance;
	private DBUtils() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//오라클 DB 서버 연결
		conn = DriverManager.getConnection(url, id, password);
	}
	public static DBUtils getInstance() throws Exception{
		if(instance == null) {
			instance = new DBUtils();
		}
		return instance;
	}
	
	public int insertUser(UserDto userdto) throws Exception {
		pstmt = conn.prepareStatement("insert into tbl_user values(?,?)");
		pstmt.setString(1, userdto.getUserid());
		pstmt.setString(2, userdto.getPassword());
		int result = pstmt.executeUpdate();
		conn.commit();
		pstmt.close();
		return result;                                                                                                        
	}
	
	public List<UserDto> selectAllUser() throws Exception {
		pstmt = conn.prepareStatement("select * from tbl_user");
		rs = pstmt.executeQuery();
		List<UserDto> list = new ArrayList();
		UserDto userDto = null;
		if(rs != null) {
			while(rs.next()) {
				userDto = new UserDto();
				userDto.setUserid(rs.getString("userid"));
				userDto.setPassword(rs.getString("password"));
				list.add(userDto);
			}
		}
		rs.close();
		pstmt.close();
		return list;
	}
	
	public UserDto selectOneUser(String userid) throws Exception {
		pstmt = conn.prepareStatement("select * from tbl_user where userid=?");
		pstmt.setString(1, userid);
		rs = pstmt.executeQuery();
		UserDto userDto = null;
		if (rs != null) {
			userDto = new UserDto();
			userDto.setUserid(rs.getString("userid"));
			userDto.setPassword(rs.getString("password"));
		}
		rs.close();
		pstmt.close();
		return userDto;
	}
	
	public int updateUser(UserDto userdto) throws Exception{
		pstmt = conn.prepareStatement("update tbl_user set password=? where userid=? ");
		pstmt.setString(1, userdto.getPassword());
		pstmt.setString(2, userdto.getUserid());
		int result = pstmt.executeUpdate();
		conn.commit();
		pstmt.close();
		
		return result;
	}
	
	public int deleteUser(UserDto userDto) throws Exception{
		pstmt = conn.prepareStatement("delete from tbl_user where userid=?");
		pstmt.setString(1, userDto.getUserid());
		int result = pstmt.executeUpdate();
		conn.commit();
		pstmt.close();
		return result;
	}
}
