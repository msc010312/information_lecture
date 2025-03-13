package ch19;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
public class ch03copy {
	
	private static String FileDir = "C:\\IOtest\\";
	public static void main(String[] args) throws IOException { //args[0] 원본파일, args[1] 대상파일
		for(String arg : args) {
			System.out.println(arg);
		}
		
		Reader fin = new FileReader(FileDir + args[0]);
		Writer fout = new FileWriter(FileDir + args[1]);
		
		while(true) {
			int data = fin.read();
			if(data==-1) {
				break;
			}
			fout.write(data);
			fout.flush();
			
		}
		fin.close();
		fout.close();
		
	}

}
