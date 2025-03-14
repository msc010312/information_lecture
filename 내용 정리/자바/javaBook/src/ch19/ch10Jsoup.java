package ch19;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.UUID;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ch10Jsoup {

	public static void main(String[] args) throws IOException, URISyntaxException {
		// URL 연결
		Connection conn = Jsoup.connect("https://www.op.gg/champions");

		// DOM객체 받기
		Document dc = conn.get();
//		System.out.println(dc);

		Elements em = dc.getElementsByTag("img");
//		System.out.println(em);

		for (Element el : em) {
			try {
//			System.out.println(el);
			String imgURL = el.getElementsByAttribute("src").attr("src");
			System.out.println(imgURL);

			URL url = new URI(imgURL).toURL();
			InputStream in = url.openStream();
			BufferedInputStream buffIn = new BufferedInputStream(in); // 버퍼공간추가
			OutputStream out = null;
			if(imgURL.contains(".png")) {
			out = new FileOutputStream("C:\\IOtest\\" + UUID.randomUUID() + ".png");
			} else if(imgURL.contains(".svg")){
				out = new FileOutputStream("C:\\IOtest\\" + UUID.randomUUID() + ".svg");
			} else if(imgURL.contains(".webp")) {
				out = new FileOutputStream("C:\\IOtest\\" + UUID.randomUUID() + ".webp");
			} else {
				out = new FileOutputStream("C:\\IOtest\\" + UUID.randomUUID() + ".jpg");
			}
			//버퍼 추가
			while(true) {
				int data = buffIn.read();
				if(data == -1) {
					break;
				}
				out.write((byte)data);
				out.flush();
			}
			out.close();
			buffIn.close();
			in.close();
			
			} catch(Exception e) {
				
			}
		}
	}

}
