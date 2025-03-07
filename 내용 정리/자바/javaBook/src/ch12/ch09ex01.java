package ch12;

// Exercise 1: Basic Upcasting
class Animals {
    void makeSound() {
        System.out.println("동물이 소리를 냅니다");
    }
}

class Tiger extends Animals {
    void makeSound() {
        System.out.println("어흥!");
    }
    
    void fetch() {
        System.out.println("강아지가 공을 가져옵니다!");
    }
}

public class ch09ex01 {
    public static void main(String[] args) {
        System.out.println("=== 연습문제 1: 기본 업캐스팅 ===");
        // 문제: 다음 코드를 완성하세요
        // 1. Dog 인스턴스를 생성하세요
        // 2. 생성한 Dog 인스턴스를 Animal 타입으로 업캐스팅하세요
        // 3. 업캐스팅된 참조로 makeSound() 메서드를 호출해보세요
        // 4. 업캐스팅된 참조로 fetch() 메서드를 호출해보고 결과를 확인하세요
        Animals tg = new Tiger();
        tg.makeSound();
    }
} 