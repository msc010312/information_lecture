package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.UserDTO;

public class OracleDBUtils {
	
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "system";
	private String pw = "1234";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;	
	
	private  DataSource dataSource;
	
	//싱글톤 
	private static OracleDBUtils instance;
	private OracleDBUtils() throws Exception {
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		conn = DriverManager.getConnection(url, id, pw);
		
		 Context initContext = new InitialContext();
		 Context envContext  = (Context)initContext.lookup("java:/comp/env");
		 dataSource = (DataSource)envContext.lookup("jdbc/oracleDB");  
		 conn = dataSource.getConnection();
		 System.out.println("Connection : "+ conn);
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







