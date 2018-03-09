package com.cafe24.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.bookmall.vo.BookVo;
import com.cafe24.bookmall.vo.BookmallVo;

public class BookDao extends Dao<BookVo>{
	@Override
	protected List<BookVo> getListTask(Connection conn, int page, int limit) throws SQLException {
		List<BookVo> result = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select no, title, price, category_no from book order by no asc limit ?, ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, (page-1)*limit);
		pstmt.setLong(2, limit);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			BookVo vo = new BookVo();
			Long no = rs.getLong(1);
			String title = rs.getString(2);
			Long price = rs.getLong(3);
			Long categoryNo = rs.getLong(4);
			
			vo.setNo(no);
			vo.setTitle(title);
			vo.setPrice(price);
			vo.setCategoryNo(categoryNo);
			
			result.add(vo);
		}
		return result;
	}

	@Override
	public boolean insertTask(BookmallVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		if(vo instanceof BookVo == false) {
			return false;
		}
		
		BookVo bookVo = (BookVo)vo;
		
		try {
			conn = getConnection();
			String sql = "insert into book values(null, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookVo.getTitle());
			pstmt.setLong(2, bookVo.getPrice());
			pstmt.setLong(3, bookVo.getCategoryNo());
			
			int count = pstmt.executeUpdate();
			result = (count == 1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt !=null && !pstmt.isClosed()) {
					pstmt.close();
				}
				
				if(conn != null && !pstmt.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	
}
