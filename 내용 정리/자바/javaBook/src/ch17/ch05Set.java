package ch17;

import java.util.HashSet;
import java.util.Set;

class Person {
	String name;
	int age;
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Person) {
			Person down = (Person)obj;
			return this.name.equals(down.name) && this.age == down.age;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return age;
	}
}

public class ch05Set {

	public static void main(String[] args) {
		Set<Person> set = new HashSet();
		
		Person ob1 = new Person("홍길동",55);
		Person ob2 = new Person("남길동",45);
		Person ob3 = new Person("홍길동",55);
		
		System.out.println(ob1.equals(ob2));
		System.out.println(ob1.equals(ob3));
		set.add(ob1);
		set.add(ob2);
		set.add(ob3);
		
		System.out.println(set.size());

	}

}
