package ch17;

import java.util.HashMap;
import java.util.Map;

public class ch06Map {

	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap();
		
		// 추가
		map.put("aaa", 123);
		map.put("bbb", 456);
		map.put("ccc", 789);
		map.put("ccc", 999); // 중복key(나중에 put된 값을 덮어씀)
		
		//삭제
		map.remove("bbb");
		
		// 확인
		System.out.println(map.size());
		System.out.println(map.get("bbb"));
		System.out.println("---------------");
		for(String key : map.keySet()) {
			System.out.println(key + " : " + map.get(key));
		}
	}

}
