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
	
	public int insertClass(ClassDTO classDto) throws Exception {
		String sql = "insert into tbl_class_202201 values(?,?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, classDto.getRegist_month());
		pstmt.setString(2, classDto.getC_no());
		pstmt.setString(3, classDto.getClass_area());
		pstmt.setInt(4, classDto.getTuituon());
		pstmt.setString(5, classDto.getTeacher_code());
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
		String sql = "select * from tbl_member_202201";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<MemberDTO> list = new ArrayList();
		MemberDTO memberDto = null;
		if(rs != null) {
			while(rs.next()) {
				memberDto = new MemberDTO();
				memberDto.setC_no(rs.getString(1));
				memberDto.setC_name(rs.getString(2));
				memberDto.setPhone(rs.getString(3));
				memberDto.setAddress(rs.getString(4));
				memberDto.setGrade(rs.getString(5));				
				list.add(memberDto);
			}
		}
		rs.close();
		pstmt.close();
		return list;
	}
	
	//select all
		public List<ClassDTO> selectAllClass() throws Exception {
			String sql = "select * from tbl_class_202201";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<ClassDTO> list = new ArrayList();
			ClassDTO classDto = null;
			if(rs != null) {
				while(rs.next()) {
					classDto = new ClassDTO();
					classDto.setRegist_month(rs.getString(1));
					classDto.setC_no(rs.getString(2));
					classDto.setClass_area(rs.getString(3));
					classDto.setTuituon(rs.getInt(4));
					classDto.setTeacher_code(rs.getString(5));				
					list.add(classDto);
				}
			}
			rs.close();
			pstmt.close();
			return list;
		}
	
	//select all
		public List<GmemberDTO> selectAllGmember() throws Exception {
			String sql = "select c.regist_month,m.c_no,m.c_name,t.class_name,c.class_area,t.class_price,m.grade"
					+ " from tbl_class_202201 c, tbl_teacher_202201 t, tbl_member_202201 m"
					+ " where c.teacher_code = t.teacher_code"
					+ " and c.c_no = m.c_no";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<GmemberDTO> list = new ArrayList();
			GmemberDTO gmemberDto = null;
			if(rs != null) {
				while(rs.next()) {
					gmemberDto = new GmemberDTO();
					gmemberDto.setRegist_month(rs.getString(1));
					gmemberDto.setC_no(rs.getString(2));
					gmemberDto.setC_name(rs.getString(3));
					gmemberDto.setClass_name(rs.getString(4));
					gmemberDto.setClass_area(rs.getString(5));
					gmemberDto.setClass_price(rs.getInt(6));
					gmemberDto.setGrade(rs.getString(7));
					list.add(gmemberDto);
				}
			}
			rs.close();
			pstmt.close();
			return list;
		}
	
	public List<CostDTO> selectAllcost() throws Exception {
		String sql = "select t.teacher_code,t.class_name,t.teacher_name,sum(c.tuition)"
				+ " from tbl_teacher_202201 t"
				+ " join tbl_class_202201 c"
				+ " on t.teacher_code=c.teacher_code"
				+ " group by t.teacher_code, t.class_name, t.teacher_name"
				+ " order by t.teacher_code asc";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<CostDTO> list = new ArrayList();
		CostDTO costDto = null;
		if(rs != null) {
			while(rs.next()) {
				costDto = new CostDTO();
				costDto.setTeacher_code(rs.getString(1));
				costDto.setClass_name(rs.getString(2));
				costDto.setTeacher_name(rs.getString(3));
				costDto.setSum(rs.getInt(4));
				list.add(costDto);
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
	
	