package com.cafe24.bookmall.vo;

public class MemberVo implements BookmallVo{
	private Long no;
	private String name;
	private String phone;
	private String email;
	private String password;
	
	public MemberVo() {}
	public MemberVo(Long no, String name, String phone, String email, String password) {
		this.no = no;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.password = password;
	}
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "MemberVo [no=" + no + ", name=" + name + ", phone=" + phone + ", email=" + email + ", password="
		        + password + "]";
	}
}
