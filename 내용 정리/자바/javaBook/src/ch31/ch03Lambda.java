package ch31;

interface Calculator {
	int calculate(int num1, int num2);
}

public class ch03Lambda {

	public static void main(String[] args) {
		Calculator add = (num1, num2) -> num1 + num2;
		Calculator sub = (num1, num2) -> num1 > num2 ? num1 - num2 : num2 - num1;
		Calculator mul = (num1, num2) -> num1 * num2;
		Calculator div = (num1, num2) -> num1 > num2 ? num1 / num2 : num2 / num1;

		System.out.println(add.calculate(10, 20)); // 덧셈
		System.out.println(sub.calculate(30, 10)); // 뺄셈
		System.out.println(mul.calculate(30, 10)); // 곱셈
		System.out.println(div.calculate(30, 10)); // 나눗셈
	}

}
