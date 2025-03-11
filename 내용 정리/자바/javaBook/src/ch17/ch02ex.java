package ch17;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ch02ex {
	public static void func1(List<String> list) {
		// ArrayList에 있는 정수값을 입력받는데 전달되는 수중에
		// 짝수의 값만 입력받는 코드를 작성하세요.
		Scanner sc = new Scanner(System.in);
		System.out.println("짝수를 입력하세요 / 종료 = exit");
		while (true) {
			String input = sc.nextLine();
			if (input.equalsIgnoreCase("exit")) {
				break;
			} try{
				int num = Integer.parseInt(input);
				if (num % 2 == 0) {
					list.add(Integer.toString(num));
				} else {
					System.out.println("짝수만 가능합니다");
				}
			} catch (Exception e) {
				System.out.println("유효한 숫자를 입력하세요");
			}
		}
		list.forEach(System.out::println);
	}

	public static List<String> func2(List<String> list) {
		// ArrayList에 있는 문자열 중에서 길이가 5보다 큰 문자열만 필터링해서 리턴하는 함수를 만드세요
		list.add("HTML/CSS/JS");
		list.add("JQUERY");
		list.add("NODEJS");
		list.add("111");
		list.add("222");
		list.add("333");
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).length() > 5) {
				System.out.println(list.get(i));
			}
		}
		return list; // 바꿔주세요 작업시
	}

	public static int func3(List<String> list) {
		// ArrayList에 있는 문자열 중에서 숫자형 데이터만 추출해서 합을 구해보세요

		return -1; // 바꿔주세요 작업시
	}

	public static void main(String[] args) {
		List<String> li = new ArrayList();
		func1(li);
		List<String> returndList = func2(li);
		int sum = func3(returndList);
		System.out.println(sum);
	}
}
