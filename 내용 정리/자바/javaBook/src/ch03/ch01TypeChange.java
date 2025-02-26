package ch03;

public class ch01TypeChange {

	public static void main(String[] args) {
		// 형변환 : 연산시 일치하지않는 자료를 일치시키는 작업
		
		// 자동형변환 : 컴파일러에 의해 자동 형변환
		// 강제형변환 : 프로그래머에 의해 강제 형병환
		
		// 범위가 넓은 공간에 작은값이 대입되는 경우 자동형변환이 일어난다
		// byte > short,char > int > long > float > double
		// ex ) byte a = 10;
		// 		int b = a;
		
		byte byteVal = 10;
		int intVal = byteVal;
		System.out.println(intVal);
		
		char charVal = '가';
		intVal = charVal;
		System.out.println(intVal);
		
		intVal = 50;
		long longVal = intVal;
		System.out.println(longVal);
		
		longVal = 100;
		float floatVal = longVal;
		System.out.println(floatVal);
		
		floatVal = 100.5F;
		double doubleVal = floatVal;
		System.out.println(doubleVal);
	}

}
