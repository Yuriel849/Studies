package study;

public class Ex02_Operator02 {
	public static void main(String args[]) {
		int num1 = 10;
		int num2 = 4;
		int num3 = 7;
		int num4 = 15;
		
		/* AND 연산자 (&&)
		 * 좌항과 우항이 모두 참인 경우에만 참을 반환
		 * AND 연산자는 좌항의 식이 false인 경우 우항의 식을 실행하지 않음
		 */
		System.out.printf("%b && %b = %b\n", false, false, false && false);
		System.out.printf("%b && %b = %b\n", false, true, false && true);
		System.out.printf("%b && %b = %b\n", true, false, true && false);
		System.out.printf("%b && %b = %b\n\n", true, true, true && true);
		// %b <-- boolean용 서식문자, true or false 2가지 값을 표현할 수 있음
		
		/* OR 연산자 (||)
		 * 좌항과 우항이 모두 거짓인 경우에만 거짓을 반환
		 * OR 연산자는 좌항의 식이 true인 경우 우항의 식을 실행하지 않음
		 */
		System.out.printf("%b || %b = %b\n", false, false, false || false);
		System.out.printf("%b || %b = %b\n", false, true, false || true);
		System.out.printf("%b || %b = %b\n", true, false, true || false);
		System.out.printf("%b || %b = %b\n\n", true, true, true || true);
		
		// NOT 연산자 (!)
		System.out.printf("!%b = %b\n", true, !true);
		System.out.printf("!%b = %b\n", false, !false);
		
	}

}