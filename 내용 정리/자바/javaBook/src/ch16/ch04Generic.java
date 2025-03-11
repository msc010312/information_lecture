package ch16;

class Animal {
	String name;

	public Animal(String name) {
		super();
		this.name = name;
	}

}

class Panda extends Animal {

	public Panda(String name) {
		super(name);
	}

	@Override
	public String toString() {
		return "Panda [name=" + name + "]";
	}

}

class Tiger extends Animal {

	public Tiger(String name) {
		super(name);
	}

	@Override
	public String toString() {
		return "Tiger [name=" + name + "]";
	}

}

public class ch04Generic {

	//generic
	public static <T> void PrintByGeneric(T[] arr) {
		for (T el : arr) {
			System.out.println(el);
		}
	}

	//object
	public static void PrintByObject(Object[] Animal) {
		for (Object el : Animal) {
			System.out.println(el);
		}
	}
	public static void main(String[] args) {
		Tiger arr1 [] = {new Tiger("호랑이1"),new Tiger("호랑이2")};
		Panda arr2 [] = {new Panda("판다1"),new Panda("판다2")};
		Object arr3[] = {new Tiger("호랑이3"),new Panda("판다3"),};
		PrintByGeneric(arr1);
		PrintByGeneric(arr2);
		PrintByObject(arr3);
	}

}
