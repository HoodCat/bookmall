package com.cafe24.bookmall.dao.test;

import com.cafe24.bookmall.dao.CategoryDao;
import com.cafe24.bookmall.vo.CategoryVo;

public class CategoryDaoTest {
	public static void main(String[] args) {
		getListTest();
	}
	
	private static void getListTest() {
		CategoryDao dao = new CategoryDao();
		for(CategoryVo vo: dao.getList()) {
			System.out.println(vo);
		}
	}
}
