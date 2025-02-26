package ch04;

import java.util.Scanner;

public class ch01Scanner {

	public static void main(String[] args) {
//		System.in : 표준입력 스트림 생성(요청)
//		System.out : 표준출력 스트림 생성(요청)
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("num1 입력 : ");
		
		int num1 = sc.nextInt();
		System.out.println("num2 입력 : ");
		
		int num2 = sc.nextInt();
		System.out.println("num3 입력 : ");
		
		int num3 = sc.nextInt();
		System.out.println("num4 입력 : ");
		
		int num4 = sc.nextInt();
		
		int sum = num1 + num2 + num3 + num4;
		System.out.printf("%d + %d + %d + %d = %d \n",num1,num2,num3,num4,sum);
		sc.close();
	}

}
