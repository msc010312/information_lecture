package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.UserDTO;

public class OracleDBUtils {
	
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "system";
	private String pw = "1234";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;	
	
	//싱글톤 
	private static OracleDBUtils instance;
	private OracleDBUtils() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, id, pw);
	}
	public static OracleDBUtils getInstance() throws Exception {
		if(instance==null)
			instance = new OracleDBUtils();
		return instance;
	}
	
	
	public int insertUser(UserDTO userdto) throws Exception {
		String sql = "insert into tbl_user values(?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userdto.getUsername());
		pstmt.setString(2, userdto.getPassword());
		int result = pstmt.executeUpdate();
		conn.commit();
		pstmt.close();
		return result;                                                                                                        
	}
	
	public UserDTO selectUser(String id) throws Exception {
		String sql = "select * from tbl_user where username=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		UserDTO userdto = null;
		if(rs.isBeforeFirst()) {
			rs.next();
			userdto = new UserDTO();
			userdto.setUsername(rs.getString(1));
			userdto.setPassword(rs.getString(2));
		}
		
		rs.close();
		pstmt.close();
		return userdto;
	}
	

}







