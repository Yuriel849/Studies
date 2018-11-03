package study;

public class Ex06_Variable05 {
	public static void main(String args[]) {
		// 세 과목의 총점과 평균 구하기
		int score1 = 90;
		int score2 = 97;
		int score3 = 94;
		
		// 총점 저장 변수
		int total;
		
		// 평균 저장 변수
		float average;
		
		// +, -, *, /
		total = score1 + score2 + score3;
		average = total / 3.0F;
		// average = total / (float) 3;
		// average = (float) total / 3;
		
		/* 이것은 안된다!!
		 * 		>> average = (float)(total / 3); == average = total / 3;
		 *  	>> 이미 괄호 속에서 total/3하고 소수점을 버린 후 결과물을 float로 바꿀뿐이다
		 */
		
		// printf() 메소드로 출력하기
		System.out.printf("총점 : %d점, 평균 : %.2f점", total, average);
	}
	
}
