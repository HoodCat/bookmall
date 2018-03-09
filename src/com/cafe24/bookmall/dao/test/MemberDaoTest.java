package com.cafe24.bookmall.dao.test;

import com.cafe24.bookmall.dao.MemberDao;
import com.cafe24.bookmall.vo.MemberVo;

public class MemberDaoTest {
	public static void main(String[] args) {
		insertMemberTest();
		getListTest();
	}
	
	private static void insertMemberTest() {
		MemberVo vo = new MemberVo();
		vo.setName("박정제");
		vo.setEmail("thanatos0128@gmail.com");
		vo.setPassword("password");
		vo.setPhone("010-1234-5678");
		
		new MemberDao().insertTask(vo);
	}
	
	private static void getListTest() {
		MemberDao dao = new MemberDao();
		for(MemberVo vo: dao.getList()) {
			System.out.println(vo);
		}
	}
}
