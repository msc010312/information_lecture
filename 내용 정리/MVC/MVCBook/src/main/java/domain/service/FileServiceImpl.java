package domain.service;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import controller.file.Properties;

public class FileServiceImpl {

	// 싱글톤 패턴
	private static FileServiceImpl instance;

	private FileServiceImpl() throws Exception {
		System.out.println("[SERVICE] FileServiceImpl init...");
	};

	public static FileServiceImpl getInstance() throws Exception {
		if (instance == null)
			instance = new FileServiceImpl();
		return instance;
	}

	public boolean upload(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		LocalDateTime now = LocalDateTime.now();
		String folderName = now.format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
		
		String uploadPath = Properties.ROOT+File.separator+Properties.UPLOAD_PATH+File.separator+folderName+File.separator;
		
		File dir = new File(uploadPath);
		if(!dir.exists())
			dir.mkdirs();
		
		Collection<Part> parts = req.getParts();
		for (Part part : parts) {
			System.out.println(part.getName());
			System.out.println(part.getSize());
			String contentDisp = part.getHeader("content-disposition");
			String [] tokens = contentDisp.split(";");
			String filename = tokens[2].trim().substring(10, tokens[2].trim().length()-1);
			System.out.println(contentDisp);
			System.out.println(tokens[2]);
			System.out.println(filename);
			
			part.write(uploadPath+filename);
		}
		
		return false;
	}

	public Map<String,List<File>> getFlieList() {
		
		Map<String,List<File>> map = new LinkedHashMap();
		
		String uploadPath = Properties.ROOT+File.separator+Properties.UPLOAD_PATH;
		File dir = new File(uploadPath);
		if(dir.exists()&&dir.isDirectory()) {
			File[] folders = dir.listFiles(); // 폴더 찾기
//			Arrays.stream(folders).forEach(System.out::println);
			for(File folder : folders) {
				File [] list = folder.listFiles(); // 폴더 내 파일
				System.out.println(folder.getName());
				Arrays.stream(list).forEach(System.out::println);
				map.put(folder.getName(), Arrays.stream(list).collect(Collectors.toList()));
			}
		}
		return map;
	}
}
