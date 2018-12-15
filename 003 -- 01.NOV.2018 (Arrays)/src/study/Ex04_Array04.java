package study;

import java.util.Scanner;

public class Ex04_Array04 {
	public static void main(String args[]) {
		// 3과목의 성적을 입력받아서 총점, 평균 구하기
		Scanner sc = new Scanner(System.in);
		System.out.print("과목의 수를 입력해 주세요 : ");
		int subject_number = sc.nextInt();
		
		// 배열 : index 0, 1, 2 <-- 성적 저장, index 3 <-- 총점
		int[] score = new int[subject_number+1];
			// score.length <-- 4
			// 인덱스의 최댓값 = 배열의 크기 - 1
		float average;
		
		// index 1 ~ 2 까지 3과목의 성적을 입력하면서 index 3에 값을 누적덧셈하기
		for(int i = 0; i < score.length-1 ; i++) {
			System.out.printf("%d 번째 성적을 입력하세요 : ", (i+1));
			// 성적 입력
			score[i] = sc.nextInt();
			// 총점 : 성적 누적덧셈 --> score[3] += score[i];
			score[score.length-1] += score[i];
		}
		
		// average = (float)score[3] / 3;
		average = (float)score[subject_number] / (score.length-1);
		/* A / (score.length-1) --> 괄호를 해야지 순서대로 계산이된다
		 * 						--> 괄호가 없으면 나눗셈 후 빼기를 실시한다 -> (A / score.length) - 1
		 */
		
		// System.out.printf("총점 : %d점, 평균 : %.2f점", score[3], average);	
		System.out.printf("총점 : %d점, 평균 : %.2f점", score[score.length-1], average);	
	}

}
