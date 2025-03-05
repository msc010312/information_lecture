package ch09;

class person {
	private String name;
	private int age;
	private String addr;
	
	person(){
		
	}
	public person(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	
	//getter 함수(데이터를 외부로 반환)
	public String getName() {
		return name;
	}
	//setter 함수 (기존데이터를 수정)
	public void setAge(int age) {
		this.age = age;
	}
	
	
}

public class ch01정보은닉 {

	public static void main(String[] args) {
		// - 접근한정자 -
		// private 		- 현재 클래스에서만 사용가능
		// default 		- 같은 패키지에서만 사용가능
		// protected 	- 상속관계에 있거나 같은 패키지에서만 사용가능
		// public 		- 모든 객체에서 사용가능
		
		person ps = new person("max",55,"london");
		System.out.println(ps.getName());
	}

}
