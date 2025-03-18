package ch23;

public class ch03Worker1 implements Runnable {
	C03GUI gui;

	ch03Worker1(C03GUI gui) {
		this.gui = gui;
	}

	@Override
	public void run() {
		while (true) {
			try {
				gui.area1.append("WORKER01\n");
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}
		}
		System.out.println("worker1 interrupted");
	}

}
