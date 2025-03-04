package ch08;

import java.util.Scanner;

class methodTest {
	Scanner sc = new Scanner(System.in);
	
	public int sum1(int n1, int n2) {
		return n1+n2;
	}
	
	public int sum2() {
		return sc.nextInt() + sc.nextInt();
	}
	
	public void sum3(int n1, int n2) {
		System.out.println(n1 + n2);
	}
	
	public void sum4() {
		System.out.println(sc.nextInt() + sc.nextInt());
	}
}

public class ch04methodMain {

	public static void main(String[] args) {
		
		methodTest mt = new methodTest();
		System.out.println(mt.sum1(10, 20));
		System.out.println(mt.sum2());
		mt.sum3(20, 30);
		mt.sum4();
	}

}
