package study;

import java.util.Scanner;

public class Ex31_DoWhile01 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		/* while문을 do-while문으로 바꾸기
		 * 
		 * do-while문
		 *		>> 코드를 최소한 한 번 실행할 수 있음
		 * 		>> 코드를 한 번 실행한 후 조건식의 참-거짓에 따라 다시 반복하거나 종료한다
		 */
		do {
			System.out.print("100을 입력하면 종료합니다 : ");
		} while(scan.nextInt() != 100);
		System.out.print("프로그램 종료");
	}
	
}
