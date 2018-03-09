package com.cafe24.bookmall.vo;

public class CartVo implements BookmallVo{
	private Long no;
	private Long quantity;
	private Long memberNo;
	private Long bookNo;
	
	public CartVo() {}
	public CartVo(Long no, Long quantity, Long memberNo, Long bookNo) {
		this.no = no;
		this.quantity = quantity;
		this.memberNo = memberNo;
		this.bookNo = bookNo;
	}
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}
	public Long getBookNo() {
		return bookNo;
	}
	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}
	
	@Override
	public String toString() {
		return "CartVo [no=" + no + ", quantity=" + quantity + ", memberNo=" + memberNo + ", bookNo=" + bookNo + "]";
	}
}
