package ch12;

class Super {
	int n1;
}

class Sub extends Super{
	int n2;
}


public class ch06upDownCasting {

	public static void main(String[] args) {
		// NoCasting (자료형의 일치)
		Super ob1 = new Super();
		ob1.n1 = 10;
		Sub ob2 = new Sub();
		ob2.n1 = 10;
		ob2.n2 = 20;
		
		// UpCasting (상위클래스 참조변수 = 하위클래스형 객체)(자동형변환)
		// 상위클래스가 이해하는 범위내에서 사용가능
		// 상속관계로 연결된 모든 하위객체를 연결할 수 있다
		Super ob3 = new Sub();
		ob3.n1 = 100;
		Super ob4 = ob2;
		ob4.n1 = 110;
		
		// DownCasting (하위클래스 참조변수 = 상위클래스형 객체)(강제형변환)
		// UpCasting이 되어있는 객체만 가능
//		Sub ob5 = (Sub)ob1; // ob1은 Super만을 가르키기 때문에 Sub클래스로 DownCasting이 불가능하다
		Sub ob6 = (Sub)ob3; // ob3의 자료형은 Super지만 Sub클래스를 가르키기때문에 DownCasting이 가능하다
		
	}

}
