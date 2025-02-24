package ch01;

public class ch01SystemOut {
	public static void main(String[] args) {
		// System.out.print()
		// \n : 줄바꿈
		// \b : 백스페이스
		// \t : 탭길이(만큼 커서 이동)
		System.out.print("hello world\n");
		
		// System.out.printf()
		// %d : 10진수 정수 서식문자
		// %f : 10진수 실수 서식문자
		// %c : 한문자 서식문자
		// %s : 문자열 서식문자
		System.out.printf("%d %d %d \n",10,20,30);
		System.out.printf("%f %f %f \n",10.1,20.2,30.3);
		System.out.printf("%c %c %c \n",'a','b','c');
		System.out.printf("%s %s %s \n","this is","string","test");
		System.out.printf("%d.%s : %d\n",1,"국어",100);
		
		// System.out.println()
		System.out.println("hello wolrd");
		System.out.println("hello wolrd");
		System.out.println("hello wolrd");
	}
}
