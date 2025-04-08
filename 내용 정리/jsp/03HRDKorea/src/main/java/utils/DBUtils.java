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
	
	public int insertVote(VoteDTO voteDto) throws Exception {
		String sql = "insert into tbl_vote_202005 values(?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, voteDto.getV_jumin());
		pstmt.setString(2, voteDto.getV_name());
		pstmt.setString(3, voteDto.getM_num());
		pstmt.setString(4, voteDto.getV_time());
		pstmt.setString(5, voteDto.getV_area());
		pstmt.setString(6, voteDto.getV_confirm());
		int result = pstmt.executeUpdate();
		conn.commit();
		pstmt.close();
		return result;                                                                                                        
	}
	
	//select all
		public List<TeacherDTO> selectAllTeacher() throws Exception {
			String sql = "select * from tbl_teacher_202201";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<TeacherDTO> list = new ArrayList();
			TeacherDTO teacherDto = null;
			if(rs != null) {
				while(rs.next()) {
					teacherDto = new TeacherDTO();
					teacherDto.setTeacher_code(rs.getString(1));
					teacherDto.setTeacher_name(rs.getString(2));
					teacherDto.setClass_name(rs.getString(3));
					teacherDto.setClass_price(rs.getInt(4));
					teacherDto.setTeacher_regist_date(rs.getString(5));
					list.add(teacherDto);
				}
			}
			rs.close();
			pstmt.close();
			return list;
		}
	
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

	//select all
	public List<VoteDTO> selectAllVote() throws Exception {
		String sql = "select * from tbl_vote_202005 where v_area='제1투표장'";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<VoteDTO> list = new ArrayList();
		VoteDTO voteDto = null;
		if(rs != null) {
			while(rs.next()) {
				voteDto = new VoteDTO();
				voteDto.setV_jumin(rs.getString(1));
				voteDto.setV_name(rs.getString(2));
				voteDto.setM_num(rs.getString(3));
				voteDto.setV_time(rs.getString(4));
				voteDto.setV_area(rs.getString(5));
				voteDto.setV_confirm(rs.getString(6));
				list.add(voteDto);
			}
		}
		rs.close();
		pstmt.close();
		return list;
	}
	
	public List<RankDTO> selectAllRank() throws Exception {
		String sql = "select m.m_no,m_name,count(m.m_no) from tbl_member_202005 m"
				+ " join  tbl_vote_202005 v"
				+ " on m.m_no = v.m_no"
				+ " where v.v_confirm='Y'"
				+ " group by m.m_no, m_name"
				+ " order by count(*) desc";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<RankDTO> list = new ArrayList();
		RankDTO rankDto = null;
		if(rs != null) {
			while(rs.next()) {
				rankDto = new RankDTO();
				rankDto.setM_no(rs.getString(1));
				rankDto.setM_name(rs.getString(2));
				rankDto.setCount(rs.getString(3));
				list.add(rankDto);
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
	
	