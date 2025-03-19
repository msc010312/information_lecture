package ch24;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketServer {

	public static void main(String[] args) throws IOException, InterruptedException {
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
		
		ServerSendThread send = new ServerSendThread(dout);
		ServerReciveThread recv = new ServerReciveThread(din);
		
		Thread th1 = new Thread(send);
		Thread th2 = new Thread(recv);
		
		th1.start();
		th2.start();
		
		th1.join();
		th2.join();
		
		in.close();
		out.close();
		client.close();
		server.close();
		System.out.println("[Server] 연결 종료 합니다");
	}

}
