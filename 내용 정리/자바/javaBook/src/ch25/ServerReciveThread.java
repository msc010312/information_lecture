package ch25;

import java.io.DataInputStream;

public class ServerReciveThread implements Runnable {

	DataInputStream din;
	Sgui gui;

	ServerReciveThread(DataInputStream din, Sgui gui) {
		this.din = din;
		this.gui = gui;
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
//				System.out.println("[Client ] : " + recv);
				gui.area.append("[Client ] : " + recv + "\n");
			}

		} catch (Exception e) {
			System.out.println("예외 발생 ServerReciveThread 종료");
		} finally {
			try {
				din.close();
			} catch (Exception e2) {
			}
		}
	}

}
