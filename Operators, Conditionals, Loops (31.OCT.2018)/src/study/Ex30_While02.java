package study;

import java.util.Scanner;

public class Ex30_While02 {
	public static void main(String[] args) {
		// while문은 반복횟수가 불분명할 때 주로 사용
		Scanner scan = new Scanner(System.in);
		
		System.out.print("100을 입력하면 종료합니다 : ");
		while(scan.nextInt() != 100) {
			System.out.print("100을 입력하면 종료합니다 : ");
		}
		System.out.print("프로그램 종료");
	}

}
