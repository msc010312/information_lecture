package domain.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import domain.DAO.connectionPool.ConnectionItem;
import domain.DAO.connectionPool.ConnectionPool;

public abstract class Dao {
	
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	
	protected ConnectionPool connectionPool;
	protected ConnectionItem connectionItem;
	public Dao() throws Exception{
		//connectionPool
		connectionPool =ConnectionPool.getInstance();
	}
	
}
