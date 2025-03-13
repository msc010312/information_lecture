package ch19;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ch02reader {

	public static void main(String[] args) throws IOException {
		Reader rd = new FileReader("C:\\IOtest\\test1.txt");
		int data = 0;
		StringBuffer buffer = new StringBuffer();
		while((data = rd.read())!=-1) {
			buffer.append(data);
		}
		System.out.println();
		System.out.println(buffer);
		rd.close();
	}

}
