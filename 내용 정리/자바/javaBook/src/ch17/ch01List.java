package ch17;

import java.util.ArrayList;
import java.util.List;

public class ch01List {

	public static void main(String[] args) {
		List<String> list = new ArrayList();
		
		//추가
		list.add("HTML/CSS/JS");
		list.add("JQUERY");
		list.add("NODEJS");
		
		//조회
		System.out.println("갯수 확인 : " + list.size());
		System.out.println("idx로 조회 : " + list.get(2));
		System.out.println("value로 idx확인 : " + list.indexOf("JQUERY"));
		list.forEach(System.out::println);
		//삭제
		list.remove(1);
		list.remove("NODEJS");
		for(String el : list) {
			System.out.println(el);
		}
		
		//전체 삭제
		list.clear();
	}

}
