package ch12;

class pen {
	private int amount;
	private String color;
	
	public pen() {
		
	}
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
}

class SharpPen extends pen {
	private int width;
	
	public SharpPen() {
		
	}
}

class Ballpen extends pen {
	
	public Ballpen() {
		
	}
	
}

class Fountainpen extends pen {
	public Fountainpen() {
		
	}
	
	public void refill(int n) {
		setAmount(n);
	}
}

public class ch04ex2 {

	public static void main(String[] args) {
		

	}

}
