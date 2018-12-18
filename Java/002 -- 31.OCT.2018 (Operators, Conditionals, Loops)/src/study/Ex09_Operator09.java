package study;

import java.util.Scanner;
/* left ctrl + left shift + letter "o"
 * 		--> automatically imports necessary imports
 */

public class Ex09_Operator09 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("주민번호 7번째 숫자를 입력하세요 : ");
		int gender = sc.nextInt();
		
		String str = (gender == 1 || gender == 3) ? "남자" : "여자";
		System.out.printf("당신은 %s입니다\n", str);
		
		System.out.print("성적을 입력하세요 : ");
		int score = sc.nextInt();
		
		char grade = (score >= 90) ? 'A' : (score >= 80) ? 'B' : (score >= 70) ? 'C' : (score >= 60) ? 'D' : 'F';
		// 삼항연산자를 중첩하여 사용할 수 있다... 하지만 많이 중첩될 수록 헷갈리게되고 그래서 자제하는게 좋다...
		System.out.printf("당신의 학점은 %c입니다\n", grade);
	}
}