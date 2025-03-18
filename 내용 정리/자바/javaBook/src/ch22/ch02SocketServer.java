package ch22;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ch02SocketServer {

	public static void main(String[] args) throws IOException {
		// 서버소켓 생성
		ServerSocket server = new ServerSocket(7000); // 192.168.16.6
		System.out.println("[INFO] SERVER SOCKET LISTENING");
		
		Socket client = server.accept();
		
		System.out.println("server start");
		
		System.out.println(client.getInetAddress());
		
		OutputStream out = client.getOutputStream();
		DataOutputStream dout = new DataOutputStream(out);
		InputStream in = client.getInputStream();
		DataInputStream din = new DataInputStream(in);
		
		// 내용교환(q:종료)
		Scanner sc = new Scanner(System.in);
		String recv = null;
		String send = null;
		
		while(true) {
			// 서버 -> 클라이언트 송신
			System.out.print("[Server(q:종료)] : ");
			send = sc.nextLine();
			if(send.equals("q")) {
				break;
			}
			dout.writeUTF(send);
			dout.flush();
			
			// 클라이언트 -> 서버 수신
			recv = din.readUTF();
			if(recv.equals("q")) {
				break;
			}
			System.out.println("[Client ] : " + recv);
		}
		din.close();
		dout.close();
		in.close();
		out.close();
		client.close();
		server.close();
		System.out.println("[Server] 연결 종료 합니다");
	}

}
