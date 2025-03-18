package ch21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ch08Tx {
	// DB CONN DATA
	static String id = "root";
	static String pw = "1234";
	static String url = "jdbc:mysql://localhost:3306/testdb";

	// JDBC참조변수
	static Connection conn = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loading Success...");
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("DB CONNECTED...");
			
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement("insert into tbl_std values('a','1','b')");
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("insert into tbl_std values('b','1','b')");
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("insert into tbl_std values('c','1','b')");
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("insert into tbl_std values('d','1','b')");
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("insert into tbl_std values('e','1','b')");
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("insert into tbl_std values('f','1','b')");
			pstmt.executeUpdate();
			conn.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			try{conn.rollback();}catch(Exception e3) {}
		} finally {
			try{pstmt.close();}catch(Exception e2) {}
			try{conn.close();}catch(Exception e3) {}
		}
	}

}
