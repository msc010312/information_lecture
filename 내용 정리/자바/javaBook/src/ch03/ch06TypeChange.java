package ch03;

public class ch06TypeChange {

	public static void main(String[] args) {
//		short vs char
//		char과 short는 같은 2byte 사이즈를 가지나
//		short는 양,음수를 지원 / char는 양수만 지원한다
//		short char간의 데이터교환시 동일한 값을 저장하더라도
//		표현하는 범위가 다르기 때문에 각각 다른값이 나올수도 있다.
		
		
		char n1 = 60000;
		short n2 = (short)n1;
		System.out.println(n2);
		
		int n3 = (char)n1;
		System.out.println(n3);
	}

}
