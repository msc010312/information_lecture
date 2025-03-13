package ch19;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
public class ch04copy {
	
	public static void main(String[] args) throws IOException { //args[0] 원본파일, args[1] 대상파일
		
		Reader rd = new FileReader("C:\\IOtest\\test3.txt");
		int data = 0;
		
		char[] buf = new char[1024];
		
		StringBuffer buffer = new StringBuffer();
		long startTime = System.currentTimeMillis();
		while((data = rd.read(buf))!=-1) {
			buffer.append(buf);
//			buffer.append(data);
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println();
		System.out.println("소요시간 : " + (endTime-startTime) + "ms");
//		System.out.println(buffer);
		rd.close();
		
	}

}
