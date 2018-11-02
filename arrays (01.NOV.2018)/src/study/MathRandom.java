package study;

public class MathRandom {
	public static void main(String[] args) {
		// The range of Math.random() is 0.0 <= X < 1.0
		for(int i = 1; i<=10; i++) {
			System.out.printf("%2dth time : " + (int)(Math.random()*10) + "\n", i);
		}
		System.out.println();
		
		for(int i = 1; i<=10; i++) {
			// 주사위 던지기 
			System.out.print("Throwing dice for the...");
			System.out.printf("%2dth time : " + (int)(Math.random()*6) + "\n", i);
		}
		System.out.println();
		
		/* -5 ~ 5 사이의 임의의 정수를 10개 출력하시오
		 * 	>> -5 -4 -3 -2 -1 0 1 2 3 4 5 >> 11개
		 * 	>> 1 ~ 11 >> (1-6) ~ (11-6) >> -5 ~ 5
		 */
		for(int i = 1; i <= 10; i++) {
			System.out.println((int)(Math.random()*11)-5); // 우선순위 --> (타입) 연산자 > 산술 연산자
		}
	}
}
