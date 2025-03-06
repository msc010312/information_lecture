package ch10;

public class ch05mainParam {
	public static void main(String[] args) {
		System.out.println("length : " + args.length);
		for (String param : args) {
			System.out.println(param);
		}
	}
}
