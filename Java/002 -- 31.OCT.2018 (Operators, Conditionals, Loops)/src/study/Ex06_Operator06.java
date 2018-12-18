package study;

public class Ex06_Operator06 {
	public static void main(String args[]) {
		int num = 5;
		
		/* 레프트 쉬프트 연산자 (<<)
		 * 좌항에는 변수, 우항에는 정수타입의 값
		 * 좌항 비트 중 1인 자리를 우항의 값만큼 왼쪽으로 이동
		 * 좌항의 변수값에서 2의 n제곱만큼 곱한 결과를 반환
		 * ex)
		 * 		5     --> 0 0 1 0 1
		 * (num << 2) --> 1 0 1 0 0 
		 */
		num <<= 2;
		// num = num << 2;와 동일
		System.out.println("1. left shift w/ assignment (num <<= 2): " + num);
		// 사전에 "num = num << 2;"를 시행했기 때문에 num의 값이 완전히 바뀌어버린 것
		
		// OR
		System.out.println("2. left shift wo assignment (num << 2): " + (num << 2));
		System.out.println("\t >> num remains unchanged (num == " + num + ")");
		// 쉬프트 연산자로 값을 바꿔서 보여줄 뿐, 원래 num 값은 바뀌지 않는다
		
		/* 라이트 쉬프트 연산자 (>>)
		* 좌항에는 변수, 우항에는 정수타입의 값
		* 좌항 비트 중 1인 자리를 우항의 값만큼 오른쪽으로 이동
		* 좌항의 변수값에서 2의 n제곱만큼 나눈 결과를 반환 (나머지는 버려진다)
		* ex)
		* 	   5     --> 0 0 1 0 1
		* (num >> 2) --> 0 0 0 0 1
		*/
		num = num >> 2;
		System.out.println("3. right shift w/ assignment (num >>= 2): " + num);
		// OR
		System.out.println("4. right shift wo assignment (num >> 2): " + (num >> 2));
		System.out.println("\t >> num remains unchanged (num == " + num + ")");
	}

}