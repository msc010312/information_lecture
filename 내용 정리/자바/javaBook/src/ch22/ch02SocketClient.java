package ch22;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ch02SocketClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client = new Socket("192.168.16.50", 7000);

		System.out.println("client start");
		
		OutputStream out = client.getOutputStream();
		DataOutputStream dout = new DataOutputStream(out);
		InputStream in = client.getInputStream();
		DataInputStream din = new DataInputStream(in);

		// 내용교환(q:종료)
		Scanner sc = new Scanner(System.in);
		String recv = null;
		String send = null;

		while (true) {
			// 클라이언트 -> 서버 수신
			recv = din.readUTF();
			if (recv.equals("q")) {
				break;
			}
			System.out.println("[Server ] : " + recv);

			// 서버 -> 클라이언트 송신
			System.out.print("[Client(q:종료)] : ");
			send = sc.nextLine();
			if (send.equals("q")) {
				break;
			}
			dout.writeUTF(send);
			dout.flush();
		}
		din.close();
		dout.close();
		in.close();
		out.close();
		client.close();
		System.out.println("[Client] 연결 종료 합니다");
	}

}
