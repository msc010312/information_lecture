package ch32;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Person {
	public String name;
	public int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	Person() {
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}

class Employee extends Person{
	String company;
	String dep;
	String role;
	Employee(){}
	Employee(Person person){
		this.name = person.getName();
		this.age = person.getAge();
	}
	public Employee(String company, String dep, String role) {
		this.company = company;
		this.dep = dep;
		this.role = role;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDep() {
		return dep;
	}
	public void setDep(String dep) {
		this.dep = dep;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Employee [company=" + company + ", dep=" + dep + ", role=" + role + ", getName()=" + getName()
				+ ", getAge()=" + getAge() + "]";
	}
}

public class ch01Stream {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println(list);

		// filter
		List<Integer> list2 = list.stream().filter((item) -> { // item의 요소 필터링
			return item % 2 == 0;
		}).collect(Collectors.toList()); // 결과 수집
		System.out.println(list2);

		List<Integer> list3 = list.stream().filter((item) -> {
			return item % 2 == 0;
		}).map((item) -> { // item 재구성
			return item * item;
		}).collect(Collectors.toList()); // 결과 수집
		System.out.println(list3);

		List<Person> list4 = Arrays.asList(
				new Person("홍길동", 11), 
				new Person("박혁거세", 21), 
				new Person("이근", 31),
				new Person("유재석", 41)
			);
		List<Integer> list5 =
		list4.stream()
//			 .map(person->person.getAge())
			 .map(Person::getAge) // 메서드 참조
			 .sorted((a,b)->b-a)
			 .collect(Collectors.toList());
		System.out.println(list5);
		
		List<Integer> list6 = 
		list4.stream()
			.map(Person::getName)
			.map(String::length)
			.sorted((a,b)->b-a)
			.collect(Collectors.toList());
		System.out.println(list6);
		
		List<Employee> list7 =
		list4.stream()
//			.map(person->new Employee(person.getName(),person.getAge()))
			.map(Employee::new)
			.collect(Collectors.toList());
		list7.forEach(System.out::println);
	}

}
