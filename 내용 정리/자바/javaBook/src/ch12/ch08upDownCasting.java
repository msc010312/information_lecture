package ch12;

class c08Super {
	void func1() {
		System.out.println("super.func1 call");
	}
	
	void func2() {
		
	}
}

class c08Sub extends c08Super {
	@Override
	void func2() {
		System.out.println("sub.func2 call");
	}
}

public class ch08upDownCasting {

	public static void main(String[] args) {
		c08Super ob1 = new c08Super(); // NoCasing
		ob1.func1();
		System.out.println("------------");
		c08Sub ob2 = new c08Sub(); // NoCasting
		ob2.func1();
		ob2.func2();
		System.out.println("-------------");
		c08Super ob3 = new c08Sub(); // UpCasting
		ob3.func1();
		ob3.func2(); // 오버라이딩된 메서드
		
		System.out.println("-------------");
		// 만약 c08Super에 func2메서드가 없다면 DownCasting처리해야함
		c08Super ob4 = new c08Sub();
		c08Sub ob5 = (c08Sub)ob4;
		ob5.func1();
		ob5.func2();
		
	}

}
