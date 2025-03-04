package ch08;

class ch02person {
	// 속성
	String name;
	int age;
	float height;
	double weight;
}

public class ch02personMain {

	public static void main(String[] args) {
		ch02person hong = new ch02person();
		hong.name = "홍길동";
		hong.age = 12;
		hong.height = 177.5f;
		hong.weight = 70.5;

		System.out.printf("%s %d %f %f\n", hong.name, hong.age, hong.height, hong.weight);
	}

}
