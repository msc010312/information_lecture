package ch07;

import java.util.ArrayList;
import java.util.List;

public class ch05기타반복처리 {

	public static void main(String[] args) {
		List<String> lists = new ArrayList();
		lists.add("java");
		lists.add("jsp/servlet");
		lists.add("spring sts");
		lists.add("springboot");
		lists.add("react");
		lists.add("oracle");
		
		
		for (int i = 0; i < lists.size(); i++) {
			System.out.println(lists.get(i));
		}
		System.out.println("=====================");
		// 개량 for문
		for(String subject : lists) {
			System.out.println(subject);
		}
		System.out.println("=====================");
		// Stream forEach
		lists.stream().forEach((item)->{
			System.out.println(item);
		});
	}

}
