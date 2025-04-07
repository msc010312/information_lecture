package utils;

import java.net.Authenticator.RequestorType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

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
	
//	public int insertUser(UserDto userdto) throws Exception {
//		pstmt = conn.prepareStatement("");
//		int result = pstmt.executeUpdate();
//		conn.commit();
//		pstmt.close();
//		return result;                                                                                                        
//	}
	
	//select all
	public List<MemberDTO> selectAllMember() throws Exception {
		String sql = "select m.m_no,m_name,p_name,p_school,m.m_jumin,m_city,p_tel1,p_tel2,p_tel3"
				+ "	from tbl_member_202005 m"
				+ "	join tbl_party_202005 p"
				+ "	on m.p_code = p.p_code";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<MemberDTO> list = new ArrayList();
		MemberDTO memberDto = null;
		if(rs != null) {
			while(rs.next()) {
				memberDto = new MemberDTO();
				memberDto.setM_no(rs.getString(1));
				memberDto.setM_name(rs.getString(2));
				memberDto.setP_name(rs.getString(3));
				memberDto.setP_school(rs.getString(4));
				memberDto.setM_jumin(rs.getString(5));
				memberDto.setM_city(rs.getString(6));
				memberDto.setP_tel1(rs.getString(7));
				memberDto.setP_tel2(rs.getString(8));
				memberDto.setP_tel3(rs.getString(9));
				list.add(memberDto);
			}
		}
		rs.close();
		pstmt.close();
		return list;
	}
}
	
//	public UserDto selectOneUser(String userid) throws Exception {
//		pstmt = conn.prepareStatement("select * from tbl_user where userid=?");
//		pstmt.setString(1, userid);
//		rs = pstmt.executeQuery();
//		UserDto userDto = null;
//		if (rs != null) {
//			userDto = new UserDto();
//			userDto.setUserid(rs.getString("userid"));
//			userDto.setPassword(rs.getString("password"));
//		}
//		rs.close();
//		pstmt.close();
//		return userDto;
//	}
	
	