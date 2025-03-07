package ch13;

// 일반 클래스 상속관계
class Super1 {
	void func() {} // 이미 완성된 메서드기에 Sub1의 오버라이드된 메서드를 주석처리하여도 문제없음
}

class Sub1 extends Super1 {
//	@Override
//	void func() {
//		System.out.println("override sub1.func() call");
//	}
}

// 추상클래스 상속관계
abstract class Super2{
	abstract void func(); // 추상메서드기 때문에 Sub2의 오버라이드된 메서드를 정의해야함
}

class Sub2 extends Super2{
	@Override
	void func() {
		System.out.println("override sub2.func() call");
	}
}

public class ch01abstract {

	public static void main(String[] args) {
		Super1 s1 = new Sub1();
		s1.func();
		
//		Super2 s2 = new Super2(); // 추상클래스여서 객체생성 불가능
//		Sub2 s2 = new Sub2(); // 하위클래스로 객체생성은 가능하지만 추상메서드를 정의해야함
		Super2 s2 = new Sub2();
		s2.func();
	}

}
