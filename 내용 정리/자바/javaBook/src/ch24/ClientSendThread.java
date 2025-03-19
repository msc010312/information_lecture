package ch24;

import java.io.DataOutputStream;
import java.util.Scanner;

public class ClientSendThread implements Runnable {
	DataOutputStream dout;
	Scanner sc = new Scanner(System.in);

	ClientSendThread(DataOutputStream dout) {
		this.dout = dout;
	}

	@Override
	public void run() {
		String send;
		try {
			while (true) {
				// 서버 -> 클라이언트 송신
				System.out.print("[Client(q:종료)] : ");
				send = sc.nextLine();
				if (send.equals("q")) {
					break;
				}
				dout.writeUTF(send);
				dout.flush();
			}
		} catch (Exception e) {
			System.out.println("예외 발생 ClientSendThread 종료");
		} finally {
			try {
				dout.close();
			} catch (Exception e2) {
			}
		}
	}

}
