package ch19;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class ch07fileCopy {

	public static void main(String[] args) throws Exception {

		InputStream in = new FileInputStream("C:\\IOtest\\data.zip");
		OutputStream out = new FileOutputStream("C:\\IOtest\\data_copy.zip");

		// 버퍼미사용
//		System.out.println("진행중");
//		while(true) {
//			int data = in.read();
//			if(data == -1) {
//				break;
//			}
//			out.write((byte)data);
//			out.flush();
//		}
//		in.close();
//		out.close();
//		System.out.println("완료");
		
		// 버퍼사용
		System.out.println("진행중");
		byte[] buf = new byte[4096];
		while (true) {
			int data = in.read(buf);
			if (data == -1) {
				break;
			}
//			out.write((byte)data);
			out.write(buf, 0, data);
			out.flush();
		}
		in.close();
		out.close();
		System.out.println("완료");
	}

}
