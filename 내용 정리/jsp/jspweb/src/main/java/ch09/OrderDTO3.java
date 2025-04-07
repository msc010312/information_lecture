package ch09;

import java.sql.Date;

public class OrderDTO3 {
	private String addr;
	private Date orderDate;
	private int totalAmount;
	public OrderDTO3() {}
	public OrderDTO3(String addr, Date orderDate, int totalAmount) {
		super();
		this.addr = addr;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	@Override
	public String toString() {
		return "OrderDTO3 [addr=" + addr + ", orderDate=" + orderDate + ", totalAmount=" + totalAmount + "]";
	}
}
