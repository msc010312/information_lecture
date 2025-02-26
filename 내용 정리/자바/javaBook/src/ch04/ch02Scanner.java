package ch04;

import java.util.Scanner;

public class ch02Scanner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.println("입력 된 정수값 : " + num1);

		System.out.println("실수 입력 : ");
		double num2 = sc.nextDouble();
		System.out.println("입력된 실수값 : " + num2);

		System.out.println("문자열 입력");
		String str1 = sc.next();
		System.out.println("입력된 문자열 : " + str1);
		
		System.out.println("문자열 입력(띄어쓰기 포함)");
		String str2 = sc.nextLine();
		System.out.println("입력된 문자열 : " + str2);
		
		System.out.println("입력 : ");
		String st1 = sc.next();
		String st2 = sc.next();
		String st3 = sc.next();

		System.out.printf("문자열 : %s %s %s\n", st1, st2, st3);
		sc.close();
		
		
	}

}
