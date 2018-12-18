package study;

public class Ex04_Operator04 {
	public static void main(String args[]) {
		// 변수명을 "name 이름" OR "identifier 식별자"라고 부름
		int number = 10;
		
		/* int number = 10 * 3;
		 * 		>> 이미 "number"라는 이름의 변수를 선언한 상태
		 * 		>> 또다시 똑같은 이름의 변수를 선언하려하니까 에러나는 것
		 */
		
		/* int num = 10;
		 * number = 10 * 3;
		 * 		>> 이 경우, number라는 변수가 선언되지 않은 상태
		 * 		>> 선언되지도 않은 변수를 사용하려하니까 에러나는 것
		 */

		number = 10 * 3;
		System.out.printf("1. number = 10 * 3 : %d\n", number);
		
		number = number + 1;
		System.out.printf("2. number = number + 1 : %d\n", number);
		
		number++;
		System.out.printf("3. number++ : %d\n", number);
		
		number += 1;
		System.out.printf("4. number += 1 : %d\n", number);
		
		boolean result = (number += 30) >= 50;
		System.out.println("result : " + result);
		System.out.println((number += 30) >= 50);	
	}
}