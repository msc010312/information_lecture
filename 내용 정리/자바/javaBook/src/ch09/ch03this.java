package ch09;

// this
// 클래스 내에서 사용되는 예약어
// 생성되는 객체의 위치정보(메모리주소~해시코드값)을 확인하는데 사용
// 맴버변수와 지역변수 구별에 사용
// 다른생성자 호출에 사용
class simple {
	int x;
	int y;
	
	simple(){
		this(0,0);
		System.out.println("기본생성자 호출");
	}
	
	simple(int x){
		this(x,0);
		System.out.println("int x 호출");
		this.x = x;
	}
	
	simple(int x, int y){
		System.out.println("int x, int y 호출");
		this.x = x;
		this.y = y;
	}
	
	simple getThis() {
		return this;
	}
	
}


public class ch03this {

	public static void main(String[] args) {
		simple sp = new simple();
		System.out.println(sp);
		System.out.println(sp.getThis());
	}

}
