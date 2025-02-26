package ch05;

import java.util.Scanner;

public class ch02연산자문제 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 1.문제(삼항연산자)
		// 키보드로 국어/영어/수학 점수를 입력받아 각각의부분점수가 40점이상이고
		// 총점수 평균이 70점이상이면 '합격'
		// 미만이면 '불합격'을 출력합니다
		
		
//		System.out.println("국어 점수를 입력하세요");
//		int korea = sc.nextInt();
//		System.out.println("영어 점수를 입력하세요");
//		int eng = sc.nextInt();
//		System.out.println("수학 점수를 입력하세요");
//		int math = sc.nextInt();
//
//		int result1 = (korea + eng + math) / 3;
//
//		String result2 = (korea >= 40 && eng >= 40 && math >= 40 && result1 >= 70) ? "합격" : "불합격";
//
//		System.out.println(result2);
//		sc.close();

		// 2.미니문제(%연산자)
		// 키보드로 부터 정수값 2 를 입력받아
		// 두수의 합이 짝수이면 "짝수입니다"
		// 홀수이면 "홀수입니다" 를 출력하세요~

		System.out.println("숫자를 입력하세요");
		int num1 = sc.nextInt();
		System.out.println("숫자를 입력하세요");
		int num2 = sc.nextInt();
		
		int sum = num1 + num2;

		String result = sum % 2 == 0 ? "짝입니다" : "홀입니다";
		System.out.println(result);
		
		sc.close();

		// 3.문제
		// 국어 / 영어 / 수학 점수를 입력받아서
		// 국어 점수가 40점이상
		// 영어 점수가 40점이상
		// 수학 점수가 40점이상이면서 전체평균이 60점이상이면 합격을 출력
		// 아니면 불합격을 출력하세요
		// 삼항연산자와 논리연산자를 이용합니다. }
	}
}
