package com.cafe24.bookmall.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.cafe24.bookmall.vo.BookmallVo;

public class OrderBookDao extends Dao{
	@Override
	protected List getListTask(Connection conn, int page, int limit) throws SQLException {
		return null;
	}

	@Override
	public boolean insertTask(BookmallVo vo) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
