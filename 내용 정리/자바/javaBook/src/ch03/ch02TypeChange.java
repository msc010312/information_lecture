package ch03;

public class ch02TypeChange {
	public static void main(String[] args) {
		//강제형변환
//		좁은범위공간에 큰값을 넣으려고 하는 경우
//		기본적으로 불가능하기 때문에 강제로 자료형을 바꾸어 전달한다
//		데이터 손실의 염려가 있다
		
		int intVal = 44032;
		char charVal  = (char)intVal;
		System.out.println((int)charVal);
		
		long longVal = 500;
		intVal = (int)longVal;
		System.out.println(intVal);
		
		double doubleVal = 3.14;
		intVal = (int)doubleVal;
		System.out.println(intVal);
	}
}
