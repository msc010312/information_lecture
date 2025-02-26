package ch04;

import java.util.Scanner;

public class ch03Scanner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.println("입력 된 정수값 : " + num1);
		
		sc.nextLine();
		
		System.out.println("문자열 입력");
		String str1 = sc.next();
		System.out.println("입력된 문자열 : " + str1);
	}
}
