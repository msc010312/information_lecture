package ch33;

@FunctionalInterface // 함수형 인터페이스 선언(컴파일러에 전달), 추상메서드를 하나만 허용한다
interface Func1 {
	void say1(String message);
}

public class ch01FunctionalInterface {

	public static void main(String[] args) {
		Func1 func1 = message->System.out.println(message + "_!");
		func1.say1("HELLO WORLD");
		Func1 func2 = System.out::println;
		func2.say1("NICE DAY");
	}

}
