package com.cafe24.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.bookmall.vo.BookmallVo;
import com.cafe24.bookmall.vo.CartVo;

public class CartDao extends Dao<CartVo> {
	@Override
	protected List<CartVo> getListTask(Connection conn, int page, int limit) throws SQLException {
		List<CartVo> result = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT no, quantity, member_no, book_no FROM cart ORDER BY no LIMIT ?, ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, (page-1) * limit);
		pstmt.setInt(2, limit);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			CartVo vo = new CartVo();
			Long no = rs.getLong(1);
			Long quantity = rs.getLong(2);
			Long memberNo = rs.getLong(3);
			Long bookNo = rs.getLong(4);
			
			vo.setNo(no);
			vo.setQuantity(quantity);
			vo.setMemberNo(memberNo);
			vo.setBookNo(bookNo);
			
			result.add(vo);
		}
		return result;
	}
	@Override
	public boolean insertTask(BookmallVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		if(vo instanceof CartVo == false) {
			return false;
		}
		
		CartVo cartVo = (CartVo)vo;
		
		try {
			conn = getConnection();
			String sql = "insert into cart values(null, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, cartVo.getQuantity());
			pstmt.setLong(2, cartVo.getMemberNo());
			pstmt.setLong(3, cartVo.getBookNo());
			
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
