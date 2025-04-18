package domain.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import domain.DTO.BookDTO;
import domain.DTO.Criteria;
import domain.DTO.ReplyDTO;

public class BookReplyDaoImpl extends Dao {
	// 싱글톤 패턴처리
	private static BookReplyDaoImpl instance;

	private BookReplyDaoImpl() throws Exception {
		System.out.println("[DAO] UserDaoImpl init...");
	};

	public static BookReplyDaoImpl getInstance() throws Exception {
		if (instance == null)
			instance = new BookReplyDaoImpl();
		return instance;
	}

	public int insert(ReplyDTO replyDto) throws Exception {
		try {
			connectionItem = connectionPool.getConnection();
			Connection conn = connectionItem.getConn();

			pstmt = conn.prepareStatement("insert into tbl_reply values(null,?,?,?,?)");
			pstmt.setString(1, replyDto.getBookcode());
			pstmt.setString(2, replyDto.getUsername());
			pstmt.setString(3, replyDto.getContent());
			pstmt.setTimestamp(4, Timestamp.valueOf(replyDto.getCreateAt()));

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("replydao INSERT SQL EXCEPTION!!");
		} finally {
			try {
				pstmt.close();
			} catch (Exception e2) {
			}
			// Connection release
			connectionPool.releaseConnection(connectionItem);
		}
	}
	
	public List<ReplyDTO> selectAll(String bookCode) throws Exception {
		try {
			// connection get
			connectionItem = connectionPool.getConnection();
			Connection conn = connectionItem.getConn();
			String sql = "select * from tbl_reply where bookCode=? order by no desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookCode);
			rs = pstmt.executeQuery();
			List<ReplyDTO> list = new ArrayList();
			ReplyDTO replydto = null;
			if (rs != null) {
				while (rs.next()) {
					replydto = new ReplyDTO();
					replydto.setNo(rs.getInt(1));
					replydto.setBookcode(rs.getString(2));
					replydto.setUsername(rs.getString(3));
					replydto.setContent(rs.getString(4));
					replydto.setCreateAt(rs.getTimestamp(5).toLocalDateTime());
					list.add(replydto);
				}
			}
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("BOOKDAO's SELECT SQL EXCEPTION!!");
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (Exception e2) {
			}
			// connection release
			connectionPool.releaseConnection(connectionItem);
		}
	}
	
	public long count(String bookCode) throws Exception {
		long count=0;
		try {
			//connection  get
			connectionItem = connectionPool.getConnection();
			Connection conn = connectionItem.getConn();
			String sql = "SELECT COUNT(*) FROM tbl_reply where bookCode=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookCode);
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
