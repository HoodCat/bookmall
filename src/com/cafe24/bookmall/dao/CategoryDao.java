package com.cafe24.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.bookmall.vo.BookmallVo;
import com.cafe24.bookmall.vo.CategoryVo;

public class CategoryDao extends Dao<CategoryVo>{
	@Override
	protected List<CategoryVo> getListTask(Connection conn, int page, int limit) throws SQLException {
		List<CategoryVo> result = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select no, name from category";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			CategoryVo vo = new CategoryVo();
			Long no = rs.getLong(1);
			String name = rs.getString(2);
			vo.setNo(no);
			vo.setName(name);
			result.add(vo);
		}
		return result;
	}

	@Override
	public boolean insertTask(BookmallVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		if(vo instanceof CategoryVo == false) {
			return false;
		}
		CategoryVo categoryVo = (CategoryVo) vo;
		
		try {
			conn = getConnection();
			String sql = "INSERT INTO category VALUES(null, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, categoryVo.getName());
			int count = pstmt.executeUpdate();
			result = (count==1);
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			
		}
		return result;
	}
}
