package ch15;

public class ch01NullPointerException {

	public static void main(String[] args) {
		try {
		String str = null; //NullPointerException - 없는값을 참조
		System.out.println(str.toString());
		} catch(NullPointerException e) {
			System.out.println("예외 발생 : " + e);
			System.out.println(e.getCause()); // 예외 이유 출력
			System.out.println(e.toString()); // 예외 메시지 출력
//			System.out.println(e.getStackTrace());
			e.printStackTrace(); // 예외 정보 출력
		}
		System.out.println("hello world");
	}

}
