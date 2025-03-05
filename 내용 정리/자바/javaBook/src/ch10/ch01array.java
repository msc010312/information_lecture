package ch10;

import java.util.Arrays;
import java.util.Scanner;

public class ch01array {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] arr1 = new int [5];
		System.out.println(arr1.length);
		System.out.println("5개의 값을 입력하세요");
		arr1[0] = sc.nextInt();
		arr1[1] = sc.nextInt();
		arr1[2] = sc.nextInt();
		arr1[3] = sc.nextInt();
		arr1[4] = sc.nextInt();
//		int max = arr1[0];
//		int min = arr1[0];
//		for (int i = 0; i < arr1.length; i++) {
//			if(arr1[i]>max) {
//				max = arr1[i];
//			}
//			if(arr1[i]<min) {
//				min = arr1[i];
//			}
////			System.out.println(arr1[i]);	
//		}
//		System.out.println(max);
//		System.out.println(min);
//		System.out.println("------------------------");
//		for (int el : arr1) {
//			System.out.println(el);
//		}
//		System.out.println("------------------------");
//		Arrays.stream(arr1).forEach(System.out::println);
		
		//입력된 정수중에 최대값과 최소값을 출력
		System.out.println(Arrays.stream(arr1).max().getAsInt());
		System.out.println(Arrays.stream(arr1).min().getAsInt());
		
	}
}
