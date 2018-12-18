package study;

public class Ex01_Operator01 {
	public static void main(String args[]) {
		/* 연산자
		 * "단항"연산자, "이항"연산자 등은 피연산자의 수를 나타낸다!!!
		 * 
		 * &&, || --> 2개씩 붙으면 일반논리연산용
		 * &, | --> 하나씩 있으면 비트연잔자용
		 * 	>> AND가 OR보다 우선순위가 높다
		 * 
		 * ! --> 논리부정연산자, boolean에만 사용 가능
		 * ~ --> 비트전환연산자, 비트연산 시 & 정수형에만 사용 가능
		 */

		int number1 = 33;
		int number2 = 10;
		int result;
		
		int num = 5;
		result = num + 1;
		/* 	>> num의 값은 계속 5, result의 값이 6
		 * 
		 * num += 1 OR num++
		 * 	>> num 자체의 값이 6으로 바뀜
		 */

			
		// % (나머지) 연산자
		// 짝수/홀수 판별, 배수 판별에 사용
		result = number1 % number2;
		System.out.printf("%d %c %d = %d\n", number1, '%', number2, result);
			
		// number1 % 2 == 0 <-- 짝수
		// number1 % 2 != 0 <-- 홀수
		// number1 % 3 == 0 <-- 3의 배수
		
		/* int보다 작은 자료형은 연산하면 자동적으로 int형으로 변환된다
		 * 그래서 다시 "c"에 저장할 때 byte로 강제 형변환할 필요가 있다
		 */
		byte a = 10;
		byte b = 20;
		byte c = (byte) (a + b);
		// byte c = (byte) a + (byte) b; 와 동일
		
		/* byte c = (byte) a + b
		 * 에러나고 무의미하다
		 * 		>> 이미 a는 byte인데 다시 byte로 바꿔서 뭐하게?
		 * 		>> 어차피 b가 int로 변환되기에 더 큰 int 값으로 변한다
		 * 		>> 그리고 int를 byte에 대입하려면 에러난다
		 */
		
		/* Overflow
		 * ex) int a = 1mil., int b = 2mil.
		 * 		>> a & b separately are the right size for int
		 * 		>> HOWEVER a*b exceeds the size capacity of int and overflow occurs
		 * 		>> solve by type casting a or b into long, then assign to a long type variable
		 * 
		 * long c = (long) a * b
		 * 		>> 큰 자료형의 데이터를 작은 자료형의 데이터로 바꿀때는 강제형변환 사용해야
		 * 		>> 서로 다른 자료형 2개 이상을 같이 연산하면 더 큰 자료형에 맞추게 자동 형변환한다
		 * 		>> 연산의 결과도 더 큰 자료형으로 바뀐 상태로 남는다
		 */
	}
}