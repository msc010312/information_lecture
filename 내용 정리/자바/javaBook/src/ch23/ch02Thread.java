package ch23;

public class ch02Thread {

	public static void main(String[] args) {
		// Runnable Interface 스레드 분할
		
		// 객체 생성
		ch02Worker1 w1 = new ch02Worker1();
		ch02Worker2 w2 = new ch02Worker2();
		
		// 메인 스레드에서 분리
		Thread th1 = new Thread(w1);
		Thread th2 = new Thread(w2);
		
		// 스레드 실행
		th1.start();
		th2.start();
		
		// Thread class 스레드 분할
		
		new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("task 3");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		}.start();
		
		for (int i = 0; i < 5; i++) {
			System.out.println("main task");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
