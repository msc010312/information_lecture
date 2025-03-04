package ch07;

import java.util.Scanner;

public class ch03ContinueBreak {
	public static void main(String[] args) {

		// 1. break
		Scanner sc = new Scanner(System.in);
//		int n;
//		int sum = 0;
//		while (true) {
//			n = sc.nextInt();
//			if (n == -1) {
//				break;
//			}
//			sum += n;
//		}
//		System.out.println(sum);
//
//		sc.close();
		
		// 반복문 탈출 : flag
//		boolean flag = false;
//		int dan = 2;
//		while(dan<=9) {
//			int i = 1;
//			while(i<=9) {
//				System.out.printf("%d X %d = %d\n",dan,i,dan*i);
//				if(dan==7 && i==7) {
//					flag = true;
//					break;
//				}
//				i++;
//			}
//			if(flag) {
//				break;
//			}
//			System.out.println();
//			dan++;
//		}
		
		// 반복문 탈출 : exit
//		int dan = 2;
//		Exit : 
//		while(dan<=9) {
//			int i = 1;
//			while(i<=9) {
//				System.out.printf("%d X %d = %d\n",dan,i,dan*i);
//				if(dan==7 && i==7) {
//					break Exit;
//				}
//				i++;
//			}
//			System.out.println();
//			dan++;
//		}
		
		// 2. continue
		
		int i = 1;
		int sum = 0;
		while(i<=10) {
			if(i%3==0) {
				i++;
				continue;
			}
			System.out.println("i : " + i);
			sum+=i;
			i++;
		}
		System.out.println("sum : " + sum);
	}
}
