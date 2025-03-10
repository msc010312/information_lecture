package ch14;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ch07LocalDateTimeFormat {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("YYYY/MM/DD 입력 : ");
		String ymd = sc.next();
		
		// 입력용 포매터
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		
		// 문자열을 LocalDate로 변환
		LocalDate date = LocalDate.parse(ymd, inputFormatter);
		System.out.println("입력된 날짜" + date);
		
		// 출력용 포매터
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy~MM~dd");
		
		// 포맷 변경 후 출력
		System.out.println("변환된 날짜" + date.format(outputFormatter));
		
		sc.close();
	}

}
