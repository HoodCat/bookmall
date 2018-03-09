package com.cafe24.bookmall.vo;

public class CategoryVo implements BookmallVo{
	private Long no;
	private String name;
	public CategoryVo() {}
	public CategoryVo(Long no, String name) {
		this.no = no;
		this.name = name;
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
	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", name=" + name + "]";
	}
}
