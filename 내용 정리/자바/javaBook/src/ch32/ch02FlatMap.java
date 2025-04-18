package ch32;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ch02FlatMap {
	
	public static void main(String[] args) {
	
		List<List<Integer>> numbers = Arrays.asList(
				Arrays.asList(1,2,3),
				Arrays.asList(4,5,6),
				Arrays.asList(7,8,9)
			);
		
		List<Integer> list =  numbers.stream()
				//.flatMap((li)->li.stream())
				.flatMap(List::stream)
				.collect(Collectors.toList());
		
		System.out.println(numbers);
		System.out.println(list);
	}
	
}

