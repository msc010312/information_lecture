package ch08;

// 맴버변수 		: 클래스내부 ~ 매서드영역 바깥에서 생성
//				  생성된 객체의 개별 정보 저장

// static변수 	: 동일 클래스로부터 만든 여러객체간 공유하는 변수

// 지역변수 		: 매서드 영역내(파라미터도 포함)에서 혹은 {}범위에 생성되는 변수 

class ch05simple {
	int num = 10;

	void func1() {
		System.out.println("맴버변수 : " + num);
		int num = 5;
		System.out.println("지역변수 : " + num);
		this.num++;
	}

	void func2() {
		System.out.println("맴버변수 : " + num);
		if (true) {
			int num = 100;
			System.out.println("func2 지역변수 : " + num);
		}
		while(num<15) {
			System.out.println("맴버변수 : " + num);
			num++;
		}
	}
	
	void func3(int num) {
		num++;
		System.out.println("func3 지역변수 : " + num);
	}
	
}

public class ch05localValMain {

	public static void main(String[] args) {
		ch05simple sp = new ch05simple();
		sp.func1();
		sp.func2();
		sp.func3(5);

	}

}
