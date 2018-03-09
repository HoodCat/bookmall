package com.cafe24.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.bookmall.vo.BookmallVo;

public abstract class Dao<V> {
	protected static final int PAGE_LIST_NUM = 100;
	protected Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost/bookmall";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패: " + e);
		}
		return conn;
	}
	
	public List<V> getList(){
		return getList(1, PAGE_LIST_NUM);
	}
	public List<V> getList(int page){
		return getList(page, PAGE_LIST_NUM);
	}
	public List<V> getList(int page, int limit){
		List<V> result = new ArrayList<>();
		Connection conn = null;
		
		try {
			conn = getConnection();			
			result = this.getListTask(conn, page, limit);
		} catch(SQLException e) {
			
		} finally {
			try {
				if(conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	abstract protected List<V> getListTask(Connection conn, int page, int limit) throws SQLException;
	abstract public boolean insertTask(BookmallVo vo);
}
