package ch08;

// 생성자메서드
// 객체 생성시 한번만 호출되는 메서드
// 생성된 객체내에서는 사용 불가능
// 겍체 생성시에 필요한 메모리공간 형성과 초기값 부여에 사용
// 생성자 메서드 이름은 클래스 이름과 동일하며 반환자료형은 가지지 않는다


// 생성자가 정의되어 있지 않을 경우 컴파일러가 기본생성자를 추가해서 컴파일 한다
class construct {
	int n1;
	double n2;
	boolean n3;
	String n4;
	
	construct(){}
	construct(int n1) {
		this.n1 = n1;
		System.out.println("n1 호출");
	}

	construct(int n1, double n2) {
		this.n1 = n1;
		this.n2 = n2;
		System.out.println("n1, n2 호출");
	}

	construct(int n1, double n2, boolean n3) {
		this.n1 = n1;
		this.n2 = n2;
		this.n3 = n3;
		System.out.println("n1, n2, n3 호출");
	}
//	construct(int n1,double n2, boolean n3, String n4){
//		this.n1 = n1;
//		this.n2 = n2;
//		this.n3 = n3;
//		this.n4 = n4;
//		System.out.println("n1, n2, n3, n4 호출");
//	}

	@Override
	public String toString() {
		return "construct [n1=" + n1 + ", n2=" + n2 + ", n3=" + n3 + ", n4=" + n4 + "]";
	}

	public construct(int n1, double n2, boolean n3, String n4) {
		super();
		this.n1 = n1;
		this.n2 = n2;
		this.n3 = n3;
		this.n4 = n4;
	}

}

public class ch08constructorMain {

	public static void main(String[] args) {
		
		construct ct0 = new construct();
		construct ct1 = new construct(10);
		construct ct2 = new construct(20, 20.5);
		construct ct3 = new construct(30, 30.5, true);
		construct ct4 = new construct(40, 40.5, true, "banana");

		System.out.println(ct1);
		System.out.println(ct2);
		System.out.println(ct3);
		System.out.println(ct4);
	}

}
