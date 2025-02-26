package ch03;

public class ch05TypeChange {

	public static void main(String[] args) {
		// 나누는 대상이 int형이기에 2.0이 나옴
		int num1 = 10, num2 = 4;
		double dnum1 = (double)num1 / num2;
		double dnum2 = (num1*1.0) / num2;
		double dnum3 = num1 / num2;
		System.out.println(dnum1);
		System.out.println(dnum2);
		System.out.println(dnum3);
	}

}
