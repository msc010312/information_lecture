package ch06;

import java.util.Scanner;

public class ch02Switch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int ranking = sc.nextInt();
		char medalColor;
		switch (ranking) {
		case 1:
			medalColor = 'g';
			System.out.println("매달색상 : g");
			break;
		case 2:
			medalColor = 's';
			System.out.println("매달색상 : s");
			break;
		case 3:
			medalColor = 'b';
			System.out.println("매달색상 : b");
			break;
		default:
			medalColor = 'c';
			System.out.println("매달색상 : c");
		}
		System.out.println(ranking + "등 매달 색은 " + medalColor + "입니다");
	}
}
