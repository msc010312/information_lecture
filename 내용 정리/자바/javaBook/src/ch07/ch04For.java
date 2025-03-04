package ch07;

import java.util.Scanner;

public class ch04For {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("높이를 입력하세요");
		int h = sc.nextInt();
//		for (int i = 1; i <= 10; i++) {
//			System.out.printf("hello world %d\n",i);
//		}

		for (int i = 1; i <= h; i++) {
			for (int j = h - 1; j >= i; j--) {
				System.out.print(" ");
			}
			for (int k = 1; k <= 2 * i - 1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
