package ch10;

class Person {
	String name;
	int age;
	
	public Person(){
		
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
}

public class ch04classArray {

	public static void main(String[] args) {
		Person ps[] = new Person[3];
		
		ps[0] = new Person();
		ps[0].name="홍길동";
		ps[0].age=55;
		
		ps[1] = new Person();
		ps[1].name="김영희";
		ps[1].age=35;
		
		ps[2] = new Person();
		ps[2].name="김범수";
		ps[2].age=40;
	}

}
