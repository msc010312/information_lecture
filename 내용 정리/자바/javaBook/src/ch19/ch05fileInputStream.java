package ch19;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ch05fileInputStream {

	public static void main(String[] args) throws IOException {
		InputStream fin = new FileInputStream("C:\\IOtest\\data.xlsx");
		StringBuffer stringBuffer = new StringBuffer();
//		long sTime = System.currentTimeMillis();
//		while(true) {
//			int data = fin.read();
//			if(data == -1) break;
//			
////			System.out.print((char)data);
//		}
//		long eTime = System.currentTimeMillis();
//		System.out.println("소요시간 : " + (eTime-sTime) + "ms");
//		fin.close();
		
		// read([])
		byte[] buf = new byte[4096];
		long sTime = System.currentTimeMillis();
		while(true) {
			int data = fin.read(buf);
			if(data == -1) break;
			
//			System.out.print((char)data);
		}
		long eTime = System.currentTimeMillis();
		System.out.println("소요시간 : " + (eTime-sTime) + "ms");
		fin.close();
	}

}
