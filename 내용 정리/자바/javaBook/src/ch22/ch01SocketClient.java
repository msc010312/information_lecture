package ch22;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ch01SocketClient {

	public static void main(String[] args) throws IOException {
		Socket client = new Socket("192.168.16.203",7000);
		
		InputStream in = client.getInputStream();
		DataInputStream din = new DataInputStream(in);
		String recv = din.readUTF();
		System.out.println(recv);
		
		din.close();
		in.close();
		client.close();
	}

}
