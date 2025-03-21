package ch33;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@FunctionalInterface // 함수형 인터페이스 선언(컴파일러에 전달), 추상메서드를 하나만 허용한다
interface Func1 {
	void say1(String message);
}

@FunctionalInterface
interface Func2 {
	int sum(Integer... args);
}

@FunctionalInterface
interface Func3 {
	List<Integer> createListDesc(int... args);
}

public class ch01FunctionalInterface {

	public static void main(String[] args) {
		Func1 func1 = message -> System.out.println(message + "_!");
		func1.say1("HELLO WORLD");
		Func1 func1_2 = System.out::println;
		func1_2.say1("NICE DAY");

		Func2 func2 = (items) -> {
			int sum = 0;
			for (int i = 0; i < items.length; i++) {
				sum += items[i];
			}
			return sum;
		};

		System.out.println(func2.sum(10, 20, 30, 132, 1412, 532, 321));

		Func2 func2_2 = (items) -> {
			return Arrays.stream(items).reduce(0, (sum, el) -> sum + el);
		};

		System.out.println(func2_2.sum(10, 20, 30, 132, 1412, 532, 321));

		Func3 func3 = (items) -> {
			return Arrays.stream(items).boxed().sorted((x, y) -> y - x).collect(Collectors.toList());
		};
		List<Integer> list = func3.createListDesc(10,32,314,312,643,32);
		System.out.println(list);
	}

}
