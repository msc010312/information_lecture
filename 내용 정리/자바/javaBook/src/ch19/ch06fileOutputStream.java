package ch19;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class ch06fileOutputStream {

	public static void main(String[] args) throws IOException {
		OutputStream out = new FileOutputStream("C:\\IOtest\\test4.txt");
		out.write("가".getBytes(StandardCharsets.UTF_8));
		out.write('a');
		out.write('b');
		out.write('c');
		
		
		out.flush();
		
		out.close();
	}

}
