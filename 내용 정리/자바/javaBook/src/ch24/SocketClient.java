package ch24;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketClient {

	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		Socket client = new Socket("192.168.16.50", 7000);

		System.out.println("client start");
		
		OutputStream out = client.getOutputStream();
		DataOutputStream dout = new DataOutputStream(out);
		InputStream in = client.getInputStream();
		DataInputStream din = new DataInputStream(in);

		ClientSendThread send = new ClientSendThread(dout);
		ClientReciveThread recv = new ClientReciveThread(din);
		
		Thread th1 = new Thread(send);
		Thread th2 = new Thread(recv);
		
		th1.start();
		th2.start();
		
		th1.join();
		th2.join();
		
		in.close();
		out.close();
		client.close();
		System.out.println("[Client] 연결 종료 합니다");
	}

}
