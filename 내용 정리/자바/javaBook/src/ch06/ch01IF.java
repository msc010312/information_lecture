package ch06;

import java.util.Scanner;

public class ch01IF {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 단순 if
//		System.out.println("나이 : ");
//		int age = sc.nextInt();
//		if(age >= 8) {
//			System.out.println("학교에 다닙니다");
//		}
//		if(age < 8) {
//			System.out.println("학교에 다니지 않습니다");
//		}
//		System.out.println("프로그램을 종료합니다");

		// else
//		System.out.println("나이 : ");
//		int age = sc.nextInt();
//		if(age >= 8) {
//			System.out.println("학교에 다닙니다");
//		} else {
//			System.out.println("학교에 다니지 않습니다");
//		}
//		
//		sc.close();

//		int age = sc.nextInt();
//		if(age%3 == 0) {
//			System.out.println("3의배수입니다");
//		}
//		if(age%3 == 0 && age%5 == 0) {
//			System.out.println("3과 5의배수입니다");
//		}		
//		if(age%3 == 0) {
//			System.out.println("3의 배수입니다");
//			if(age%5 == 0) {
//				System.out.println("5의 배수입니다");
//			}
//		} else {
//			System.out.println("3의 배수가 아닙니다");
//		}

		// 2번
//		System.out.println("값 : ");
//		int num1 = sc.nextInt();
//		System.out.println("값 : ");
//		int num2 = sc.nextInt();	
//		
//		if(num1>num2) {
//			System.out.printf("두 값중 큰 수는 %d입니다\n",num1);
//		} else if(num1<num2) {
//			System.out.printf("두 값중 큰 수는 %d입니다\n",num2);
//		} else {
//			System.out.println("두 숫자의 값은 같습니다");
//		}
//		
//		System.out.println("값 : ");
//		int num3 = sc.nextInt();
//		
//		if(num1>num2 && num1>num3) {
//			System.out.printf("제일 큰 수는 %d입니다\n",num1);
//		} else if(num2>num1 && num2>num3) {
//			System.out.printf("제일 큰 수는 %d입니다\n",num2);
//		} else if(num3>num1 && num3>num2){
//			System.out.printf("제일 큰 수는 %d입니다\n",num3);
//		} else {
//			System.out.println("세 숫자의 값은 같습니다");
//		}
//		
//		
//		int result = num1 + num2 + num3;
//		System.out.printf("총합은 %d입니다\n",result);
//		System.out.printf("평균은 %d입니다\n",result/3);
//		
//		if(result%2 == 0) {
//			if(result%3 == 0) {
//				System.out.printf("%d은(는) 짝수이며 3의 배수입니다",result);
//			} else {
//				System.out.printf("결과는 %d입니다",result);
//			}
//		} else {
//			if(result%5 == 0) {
//				System.out.printf("%d은(는) 홀수이며 5의 배수입니다",result);
//			} else {
//				System.out.printf("결과값은 %d입니다",result);
//			}
//		}

//		int kor = sc.nextInt();
//		int eng = sc.nextInt();
//		int math = sc.nextInt();
//		double avg = (double) (kor + eng + math) / 3;
//
//		if (kor < 40) {
//			System.out.println("불합격");
//		} else if (eng < 40) {
//			System.out.println("불합격");
//		} else if (math < 40) {
//			System.out.println("불합격");
//		} else {
//			System.out.println("합격");
//		}
//		System.out.println(avg);
//
		
		
		System.out.println("점수를 입력하세요 : ");
		int score = sc.nextInt();
		if(score>=90) {
			System.out.println("A");
		} else if(score>=80) {
			System.out.println("B");
		} else if(score>=70) {
			System.out.println("C");
		} else if(score>=60) {
			System.out.println("D");
		} else {
			System.out.println("F");
		}
		
		System.out.println("나이를 입력하세요 : ");
		int age = sc.nextInt();
		if(age<8) {
			System.out.println("1000원");
		} else if(age<14) {
			System.out.println("2000원");
		} else if(age<20) {
			System.out.println("2500원");
		} else {
			System.out.println("3000원");
		}
		sc.close();

	}
}
