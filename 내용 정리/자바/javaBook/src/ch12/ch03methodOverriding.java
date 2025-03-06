package ch12;


// 함수 재정의
// 상속관계를 전제로 상위클래스의 메서드를 하위클래스가 재정의
// 하위클래스에서 다른기능구현이 가능함

// 오버로딩 vs 오버라이딩
// 오버로딩 : 상속전제 X, 함수헤더변경(반환자료형-고정, 함수명-고정, 파라미터-변동), 개발자의 편의성에 중점
// 오버라이딩 : 상속전제 O, 함수로직변경(헤더고정), 다형성이 목적
class Animal{
	void sound() {
		System.out.println("소리낸다");
	}
}

class Dog extends Animal {
	@Override
	void sound() {
		System.out.println("멍멍");
	}
}

class Cat extends Animal {
	@Override
	void sound() {
		System.out.println("야옹");
	}
}
public class ch03methodOverriding {

	public static void main(String[] args) {
		Animal ani = new Animal();
		Dog dog = new Dog();
		Cat cat = new Cat();
		dog.sound();
		cat.sound();
		ani.sound();
		System.out.println("---------------------");
		ani = dog; // 상위클래스 참조변수에 하위객체 Dog연결
		ani.sound();
		ani = cat; // 상위클래스 참조변수에 하위객체 Cat연결
		ani.sound();
	}

}
