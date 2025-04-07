package ch09;

import java.time.LocalDate;

public class OrderDTO {
	private String category;
	private Integer sum;
	public OrderDTO() {}
	public OrderDTO(String category, Integer sum) {
		super();
		this.category = category;
		this.sum = sum;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getSum() {
		return sum;
	}
	public void setSum(Integer sum) {
		this.sum = sum;
	}
	@Override
	public String toString() {
		return "OrderDTO [category=" + category + ", sum=" + sum + "]";
	}
	
	
}
