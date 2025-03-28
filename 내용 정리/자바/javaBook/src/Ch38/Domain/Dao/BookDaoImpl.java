package Ch38.Domain.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Ch38.Domain.Dao.ConnectionPool.ConnectionItem;
import Ch38.Domain.Dao.ConnectionPool.ConnectionPool;
import Ch38.Domain.Dto.BookDto;

public class BookDaoImpl extends ConnectionDao implements BookDaoInterface {

	// 싱글톤 패턴처리
	private static BookDaoInterface instance;
	private BookDaoImpl() throws Exception{ // 예외처리를 컨트롤러 영역으로 넘겨줌
		
	};
	public static BookDaoInterface getInStance() throws Exception {
		if(instance == null) {
			instance = new BookDaoImpl();
		}
		return instance;
	}
	
	// CRUD
		@Override
		public int insert(BookDto bookdto) throws Exception {
			try {
				connectionItem = connectionPool.getConnection();
				Connection conn = connectionItem.getConn();
				pstmt = conn.prepareStatement("insert into tbl_book values(?,?,?,?)");
				pstmt.setString(1, bookdto.getBookCode());
				pstmt.setString(2, bookdto.getBookName());
				pstmt.setString(3, bookdto.getPublisher());
				pstmt.setString(4, bookdto.getIsbn());
				
				//Connection release
				connectionPool.releaseConnection(connectionItem);
				
				return pstmt.executeUpdate();
			} catch(SQLException e) {
				e.printStackTrace();
				throw new SQLException("bookdao insert 예외발생");
			} finally {
				try {pstmt.close();}catch(Exception e2) {}
			}
		}
		
		@Override
		public int update(BookDto bookdto) throws Exception {
			try {
				connectionItem = connectionPool.getConnection();
				Connection conn = connectionItem.getConn();
				pstmt = conn.prepareStatement("");
				//Connection release
				connectionPool.releaseConnection(connectionItem);
				return pstmt.executeUpdate();
			} catch(SQLException e) {
				e.printStackTrace();
				throw new SQLException("bookdao update 예외발생");
			} finally {
				try {pstmt.close();}catch(Exception e2) {}
			}
		}
		
		@Override
		public int delete(BookDto bookdto) throws Exception {
			try {
				connectionItem = connectionPool.getConnection();
				Connection conn = connectionItem.getConn();
				pstmt = conn.prepareStatement("");
				//Connection release
				connectionPool.releaseConnection(connectionItem);
				return pstmt.executeUpdate();
			} catch(SQLException e) {
				e.printStackTrace();
				throw new SQLException("bookdao delete 예외발생");
			} finally {
				try {pstmt.close();}catch(Exception e2) {}
			}
		}
		
		// 단일조회
		@Override
		public BookDto select(BookDto bookdto) {
			return null;
		}
		// 복수조회
		@Override
		public List<BookDto> selectAll() {
			return null;
		}

}
