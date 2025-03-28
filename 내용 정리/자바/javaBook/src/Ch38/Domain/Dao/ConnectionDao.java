package Ch38.Domain.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Ch38.Domain.Dao.ConnectionPool.ConnectionItem;
import Ch38.Domain.Dao.ConnectionPool.ConnectionPool;

public abstract class ConnectionDao {
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	
	// ConnectionPool 연결
	protected ConnectionPool connectionPool;
	protected ConnectionItem connectionItem;
	public ConnectionDao() throws Exception{
		connectionPool = ConnectionPool.getInstance();
	}
}
