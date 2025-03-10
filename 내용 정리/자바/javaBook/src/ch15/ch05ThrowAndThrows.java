package ch15;

class A {
	public void Ex1() throws NullPointerException {
		System.out.println("ex process-1");
		throw new NullPointerException("ex1 null exception");
	}
}

class B {
	public void Ex2() throws NullPointerException {
		System.out.println("ex process-2");
		throw new NullPointerException("ex2 null exception");
	}
}


public class ch05ThrowAndThrows {
	// throw : 예외를 만들때 사용
	// throws : 예외를 던질때 사용
	public static void main(String[] args) {
		System.out.println("실행코드1");
		System.out.println("실행코드2");
		
		A a = new A();
		B b = new B();
		
		try {
		a.Ex1();
		b.Ex2();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("실행코드3");
	}

}
