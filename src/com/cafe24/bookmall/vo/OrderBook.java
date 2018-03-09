package com.cafe24.bookmall.vo;

public class OrderBook implements BookmallVo{
	private Long no;
	private Long quntity;
	private Long orderNo;
	private Long bookNo;
	
	public OrderBook() {}
	public OrderBook(Long no, Long quntity, Long orderNo, Long bookNo) {
		this.no = no;
		this.quntity = quntity;
		this.orderNo = orderNo;
		this.bookNo = bookNo;
	}
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getQuntity() {
		return quntity;
	}
	public void setQuntity(Long quntity) {
		this.quntity = quntity;
	}
	public Long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}
	public Long getBookNo() {
		return bookNo;
	}
	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}
	@Override
	public String toString() {
		return "OrderBook [no=" + no + ", quntity=" + quntity + ", orderNo=" + orderNo + ", bookNo=" + bookNo + "]";
	}
}
