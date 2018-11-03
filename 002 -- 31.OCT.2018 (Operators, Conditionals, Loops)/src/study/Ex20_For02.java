package study;

public class Ex20_For02 {
	public static void main(String args[]) {
		for(int i=1; i<=10;i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		for(int i=1; i<10;i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		for(int i=1; i<=9;i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		for(int i=0; i<=9;i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println();
		
		/* 1 ~ 10 숫자 중 짝수만 출력하고 홀수만 출력하세요
		 * 방법 1. 증가식 사용
		 * 방법 2. if 조건문 사용
		 */
		
		for(int i=1; i<=10; i++) {
			if (i % 2 == 0) {
				System.out.print("짝수 : " + i + " ");
			}
		}
		System.out.println();

		for(int i=1; i<=10; i+=2) {
			System.out.print("홀수 : " + i + " ");
		}
	}

}
