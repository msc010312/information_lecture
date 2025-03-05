package ch09;

public class ch05StringClass {
public static void main(String[] args) {
	String str1 = "java Powerful";
	String str2 = new String("java Powerful");
	String str3 = str1 + str2;
	String str4 = str1.concat(str2);
	
	// 해시코드(주소)
	System.out.printf("%X\n",System.identityHashCode(str1));
	System.out.printf("%X\n",System.identityHashCode(str2));
	System.out.printf("%X\n",System.identityHashCode(str3));
	System.out.printf("%X\n",System.identityHashCode(str4));
	
	System.out.println("--------------------------------");
	
	String str = "";
	for (int i = 0; i < 10; i++) {
		str +=i;
		System.out.println("str : " + str);
		System.out.printf("위치 : %x\n",System.identityHashCode(str));
		System.out.println("--------------------------------");
	}
	
}
}
