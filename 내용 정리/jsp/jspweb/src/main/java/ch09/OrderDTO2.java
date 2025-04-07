package ch09;

import java.sql.Date;

public class OrderDTO2 {
	private Date orderDate;
	private Integer sum;
	public OrderDTO2() {}
	public OrderDTO2(Date orderDate, Integer sum) {
		super();
		this.orderDate = orderDate;
		this.sum = sum;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Integer getSum() {
		return sum;
	}
	public void setSum(Integer sum) {
		this.sum = sum;
	}
	@Override
	public String toString() {
		return "OrderDTO2 [orderDate=" + orderDate + ", sum=" + sum + "]";
	}
	
	
}
