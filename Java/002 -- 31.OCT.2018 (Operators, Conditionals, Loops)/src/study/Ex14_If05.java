package study;

import java.util.Scanner;

public class Ex14_If05 {
	public static void main(String args[]) {
		// 세 과목의 총점과 평균 구하기
				int score1 = 90;
				int score2 = 97;
				int score3 = 94;
				
						
				Scanner sc = new Scanner(System.in);
				
				System.out.printf("첫번째 성적을 입력하세요 : ");
				score1 = sc.nextInt();
				System.out.printf("두번째 성적을 입력하세요 : ");
				score2 = sc.nextInt();
				System.out.printf("세번째 성적을 입력하세요 : ");
				score3 = sc.nextInt();
				sc.close();
						
						
				// 총점 저장 변수
				int total;
						
				// 평균 저장 변수
				float average;
				
				// 학점 저장 변수
				char grade;
						
				// +, -, *, /
				total = score1 + score2 + score3;
				average = total / 3.0F;
				
				// printf() 메소드로 출력하기
				System.out.printf("총점 : %d점, 평균 : %.2f점\n", total, average);
				
				// 성적이 잘못 입력된 경우
				if(average > 100 || average < 0) {
					grade = '?';
				/* 100점 초과한 경우는 if문에서 처리하고
				 * 여기서(else if)는 90점 이상인 경우만 처리함
				 */
				}else if(average >= 90) {
					/* 만약 100점 초과한 경우를 사전에 처리하지 않았다면
					 * if (average >= 90 && average <=100)
					 */
					grade = 'A';
				}else if(average >= 80) {
					grade = 'B';
				}else if(average >= 70) {
					grade = 'C';
				}else if(average >= 60) {
					grade = 'D';
				}else {
					grade = 'F';
				}
				
				if (grade == '?') {
					System.out.println("성적을 다시 입력하세요\n");
				}else {
					System.out.printf("당신의 학점은 %c 학점입니다\n", grade);
		}
	}
}