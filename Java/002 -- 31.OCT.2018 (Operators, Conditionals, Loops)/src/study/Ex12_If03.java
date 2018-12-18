package study;

import java.util.Scanner;

public class Ex12_If03 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디를 입력하세요 : ");
		int id = sc.nextInt();
		System.out.print("비밀번호를 입력하세요 : ");
		int pw = sc.nextInt();
				
		/* id가 333이고 pw가 555인 경우,
		* "로그인 성공!!!" 출력하고
		* 아닌 경우에는 "로그인 실패!!!" 출력
		*/
		
		/* 1. 논리연산자를 사용하는 방법
		* id와 pw가 동시에 맞아야 로그인에 성공함
		*/
		if (id == 333 && pw == 555) {
			System.out.println("1. 로그인 성공!!!");
		} else {
			System.out.println("1. 로그인 실패!!!");
		}
		
		/* 2. 중첩된 if문을 사용하는 방법
		* if문 내부에 if문을 정의하는 방법 
		*/
		if (id == 333) {
			if (pw == 555) {
				System.out.println("2. 로그인 성공!!!");
			} else {
				System.out.println("2. 비밀번호를 잘못 입력하셨어요.");
			}
		} else {
			System.out.println("2. 아이디를 잘못 입력하셨어요.");
		}
		
		/* 3. boolean 변수를 사용하는 방법 */
		boolean flag;
		flag = (id == 333);
		flag = flag && (pw == 555);
		if (flag) {
			System.out.println("3. 로그인 성공!!!");
		} else {
			System.out.println("3. 로그인 실패!!!");
		}
		
		boolean flag1, flag2;
		flag1 = (id == 333);
		flag2 = (pw == 555);
		if (flag1 && flag2) {
			System.out.println("4. 로그인 성공!!!");
		} else {
			System.out.println("4. 로그인 실패!!!");
		}
	}
}