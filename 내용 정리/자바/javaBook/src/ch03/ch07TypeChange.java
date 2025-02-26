package ch03;

public class ch07TypeChange {

	public static void main(String[] args) {
		// 문자열 + 문자열

//		System.out.println("문자열1" + "문자열2");
//		System.out.println("문자열1" + "문자열2");
//		System.out.println("문자열1" + "," + "문자열2");
//		System.out.println("문자열1" + 2);
//		System.out.println("문자열" + ',' + '!');
//		System.out.println(',' + '!' + "문자열");
//		System.out.println("문자열1" + "문자열2");
		
		// 문자열 -> 숫자형(정수)
		System.out.println("10"+"20");
		int n1 = Integer.parseInt("10");
		int n2 = Integer.parseInt("20");
		System.out.println(n1+n2);
		
		// 문자열 -> 숫자형(실수)
		double n3 = Double.parseDouble("10.5");
		double n4 = Double.parseDouble("20.4");
		System.out.println(n3+n4);
		
		short n5 = Short.parseShort("5");
		short n6 = Short.parseShort("6");
		System.out.println(n5+n6);
	}

}
