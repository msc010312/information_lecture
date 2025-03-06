package ch11;


class C01Simple{
	static int num1;
	int num2;
	
	//static : 클래스 내에 멤버에 적용하는 경우
	//해당 클래스로 객체 생성시 모든 객체간의 공유되는 멤버로 지정
	//클래스이름으로도 static멤버에 접근이 가능
	
	
	public C01Simple() {
		num1 = 0;
		num2 = 0;
	}
	public C01Simple(int num1, int num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}


	@Override
	public String toString() {
		return "C01Simple [num1=" + num1 + ", num2=" + num2 + "]";
	}
}


public class ch01staticMain {
	
	public static void main(String[] args) {

		
		C01Simple ob1 = new C01Simple();
		C01Simple ob2 = new C01Simple();
		
		C01Simple.num1=100;
		System.out.println(C01Simple.num1);
		
		System.out.println(ob1);
		System.out.println(ob2);
	}
	
}
