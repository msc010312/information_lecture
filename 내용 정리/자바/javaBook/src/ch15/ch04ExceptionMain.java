package ch15;

public class ch04ExceptionMain {

	public static void main(String[] args) {
		try {
		String str = null;
		str.toString();
		
		int arr[] = {10,20,30};
		arr[5] = 100;
		
		Integer.parseInt("a1234");
		
		Animal animal = new Dog();
		Cat yummi = (Cat)animal;
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
//		} catch(NullPointerException e) {
//			System.out.println(e.getMessage());
//		} catch (ArrayIndexOutOfBoundsException e) {
//			System.out.println(e.getMessage());
//		} catch(NumberFormatException e) {
//			System.out.println(e.getMessage());
//		} catch(ClassCastException e) {
//			System.out.println(e.getMessage());
//		}
		finally { // 자원정리작업
			System.out.println("finally test");
		}
		System.out.println("hello world");
	}

}
