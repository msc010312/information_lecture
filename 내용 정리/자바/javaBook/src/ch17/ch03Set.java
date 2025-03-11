package ch17;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ch03Set {

	public static void main(String[] args) {
		Set<String> set = new HashSet();
		
		// 추가
		set.add("HTML/CSS/JS");
		set.add("JQUERY");
		set.add("NODEJS");
		set.add("JAVA");
		set.add("JAVA"); // set은 중복허용안함
		
		System.out.println(set.size());
		
		// 삭제
		set.remove("NODEJS");
		
		// 조회
//		Iterator<String> iter = set.iterator();
//		while(iter.hasNext()) {
//			System.out.println(iter.next());
//		}
		
		for(String el : set) {
			System.out.println(el);
		}
		
		set.clear();
	}

}
