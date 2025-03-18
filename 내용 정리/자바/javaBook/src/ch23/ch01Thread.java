package ch23;

public class ch01Thread {

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 5; i++) {
			System.out.println("task 1");
			Thread.sleep(500);
		}
		for (int i = 0; i < 5; i++) {
			System.out.println("task 2");
			Thread.sleep(500);
		}
	}

}
