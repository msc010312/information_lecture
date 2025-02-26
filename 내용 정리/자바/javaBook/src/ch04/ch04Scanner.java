package ch04;

import java.util.Scanner;

public class ch04Scanner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

//		System.out.println("첫번째 수 : ");
//		int num1 = sc.nextInt();
//		
//		System.out.println("두번째 수 : ");
//		int num2 = sc.nextInt();
//		
//		int result = num1 + num2;
//		
//		System.out.println("덧셈결과 : " + result);

		System.out.println("[필수 정보 입력]");
		System.out.println("이름을 입력하세요 : ");
		String name = sc.nextLine();

		System.out.println("주민번호 앞 6자리를 입력하세요 : ");
		String id = sc.nextLine();

		System.out.println("전화번호를 입력하세요 : ");
		String phoneNum = sc.nextLine();

		System.out.println("[입력한 내용]");
		
		System.out.println("이름 : " + name);
		System.out.println("주민번호 : " + id);
		System.out.println("PH : " + phoneNum);

	}
}
