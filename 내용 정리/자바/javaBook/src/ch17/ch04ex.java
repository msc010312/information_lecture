package ch17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ch04ex {

	public static void main(String[] args) {
		Set<Integer> set = new HashSet();
		while(set.size()<6) {
			int num = (int)((Math.random()*45)+1);
			set.add(num);
		}
		
		List<Integer> tmpset = new ArrayList(set);
		Collections.sort(tmpset);
		
		for(Integer el : tmpset) {
			System.out.print(el + " ");
		}
	}

}
