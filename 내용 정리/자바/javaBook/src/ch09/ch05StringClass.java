package ch09;

public class ch05StringClass {
	public static void main(String[] args) {
		String str1 = "java Powerful";
		String str2 = new String("java Powerful");
		String str3 = str1 + str2;
		String str4 = str1.concat(str2);

		// 해시코드(주소)
		System.out.printf("%X\n", System.identityHashCode(str1));
		System.out.printf("%X\n", System.identityHashCode(str2));
		System.out.printf("%X\n", System.identityHashCode(str3));
		System.out.printf("%X\n", System.identityHashCode(str4));

		System.out.println("--------------------------------");

		String str = "";
		for (int i = 0; i < 10; i++) {
			str += i;
			System.out.println("str : " + str);
			System.out.printf("위치 : %x\n", System.identityHashCode(str));
			System.out.println("--------------------------------");
		}

		System.out.println("문자열 길이 : " + str1.length());
		System.out.println("한 문자 찾기 : " + str1.charAt(2));

		System.out.println("인덱스 찾기 : " + str1.indexOf('a')); //앞에서 부터
		System.out.println("인덱스 찾기 : " + str1.lastIndexOf('a')); //뒤에서 부터

		System.out.println("문자열 포함 여부 : " + str1.contains("va")); //boolean형 배출

		System.out.println("문자열 자르기 : " + (str1.substring(2, 6))); // 2~6까지 자름

		String str6 = "등산,탁구,축구,골프,독서,영화감상";
		String[] result = str6.split(",");
		for (String hobby : result) {
			System.out.println(hobby);
		}

	}
}
