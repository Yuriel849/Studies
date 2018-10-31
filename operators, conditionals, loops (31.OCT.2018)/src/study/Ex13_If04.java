package study;

import java.util.Scanner;

public class Ex13_If04 {
	public static void main(String args[]) {
		/* Scanner로 구현
		 * 
		 * menu번호를 입력하세요
		 * 1. 한식, 2. 중식, 3. 양식
		 */
		
		// Scanner 외 input방식도 있지만 편리해서 (우리가 배우는 첫) input 방식으로 배워서 사용하는 것.
		Scanner scan = new Scanner(System.in);
		int menu;
		System.out.println("메뉴를 선택해주세요.");
		menu = scan.nextInt();
		scan.close();
		
		if (menu == 1) {
			System.out.println("한식을 선택하셨습니다.");
		}
		if (menu == 2) {
			System.out.println("중식을 선택하셨습니다.");
		}
		if (menu == 3) {
			System.out.println("양식을 선택하셨습니다.");
		}
	}

}
