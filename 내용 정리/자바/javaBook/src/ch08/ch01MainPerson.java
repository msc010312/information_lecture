package ch08;

public class ch01MainPerson {

	public static void main(String[] args) {
		ch01Person hong = new ch01Person();
		hong.name = "홍길동";
		hong.age = 12;
		hong.height = 177.5f;
		hong.weight = 70.5;

		System.out.printf("%s %d %f %f\n", hong.name, hong.age, hong.height, hong.weight);
	}

}
