package study;

public class Ex04_Variable03 {
	static int number = 897;
	// number는 main 메소드 밖, 메소드와 동급... 전역 변수 (global variable)
			// Java에서는 "전역변수"보다는 "멤버변수" == "(멤버)필드"라고 표현
			// 멤버변수는 자동으로 초기화 (<-> 지역 변수는 수동으로 초기화해야, 초기화하지 않으면 사용도 못함)
			// 멤버변수는 각 자료형의 기본값으로 자동으로 초기화
				/* byte/short/int/long의 기본값은 0
				 * float/double의 기본값은 0.0
				 * char의 기본값은 null ('\u0000')... 주로 ' '로 표현 (공백)
				 * boolean의 기본값은 false
				 */
	// number1, number2는 main 메소드에 속한 것... 지역 변수 (local variable)
		// 모든 멤버변수는 선언 후 초기화한 이후에 사용할 수 있음

	public static void main(String args[]) {
		System.out.printf("number1 = %d\n", number);
		/* main 메서드 앞에 static이 붙어 있는데,
		 * static이라고 쓴 메소드에서 밖의 데이터에 접근하려면 그 데이터도 static이라고 붙어있어야 한다.
		 * 		>> number 앞에 static이라고 써있으니까 접근 가능하다.
		 */

		// 변수의 선언 위치
		// 제약 없음 - 어디에서나 변수의 선언 가능
		System.out.println("프로그램 시작");
		
		int number1 = 10;
		System.out.printf("number1 = %d\n", number1);
		
		int number2 = 20;
		// 변수만 선언하고 실행하면 에러나지는 않는다
		System.out.printf("number2 = %d\n", number2);
		// 변수를 선언했으나 초기화하지 않았으면 에러가 난다	}
	}
}