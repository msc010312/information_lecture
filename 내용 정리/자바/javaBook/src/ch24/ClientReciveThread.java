package ch24;

import java.io.DataInputStream;

public class ClientReciveThread implements Runnable {

	DataInputStream din;

	ClientReciveThread(DataInputStream din) {
		this.din = din;
	}

	@Override
	public void run() {
		String recv;
		try {
			while (true) {
				// 클라이언트 -> 서버 수신
				recv = din.readUTF();
				if (recv.equals("q")) {
					break;
				}
				System.out.println("[Client ] : " + recv);
			}

		} catch (Exception e) {
			System.out.println("예외 발생 ClientReciveThread 종료");
		} finally {
			try {
				din.close();
			} catch (Exception e2) {
			}
		}
	}

}
