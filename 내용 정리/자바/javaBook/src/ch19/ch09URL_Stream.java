package ch19;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URI;
import java.net.URL;

public class ch09URL_Stream {

	public static void main(String[] args) throws Exception {
		URL url = new URI("https://n.news.naver.com/mnews/article/022/0004018509").toURL();
		InputStream in = url.openStream();

		// 보조스트림 추가
		BufferedInputStream buffIn = new BufferedInputStream(in); // 버퍼공간추가
		Reader rin = new InputStreamReader(buffIn); // byte -> char 변환

		Writer out = new FileWriter("C:\\IOtest\\index.html");
//		OutputStream out = new FileOutputStream("C:\\IOtest\\index.html");

		while (true) {
			int data = rin.read();
			if (data == -1) {
				break;
			}
			System.out.print((char) data);
			out.write((char)data);
			out.flush();
		}
		rin.close();
		buffIn.close();
		in.close();
		out.close();
	}

}
