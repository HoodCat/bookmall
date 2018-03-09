package com.cafe24.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.bookmall.vo.BookmallVo;
import com.cafe24.bookmall.vo.MemberVo;

public class MemberDao extends Dao<MemberVo> {
	@Override
	protected List<MemberVo> getListTask(Connection conn, int page, int limit) throws SQLException {
		List<MemberVo> result = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT no, name, phone, email, password FROM member ORDER BY no LIMIT ?, ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, (page-1) * limit);
		pstmt.setInt(2, limit);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			MemberVo vo = new MemberVo();
			Long no = rs.getLong(1);
			String name = rs.getString(2);
			String phone = rs.getString(3);
			String email = rs.getString(4);
			String password = rs.getString(5);
			
			vo.setNo(no);
			vo.setName(name);
			vo.setPhone(phone);
			vo.setEmail(email);
			vo.setPassword(password);
			
			result.add(vo);
		}
		return null;
	}
	@Override
	public boolean insertTask(BookmallVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		if(vo instanceof MemberVo == false) {
			return false;
		}
		
		MemberVo memberVo = (MemberVo)vo;
		
		try {
			conn = getConnection();
			String sql = "INSERT INTO member VALUES(null, ?, ?, ?, password(?))";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVo.getName());
			pstmt.setString(2, memberVo.getPhone());
			pstmt.setString(3, memberVo.getEmail());
			pstmt.setString(4, memberVo.getPassword());
			
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
