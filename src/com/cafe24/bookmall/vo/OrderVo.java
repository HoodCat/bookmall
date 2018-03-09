package com.cafe24.bookmall.vo;

public class OrderVo implements BookmallVo{
	private Long no;
	private String orderNo;
	private Long totPrice;
	private String address;
	private String orderDate;
	private Long memberNo;
	
	public OrderVo() {}
	public OrderVo(Long no, String orderNo, Long totPrice, String address, String orderDate, Long memberNo) {
		super();
		this.no = no;
		this.orderNo = orderNo;
		this.totPrice = totPrice;
		this.address = address;
		this.orderDate = orderDate;
		this.memberNo = memberNo;
	}

	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public Long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}
	public Long getTotPrice() {
		return totPrice;
	}
	public void setTotPrice(Long totPrice) {
		this.totPrice = totPrice;
	}
	@Override
	public String toString() {
		return "OrderVo [no=" + no + ", orderNo=" + orderNo + ", address=" + address + ", orderDate=" + orderDate
		        + ", memberNo=" + memberNo + "]";
	}
}
