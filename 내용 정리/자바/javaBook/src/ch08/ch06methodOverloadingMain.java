package ch08;

class methodOver {
	void func(int n1, int n2) {
		System.out.println(n1+n2);
	}
	
	void func(int n1, int n2, int n3) {
		System.out.println(n1+n2+n3);
	}
	
	void func(String item) {
		System.out.printf("%s입니다",item);
	}
}

public class ch06methodOverloadingMain {

	public static void main(String[] args) {
		methodOver mo = new methodOver();
		mo.func(10, 20);
		mo.func(10, 20, 30);
		mo.func("바나나");
	}

}
