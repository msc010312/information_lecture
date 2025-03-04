package ch09;

public class ch04StringClass {

	public static void main(String[] args) {
		String str1 = "java";
		String str2 = "java";
		String str3 = new String("java");
		String str4 = new String("java");
		
		// 해시코드(주소)
		System.out.printf("%X\n",System.identityHashCode(str1));
		System.out.printf("%X\n",System.identityHashCode(str2));
		System.out.printf("%X\n",System.identityHashCode(str3));
		System.out.printf("%X\n",System.identityHashCode(str4));
		
		// 주소값비교
		System.out.println("------------------------------");
		System.out.println("str1==str2 ? " + (str1==str2));
		System.out.println("str3==str4 ? " + (str3==str4));
		System.out.println("str1==str3 ? " + (str1==str3));
		System.out.println("str2==str4 ? " + (str2==str4));
		
		// 문자열비교
		System.out.println("------------------------------");
		System.out.println("str1==str2 ? " + (str1.equals(str2)));
		System.out.println("str1==str2 ? " + (str3.equals(str4)));
		System.out.println("str1==str2 ? " + (str1.equals(str3)));
		System.out.println("str1==str2 ? " + (str2.equals(str4)));
	}

}
