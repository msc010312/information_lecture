package domain.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.DAO.connectionPool.ConnectionItem;
import domain.DAO.connectionPool.ConnectionPool;
import domain.DTO.BookDTO;
import domain.DTO.UserDTO;

public class BookDaoImpl implements BookDao {
	//DB Attr
//	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
//	private String id="root";
//	private String pw="1234";
//	private String url="jdbc:mysql://localhost:3306/bookDB";
	
	private ConnectionPool connectionPool;
	private ConnectionItem connectionItem;
	
	
	//싱글톤
	
	private static BookDao instance;
	private BookDaoImpl() throws ClassNotFoundException, SQLException {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		conn = DriverManager.getConnection(url,id,pw);
		connectionPool = ConnectionPool.getInstance();
		System.out.println("UserDaoImpl DB Connection Success");
		
	};
	public static BookDao getInstance() throws ClassNotFoundException, SQLException {
		if(instance==null)
			instance = new BookDaoImpl();
		return instance;
	}
	
	//CRUD 
	 
	@Override
	public int insert(BookDTO bookDto) throws Exception {
		try {
			//connection  get
			connectionItem = connectionPool.getConnection();
			Connection conn = connectionItem.getConn();
			
			pstmt = conn.prepareStatement("insert into tbl_book values(?,?,?,?)");
			pstmt.setString(1, bookDto.getBookCode());
			pstmt.setString(2, bookDto.getBookName());
			pstmt.setString(3, bookDto.getPublisher());
			pstmt.setString(4, bookDto.getIsbn());
			
			//connection release
			connectionPool.releaseConnection(connectionItem);
			
			return pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("BOOKDAO's INSERT SQL EXCEPTION!!");
		}finally {
			try {pstmt.close();}catch(Exception e2) {}
		}
	}
	
 
	@Override
	public int update(BookDTO bookDto) throws SQLException {
		return 0;
	}
 
	@Override
	public int delete(BookDTO bookDto) throws SQLException {
		return 0;
	}
	//단건조회
 
	@Override
	public UserDTO select(BookDTO bookDto) throws SQLException{	
		return null;
	}
	//다건조회
 
	@Override
	public List<BookDTO> selectAll() throws Exception{
		try {
		//connection  get
		connectionItem = connectionPool.getConnection();
		Connection conn = connectionItem.getConn();
		String sql = "select * from tbl_book";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<BookDTO> list = new ArrayList();
		BookDTO bookdto = null;
		if(rs != null) {
			while(rs.next()) {
				bookdto = new BookDTO();
				bookdto.setBookCode(rs.getString(1));
				bookdto.setBookName(rs.getString(2));
				bookdto.setPublisher(rs.getString(3));
				bookdto.setIsbn(rs.getString(4));
				list.add(bookdto);
			}
		}
		return list;

		} catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("BOOKDAO's SELECT SQL EXCEPTION!!");
		}finally {
			try {rs.close(); pstmt.close();}catch(Exception e2) {}
			//connection release
			connectionPool.releaseConnection(connectionItem);
		}
	}
	@Override
	public List<BookDTO> selectAll(int offset, int amount) throws Exception {
		try {
			//connection  get
			connectionItem = connectionPool.getConnection();
			Connection conn = connectionItem.getConn();
			String sql = "SELECT * FROM TBL_BOOK order by bookcode desc limit ?,?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, offset);
			pstmt.setInt(2, amount);
			rs = pstmt.executeQuery();
			List<BookDTO> list = new ArrayList();
			BookDTO bookdto = null;
			if(rs != null) {
				while(rs.next()) {
					bookdto = new BookDTO();
					bookdto.setBookCode(rs.getString(1));
					bookdto.setBookName(rs.getString(2));
					bookdto.setPublisher(rs.getString(3));
					bookdto.setIsbn(rs.getString(4));
					list.add(bookdto);
				}
			}
			return list;

			} catch(SQLException e) {
				e.printStackTrace();
				throw new SQLException("BOOKDAO's SELECT SQL EXCEPTION!!");
			}finally {
				try {rs.close(); pstmt.close();}catch(Exception e2) {}
				//connection release
				connectionPool.releaseConnection(connectionItem);
			}
		}
	
		@Override
		public long count() throws Exception{
			long count=0;
			try {
				//connection  get
				connectionItem = connectionPool.getConnection();
				Connection conn = connectionItem.getConn();
				String sql = "SELECT COUNT(*) FROM TBL_BOOK";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if(rs != null && rs.next()) {
					count = rs.getLong(1);
				}
				return count;

				} catch(SQLException e) {
					e.printStackTrace();
					throw new SQLException("BOOKDAO's SELECT SQL EXCEPTION!!");
				}finally {
					try {rs.close(); pstmt.close();}catch(Exception e2) {}
					//connection release
					connectionPool.releaseConnection(connectionItem);
				}
		}
}




