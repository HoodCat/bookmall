package com.cafe24.bookmall.dao.test;

import com.cafe24.bookmall.dao.BookDao;
import com.cafe24.bookmall.vo.BookVo;

public class BookDaoTest {
	public static void main(String[] args) {
		insertBookTest();
		getListTest();
	}
	
	private static void insertBookTest() {
		BookDao dao = new BookDao();
		BookVo vo = new BookVo();
		vo.setTitle("연금술사");
		vo.setPrice(17000L);
		vo.setCategoryNo(1L);
		dao.insertTask(vo);
	}
	
	private static void getListTest() {
		BookDao dao = new BookDao();
		for(BookVo vo: dao.getList()) {
			System.out.println(vo);
		}
	}
}
