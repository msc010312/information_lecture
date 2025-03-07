package ch12;

//Exercise 4: Interface Implementation
interface Playable {
 void play();
}

class Instrument implements Playable {
 public void play() {
     System.out.println("악기를 연주합니다");
 }
}

class Piano extends Instrument {
 public void play() {
     System.out.println("피아노를 연주합니다");
 }
 
 void tune() {
     System.out.println("피아노를 조율합니다");
 }
}
public class ch09ex04 {

	public static void main(String[] args) {
		System.out.println("=== 연습문제 4: 인터페이스 구현 ===");
        // 문제: 다음 단계를 수행하는 코드를 작성하세요
        // 1. Piano 인스턴스를 생성하세요
        // 2. 생성한 인스턴스를 Playable 인터페이스 타입으로 업캐스팅하세요
        // 3. 업캐스팅된 참조로 play() 메서드를 호출해보세요
        // 4. Instrument 클래스 타입으로 업캐스팅하고 play() 메서드를 호출해보세요
        // 5. 각 단계에서 tune() 메서드 호출을 시도해보세요
		Playable pa = new Piano();
		pa.play();
		Instrument pa2 = new Piano();
		pa2.play();
		
		Piano pa3 = (Piano)pa;
		pa3.tune();
	
        

        
        // 실행 결과 예시:
        // 피아노를 연주합니다
        // 피아노를 연주합니다

	}

}
