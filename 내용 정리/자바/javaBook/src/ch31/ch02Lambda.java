package ch31;

import java.util.Scanner;

interface Printer {
//	void print1(String message);
//	String print2(String message);
	String print3();
}

public class ch02Lambda {

	public static void main(String[] args) {
		// 01
//		Printer printer = (message)->{System.out.println(message);};
//		printer.print1("hello wolrd");

		// 02
//		Printer printer = (message)->{System.out.print(message); return "_Hello wolrd"; };
//		Printer printer = (message)-> message + "_Hello wolrd"; // 약식입력
//		String returnValue = printer.print2("TEST");
//		System.out.println(returnValue);

		// 03

		Printer printer = () -> {
			Scanner sc = new Scanner(System.in);
			System.out.println("메세지 입력");
			String val = sc.nextLine();
			sc.close();
			return val;
		};
		String printVal = printer.print3();
		System.out.println(printVal);

	}

}
