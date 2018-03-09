package com.cafe24.bookmall.dao.test;

import com.cafe24.bookmall.dao.CartDao;
import com.cafe24.bookmall.vo.CartVo;

public class CartDaoTest {
	public static void main(String[] args) {
		insertCartTest();
		getListTest();
	}
	
	private static void insertCartTest() {
		CartVo vo = new CartVo(null, 10L, 2L, 5L);
		new CartDao().insertTask(vo);
	}
	
	private static void getListTest() {
		CartDao dao = new CartDao();
		for(CartVo vo: dao.getList()) {
			System.out.println(vo);
		}
	}
}
