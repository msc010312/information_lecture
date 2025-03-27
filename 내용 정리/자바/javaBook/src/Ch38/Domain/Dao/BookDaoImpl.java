package Ch38.Domain.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Ch38.Domain.Dto.BookDto;

public class BookDaoImpl {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private String id = "root";
	private String pw = "1234";
	private String url = "jdbc:mysql://localhost:3306/bookdb";
	// 싱글톤 패턴처리
	private static BookDaoImpl instance;
	private BookDaoImpl() throws SQLException, ClassNotFoundException { // 예외처리를 컨트롤러 영역으로 넘겨줌
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url,id,pw);
		System.out.println("DB 연결완료");
	};
	public static BookDaoImpl getInStance() throws ClassNotFoundException, SQLException {
		if(instance == null) {
			instance = new BookDaoImpl();
		}
		return instance;
	}
	
	// CRUD
		public int insert(BookDto bookdto) throws SQLException {
			try {
				pstmt = conn.prepareStatement("insert into tbl_book values(?,?,?,?)");
				pstmt.setString(1, bookdto.getBookCode());
				pstmt.setString(2, bookdto.getBookName());
				pstmt.setString(3, bookdto.getPublisher());
				pstmt.setString(4, bookdto.getIsbn());
				return pstmt.executeUpdate();
			} catch(SQLException e) {
				e.printStackTrace();
				throw new SQLException("bookdao insert 예외발생");
			} finally {
				try {pstmt.close();}catch(Exception e2) {}
			}
		}
		
		public int update(BookDto bookdto) throws SQLException {
			try {
				pstmt = conn.prepareStatement("");
				return pstmt.executeUpdate();
			} catch(SQLException e) {
				e.printStackTrace();
				throw new SQLException("bookdao update 예외발생");
			} finally {
				try {pstmt.close();}catch(Exception e2) {}
			}
		}
		
		public int delete(BookDto bookdto) throws SQLException {
			try {
				pstmt = conn.prepareStatement("");
				return pstmt.executeUpdate();
			} catch(SQLException e) {
				e.printStackTrace();
				throw new SQLException("bookdao delete 예외발생");
			} finally {
				try {pstmt.close();}catch(Exception e2) {}
			}
		}
		
		// 단일조회
		public BookDto select(BookDto bookdto) {
			return null;
		}
		// 복수조회
		public List<BookDto> selectAll() {
			return null;
		}

}
