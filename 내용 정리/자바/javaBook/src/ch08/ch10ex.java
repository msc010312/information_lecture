package ch08;

class Person {
	private int mymoney;
	private int applecnt;

	public Person(int mymoney, int applecnt) {
		super();
		this.mymoney = mymoney;
		this.applecnt = applecnt;
	}

	@Override
	public String toString() {
		return "Person [mymoney=" + mymoney + ", applecnt=" + applecnt + "]";
	}

	public int getMymoney() {
		return mymoney;
	}

	public void setMymoney(int mymoney) {
		this.mymoney = mymoney;
	}

	public int getApplecnt() {
		return applecnt;
	}

	public void setApplecnt(int applecnt) {
		this.applecnt = applecnt;
	}

}

class Buyer extends Person {
	public Buyer(int mymoney, int applecnt) {
		super(mymoney, applecnt);
	}

	@Override
	public String toString() {
		return "Buyer [mymoney=" + getMymoney() + ", Applecnt=" + getApplecnt() + "]";
	}

	public void payment(Seller seller, int money) {
		// 내 보유금액에서 차감
		// seller에 money를 전달하고 리턴되는 사과 개수를 누적
		int gm = getMymoney();
		gm -= money;
		setMymoney(gm);
		
		int ab = money / seller.getPrice();
		int ac = getApplecnt();
		ac += ab;	
		setApplecnt(ac);
		
		seller.receive(money);
	}
}

class Seller extends Person {
	public int price;

	public Seller(int mymoney, int applecnt, int price) {
		super(mymoney, applecnt);
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Seller [price=" + price + ", mymoney=" + getMymoney() + ", Applecnt=" + getApplecnt() + "]";
	}

	public int receive(int money) {
		// 구매자로부터 전달받은 money를 내보유금액에 누적
		// 전달받은금액/사과개수 를 리턴
		int gm = getMymoney();
        gm += money;
        setMymoney(gm);
        
        int as = money / price;
        int ac = getApplecnt();
        ac -= as;
        setApplecnt(ac);

        return money;
	}
}

public class ch10ex {

	public static void main(String[] args) {
		Seller sell = new Seller(100000,100,1000);
		Buyer buy1 = new Buyer(10000,0);
		Buyer buy2 = new Buyer(5000,0);
		
		buy1.payment(sell, 5000);
		buy2.payment(sell, 2000);
		
		System.out.println(buy1);
		System.out.println(buy2);
		System.out.println(sell);
		
	}

}
