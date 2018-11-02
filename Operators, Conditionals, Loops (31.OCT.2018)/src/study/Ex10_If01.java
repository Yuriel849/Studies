package study;

import java.util.Scanner;

public class Ex10_If01 {
	public static void main(String args[]) {
		int number = 12;
		
		// if문 2번 반복, 조건문만 만족시킨다면 if문 둘 다 실행 가능
		if (number % 2 == 0) {
			System.out.printf("1. %d는 짝수입니다\n", number);
		}
		if (number % 2 == 1) {
			System.out.printf("1. %d는 홀수입니다\n", number);
		}
		
		// if-else문 1번 실행
		if (number % 2 == 0) {
			System.out.printf("2. %d는 짝수입니다\n", number);
		} else {
			System.out.printf("2. %d는 홀수입니다\n", number);
		}
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("주민번호 7번째 숫자를 입력하세요 : \n");
		int gender = sc.nextInt();
		
		if (gender == 1 || gender == 3) {
			System.out.println("3. 당신은 남자입니다");
		}
		if (gender == 2 || gender == 4) {
			System.out.println("3. 당신은 여자입니다");
		}
		
		if (gender == 1 || gender == 3) {
			System.out.println("4. 당신은 남자입니다");
		} else {
			System.out.println("4. 당신은 여자입니다");
		}
	}

}