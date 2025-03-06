package ch11;
//다음 2개의 static 가진 ArrayUtils 클래스를 만들어보자. 다음 코드의 실행 결과를 참고하여 concat()와 print()를 작성하여 ArrayUtil 클래스를 완성하라.

class ArrayUtils {
	   public static int[] concat(int[] a, int[] b) {
	        /* 배열 a와 b를 연결한 새로운 배열 리턴 */
		   int len = a.length + b.length;
		   int[] newArr = new int[len];
		   int i=0;
		   for(;i<len;i++) {
			   if(i<a.length)
				   newArr[i] = a[i];
			   else 
				   newArr[i] = b[i-a.length];
		   }

		   return newArr;
	   }
	   
	   public static void print(int [] a) {
		   for(int el : a)
			   System.out.print(el +" ");
		   System.out.println();
	   }
	   
	}
public class ch04Ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array1 = { 1, 5, 7, 9 };
		int[] array2 = { 3, 6, -1, 100, 77 };
		int[] array3 = ArrayUtils.concat(array1, array2);
		ArrayUtils.print(array3);
	}
}
