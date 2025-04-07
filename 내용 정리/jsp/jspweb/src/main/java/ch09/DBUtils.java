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
		pstmt = conn.prepareStatement("insert into tbl_user values(?,?,?)");
		pstmt.setString(1, userdto.getUserid());
		pstmt.setString(2, userdto.getPassword());
		pstmt.setString(3, "");
		int result = pstmt.executeUpdate();
		conn.commit();
		pstmt.close();
		return result;                                                                                                        
	}
	
	//user
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
	
	// order(총 구매금액)
	public List<OrderDTO> selectAllOrder() throws Exception{
		String sql = "select category,sum(price*quantity) from tbl_order"
				+ " group by category"
				+ " having sum(price*quantity) >=50000"
				+ " order by sum(price*quantity) desc";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<OrderDTO> list = new ArrayList();
		OrderDTO orderDto = null;
		if(rs != null) {
			while(rs.next()) {
				orderDto = new OrderDTO();
				orderDto.setCategory(rs.getString(1));
				orderDto.setSum(rs.getInt(2));
				list.add(orderDto);
			}
		}
		rs.close();
		pstmt.close();
		return list;
	}
	
	// order(날짜별 구매 총 평균)
	public List<OrderDTO2> selectDateOrder() throws Exception {
		String sql = "select order_date,round(avg(price*quantity),2)from tbl_order"
				+ " group by order_date"
				+ " order by order_date desc";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<OrderDTO2> list = new ArrayList();
		OrderDTO2 orderDto = null;
		if(rs != null) {
			while(rs.next()) {
				orderDto = new OrderDTO2();
				orderDto.setOrderDate(rs.getDate(1));
				orderDto.setSum(rs.getInt(2));
				list.add(orderDto);
			}
		}
		rs.close();
		pstmt.close();
		return list;
	}
	
	// order(지역 + 날짜별 구매총액)
	public List<OrderDTO3> selectAddrOrder() throws Exception{
		String sql = "SELECT u.addr, o.order_date, SUM(o.price * o.quantity)"
				+ " FROM tbl_user u"
				+ " JOIN tbl_order o ON u.userid = o.userid"
				+ " GROUP BY u.addr, o.order_date"
				+ " order by u.addr, o.order_date";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<OrderDTO3> list = new ArrayList();
		OrderDTO3 orderDto = null;
		if(rs != null) {
			while(rs.next()) {
				orderDto = new OrderDTO3();
				orderDto.setAddr(rs.getString(1));
				orderDto.setOrderDate(rs.getDate(2));
				orderDto.setTotalAmount(rs.getInt(3));
				list.add(orderDto);
			}
		}
		rs.close();
		pstmt.close();
		return list;
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
	
	public int deleteUser(String userid) throws Exception{
		pstmt = conn.prepareStatement("delete from tbl_user where userid=?");
		pstmt.setString(1, userid);
		int result = pstmt.executeUpdate();
		conn.commit();
		pstmt.close();
		return result;
	}
}
