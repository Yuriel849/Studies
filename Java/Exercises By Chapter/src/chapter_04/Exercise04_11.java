package chapter_04;

// Fibonacci 수열의 10번째 숫자를 구하라.

public class Exercise04_11 {
	public static void main(String[] args) {
		// Fibonacci 수열의 첫 두 숫자를 1과 1로 한다.
		int num1 = 1;
		int num2 = 1;
		int num3 = 0; // 세번째 값
		System.out.print(num1 + ", " + num2);
		
		for(int i = 0; i < 8; i++) {
			num3 = num1 + num2;
			System.out.print(", " + num3);
			num1 = num2;
			num2 = num3;
		}
	} // main() 끝.
} // 클래스 끝.