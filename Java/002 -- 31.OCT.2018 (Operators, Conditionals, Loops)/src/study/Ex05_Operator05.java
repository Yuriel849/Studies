package study;

public class Ex05_Operator05 {
	public static void main(String args[]) {
		int num1 = 10, num2 = 5;
		
		/* 비트연산자 AND (&)
		 * 좌항과 우항의 각 비트를 비교하여 모두 1인 자리만 1을 반환, 나머지는 0을 반환
		 */
		int result = num1 & num2;
		System.out.println("num1 & num2 : " + result);
		/* "0"이 출력된다
		 * num1 -> 0 1 0 1 0
		 * num2 -> 0 0 1 0 1
		 *  &   -> 0 0 0 0 0 
		 * 		--> 비트연산자로 10의 비트값과 5의 비트값이 모두 1일 때 1을 반환하는 &를 사용했으나 모두 1인 비트가 없다!!
		 * 		--> "10"은 2진수로 1 0 1 0 --> (1x2**3) + (1x2**1) = 8 + 2 = 10
		 */
		
		/* 비트연산자 OR (|)
		 * 좌항과 우항의 각 비트를 비교하여 모두 0인 자리만 0을 반환, 나머지는 1을 반환
		 */
		result = num1 | num2;
		System.out.println("num1 | num2 : " + result);
		/* num1 -> 0 1 0 1 0
		 * num2 -> 0 0 1 0 1
		 *  |   -> 0 1 1 1 1 --> (1x2**3) + (1x2**2) + (1x2**1) + (1x2**0)
		 *  				 --> 	 8    +		4 	 +	   2	+	  1    = 15
		 */
		
		/* 비트연산자 XOR (^)
		 * 좌항과 우항의 각 비트를 비교하여 서로 다른 자리만 1을 반환, 나머지는 0을 반환
		 */
		result = num1 ^ num2;
		System.out.println("num1 ^ num2 : " + result);
		/* num1 -> 0 1 0 1 0
		 * num2 -> 0 0 1 0 1
		 *  |   -> 0 1 1 1 1 --> (1x2**3) + (1x2**2) + (1x2**1) + (1x2**0)
  		 *  				 --> 	 8    +		4 	 +	   2	+	  1    = 15
		 *  				 --> 이번에는 우연히 OR & XOR 결과값이 일치했을 뿐!!!
		 */
		
		/* 비트연산자 NOT (~)
		 * 단항연산자다
		 * 해당 비트값을 반대로 바꾸어 반환 (1을 0으로, 0을 1로)
		 */
		result = ~num1 & num2;
		System.out.println("~num1 & num2 : " + result);
		/* num1 -> 0 1 0 1 0
		 *~num1 -> 1 0 1 0 1
		 * num2 -> 0 0 1 0 1
		 *  &   -> 0 0 1 0 1 --> (1x2**2) + (1x2**0)
		 *  				 --> 	 4 	  + 	1    = 5
		 */
	}
}