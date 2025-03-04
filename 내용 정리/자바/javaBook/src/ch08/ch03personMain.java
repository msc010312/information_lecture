package ch08;

class ch03person {
	// 속성
	String name;
	int age;
	float height;
	double weight;
	// 기능
	void talk() {
		System.out.printf("%s님이 말합니다\n", this.name);
	}
	void walk() {
		System.out.printf("%s님이 걷습니다\n", this.name);
	}
	// 속성정보확인
	void showInfo() {
		System.out.printf("%s %d %f %f\n", this.name, this.age, this.height, this.weight);
	}
	// 객체정보확인(to String)
	@Override
	public String toString() {
		return "ch03person [name=" + name + ", age=" + age + ", height=" + height + ", weight=" + weight + "]";
	}
	
}

public class ch03personMain {

	public static void main(String[] args) {
		ch03person hong = new ch03person();
		hong.name = "홍길동";
		hong.age = 12;
		hong.height = 177.5f;
		hong.weight = 70.5;
		
		hong.talk();
		hong.walk();
		hong.showInfo();
		
		System.out.println(hong.toString());
		System.out.println(hong);
	}

}
