package domain.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

import domain.DTO.ReplyDTO;

public class BookReplyDaoImpl extends Dao{
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
				try {pstmt.close();} catch (Exception e2) {}
				// Connection release
				connectionPool.releaseConnection(connectionItem);
			}
		}
}
