package ch07;

import java.util.Iterator;
import java.util.Scanner;

public class ch02while {
	public static void main(String[] args) {

		// 2단 - 9단 출력
//		int dan = 2;
//		while(dan<=9) {
//			int i = 1;
//			while(i<=9) {
//				System.out.printf("%d X %d = %d\n",dan,i,dan*i);
//				i++;
//			}
//			System.out.println();
//			dan++;
//		}

		// 2단 - 9단 출력 (2x9 - 2x8)
//		int dan = 2;
//		while(dan<=9) {
//			int i = 9;
//			while(i>=1) {
//				System.out.printf("%d X %d = %d\n",dan,i,dan*i);
//				i--;
//			}
//			System.out.println();
//			dan++;
//		}

		// 2단 - n단 출력
		Scanner sc = new Scanner(System.in);
//		System.out.println("몇단까지인지 입력하세요");
//  	int dan = sc.nextInt(); 
//		while(2<=dan) {
//			int i = 1;
//			while(i<=9) {
//				System.out.printf("%d X %d = %d\n",dan,i,dan*i);
//				i++;
//			}
//			System.out.println();
//			dan++;
//		}
//		sc.close();

		// n단 - n단 출력
//		System.out.println("몇단부터인지 입력하세요");
//		int danBase = sc.nextInt();
//		System.out.println("몇단까지인지 입력하세요");
//		int danFin = sc.nextInt();
//		while (danBase <= danFin) {
//			int i = 1;
//			while (i <= 9) {
//				System.out.printf("%d X %d = %d\n", danBase, i, danBase * i);
//				i++;
//			}
//			System.out.println();
//			danBase++;
//		}
//		sc.close();

		// 별찍기(기본높이:4)

		System.out.println("높이를 입력하세요");
		int h = sc.nextInt();

		// *****
		// *****
		// *****
		// *****
//		int i = 1;
//		while(i<=h) {
//			int j = 1;
//			while(j<=5) {
//				System.out.print("*");
//				j++;
//			}
//			System.out.println();
//			i++;
//		}

		// *
		// **
		// ***
		// ****
//		int i = 1;
//		while (i <= h) {
//			int j = 1;
//			while (j <= i) {
//				System.out.print("*");
//				j++;
//			}
//			System.out.println();
//			i++;
//		}

		// ****
		// ***
		// **
		// *
//		int i = 1;
//		while (i <= h) {
//			int j = h;
//			while (j >= i) {
//				System.out.print("*");
//				j--;
//			}
//			System.out.println();
//			i++;
//		}
		
		
		//   *
		//  ***
		// *****
		//*******
//		== while 버전 ==
//		int i = 1;
//		while (i <= h) {
//			int j = h - 1;
//			while (j >= i) {
//				System.out.print(" ");
//				j--;
//			}
//			int k = 1;
//			while (k <= 2 * i - 1) {
//				System.out.print("*");
//				k++;
//			}
//			System.out.println();
//			i++;
//		}
		
//		== for 버전 ==
//		for (int i = 1; i <= h; i++) {
//			for (int j = h-1; j >= i; j--) {
//				System.out.print(" ");
//			}
//			for (int k = 1; k <= 2*i-1; k++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		

		//*******
		// *****
		//  ***
		//   *
//		== while 버전 ==
//		int i = 1;
//		while (i <= h) {
//			int j = 1;
//			while (j <= i-1) {
//				System.out.print(" ");
//				j++;
//			}
//			int k = 2*h-1;
//			while (k >= 2 * i - 1) {
//				System.out.print("*");
//				k--;
//			}
//			System.out.println();
//			i++;
//		}
		
//		== for 버전 ==
//		for (int i = 1; i <= h; i++) {
//			for (int j = 1; j <= i-1; j++) {
//				System.out.print(" ");
//			}
//			for (int k = 2*h-1; k >= 2*i-1; k--) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		
		//   *
		//  ***
		// *****		
		//*******
		// *****
		//  ***
		//   *
//		== while 버전 ==
//		int i = 1;
//		while (i <= h-1) {
//			int j = h - 1;
//			while (j >= i) {
//				System.out.print(" ");
//				j--;
//			}
//			int k = 1;
//			while (k <= 2 * i - 1) {
//				System.out.print("*");
//				k++;
//			}
//			System.out.println();
//			i++;
//		}
//		i=1;
//		while (i <= h) {
//			int j = 1;
//			while (j <= i-1) {
//				System.out.print(" ");
//				j++;
//			}
//			int k = 2*h-1;
//			while (k >= 2 * i - 1) {
//				System.out.print("*");
//				k--;
//			}
//			System.out.println();
//			i++;
//		}
		
//		== for 버전 ==
//		for (int i = 1; i <= h-1; i++) {
//			for (int j = h - 1; j >= i; j--) {
//				System.out.print(" ");
//			}
//			for (int k = 1; k <= 2 * i - 1; k++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		for (int i = 1; i <= h; i++) {
//			for (int j = 1; j <= i - 1; j++) {
//				System.out.print(" ");
//			}
//			for (int k = 2 * h - 1; k >= 2 * i - 1; k--) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		//*******
		// *****
		//  ***
		//   *		
		//   *
		//  ***
		// *****		
		//*******
//		== while 버전 ==
//		int i = 1;
//		while (i <= h-1) {
//			int j = 1;
//			while (j <= i-1) {
//				System.out.print(" ");
//				j++;
//			}
//			int k = 2*h-1;
//			while (k >= 2 * i - 1) {
//				System.out.print("*");
//				k--;
//			}
//			System.out.println();
//			i++;
//		}
//		i=1;
//		while (i <= h) {
//			int j = h-1;
//			while (j >= i) {
//				System.out.print(" ");
//				j--;
//			}
//			int k = 1;
//			while (k <= 2 * i - 1) {
//				System.out.print("*");
//				k++;
//			}
//			System.out.println();
//			i++;
//		}
		
//		== for 버전 ==
//		for (int i = 1; i <= h; i++) {
//			for (int j = 1; j <= i - 1; j++) {
//				System.out.print(" ");
//			}
//			for (int k = 2 * h - 1; k >= 2 * i - 1; k--) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		for (int i = 1; i <= h; i++) {
//			for (int j = h - 1; j >= i; j--) {
//				System.out.print(" ");
//			}
//			for (int k = 1; k <= 2 * i - 1; k++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		// *
		// ***
		// *****
		// *******
//		int i = 1;
//		while (i<=h) {
//			int j = 1;
//			while(j<=2*i-1) {
//				System.out.print("*");
//				j++;
//			}
//			System.out.println();
//			i++;
//		}

		// *******
		// *****
		// ***
		// *
//		int i = 1;
//		while(i<=h) {
//			int j = 2*h-1;
//			while(j>=2*i-1) {
//				System.out.print("*");
//				j--;
//			}
//			System.out.println();
//			i++;
//		}

		// *
		// ***
		// *****
		// *******
		// *****
		// ***
		// *
//		int i = 1;
//		while(i<=h) {
//			int j = 1;
//			while(j<=2*i-1) {
//				System.out.print("*");
//				j++;
//			}
//			int k = 5;
//			while(k>=2*i-1) {
//				System.out.print("*");
//				k--;
//			}
//			System.out.println();
//			i++;
//		}

//		for (int i = 1; i <= h; i++) {
//			for (int j = 1; j <= 2 * i - 1; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		for (int i = 1; i <= h - 1; i++) {
//			for (int j = 2*h-3; j >= 2 * i - 1; j--) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}

		// *******
		// *****
		// ***
		// *
		// *
		// ***
		// *****
		// *******
//		for (int i = 1; i <= h; i++) {
//			for (int j = 2 * h - 1; j >= 2 * i - 1; j--) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		for (int i = 1; i <= h; i++) {
//			for (int j = 1; j <= 2 * i - 1; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}

	}
}
