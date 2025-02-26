package ch03;

public class ch04TypeChange {
	public static void main(String[] args) {
		// 정수연산자
		// int로 자동형변환
		byte x = 10;
		byte y = 20;

//		byte result1 = (byte) (x + y);
		int result1 = x + y;

		System.out.println(result1);

		
		// 정수연산식(int 보다 큰 변수 자료형(long))
		// 큰 타입으로 자동형변환
		byte var1 = 10;
		int var2 = 100;
		long var3 = 1000L;
		
//		int result2 = (int)(var1+var2+var3);
		long result2 = var1 + var2 + var3;
		System.out.println(result2);
		
		// 실수연삭식
		// 큰 타입으로 자동형변환
		int intvar = 10;
		float flvar = 3.3F;
		double dbvar = 5.5;
		int result3 = (int)(intvar + flvar + dbvar); // 18
//		float result3 = (float)(intvar + flvar + dbvar); // 18.8
//		double result3 = intvar + flvar + dbvar;
		System.out.println(result3);
		
	}
}
