package ch35;

import java.util.Scanner;

import ch35.Building.Barrack;

public class Main2 {
	static Barrack barrack;

	public static void main(String[] args) {

		new Thread() {
			@Override
			public void run() {
				barrack = new Barrack();
				barrack.BuildStructure();
			}
		}.start();
		Scanner sc = new Scanner(System.in);
		int num = 0;
		while (true) {
			System.out.println("1 마린 생성");
			System.out.println("2 매딕 생성");
			System.out.println("3 종료");
			System.out.print("입력 : ");
			num = sc.nextInt();
			switch (num) {
			case 1:
				barrack.getMarine();
				break;
			case 2:
				barrack.getMedic();
				break;
			case 3:
				break;
			default:
			}
		}
	}

}
