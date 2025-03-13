package ch19;

import java.io.FileWriter;
import java.io.Writer;
import java.io.IOException;

public class ch01write {

	public static void main(String[] args) throws IOException {
//		Writer fout = new FileWriter("C:\\IOtest\\test1.txt",false); // 덮어쓰기
		Writer fout = new FileWriter("C:\\IOtest\\test1.txt",true); 
		fout.write("test1\n");
		fout.write("test2\n");
		fout.write("test3\n");
		fout.write("test4\n");
		fout.flush();
		fout.close();
	}

}
