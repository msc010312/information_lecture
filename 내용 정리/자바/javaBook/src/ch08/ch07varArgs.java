package ch08;

class varArgs {
	int sum(int... arg) {
		System.out.println(arg);
		int sum = 0;
		for(int item : arg) {
			System.out.println(item);
			sum += item;
		}
		System.out.println(sum);
		return sum;
	}
}

public class ch07varArgs {

	public static void main(String[] args) {
		varArgs va = new varArgs();
		va.sum(10,20,30,40);
		System.out.println();
		va.sum(50,60,70,80,90);
	}

}
