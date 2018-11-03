package study;

import java.util.Arrays;

public class Array {
	public static void main(String[] args) {
		int[] score = new int[5];
		score[0] = 100;
		score[1] = 90;
		score[2] = 80;
		score[3] = 70;
		score[4] = 60;
		/* score[5] = 50;
		 * 	>> 배열은 score[0] ~ score[4]까지만 존재
		 * 	>> 에러 안나지만 실행하면 에러
		 */
		
		int[] score1 = {100, 90, 80, 70, 60};
		
		for(int i = 0; i < 5; i++) {
			System.out.println(score1[i]);
		}
		
		int[] score2;
		score2 = new int [] {100, 90, 80, 70, 60};
				
		// 배열의 내용을 단 번에 출력
		System.out.println(Arrays.toString(score2));
		
		// score.length 배열의 길이 반환 --> 배열의 요소 수를 바꿔도 문제 없이 for문에 반영
		for(int i = 0; i < score.length; i++) {
			System.out.println(score1[i]);
		}
	}

}
