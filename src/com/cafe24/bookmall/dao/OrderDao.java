package com.cafe24.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.bookmall.vo.BookmallVo;
import com.cafe24.bookmall.vo.OrderVo;

public class OrderDao extends Dao<OrderVo> {
	@Override
	protected List<OrderVo> getListTask(Connection conn, int page, int limit) throws SQLException {
		List<OrderVo> result = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT no, order_no, tot_price, address, order_date, member_no FROM order ORDER BY no LIMIT ?, ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, (page-1) * limit);
		pstmt.setInt(2, limit);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			OrderVo vo = new OrderVo();
			Long no = rs.getLong(1);
			String orderNo = rs.getString(2);
			Long totPrice = rs.getLong(3);
			String address = rs.getString(4);
			String orderDate = rs.getString(5);
			Long memberNo = rs.getLong(6);
			
			vo.setNo(no);
			vo.setOrderNo(orderNo);
			vo.setTotPrice(totPrice);
			vo.setAddress(address);
			vo.setOrderDate(orderDate);
			vo.setMemberNo(memberNo);
			
			result.add(vo);
		}
		return null;
	}

	@Override
	public boolean insertTask(BookmallVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		if(vo instanceof OrderVo == false) {
			return false;
		}
		
		OrderVo memberVo = (OrderVo)vo;
		
		try {
			conn = getConnection();
			String sql = "INSERT INTO `order` VALUES(null, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVo.getOrderNo());
			pstmt.setLong(2, memberVo.getTotPrice());
			pstmt.setString(3, memberVo.getAddress());
			pstmt.setString(4, memberVo.getOrderDate());
			pstmt.setLong(5, memberVo.getMemberNo());
			
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
