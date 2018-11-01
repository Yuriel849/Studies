package study;

// 가변배열
public class Ex07_Array07 {
	public static void main(String[] args) {
		int[][] score = new int[5][];
		
		/* 가변배열은 배열의 요소 개수가 다를 필요가 없다 --> 배열의 요소 개수를 똑같이 맞출 수도 있다.
		 * the following is an example
		 */
		score[0] = new int[4];
		score[1] = new int[3];
		score[2] = new int[2];
		score[3] = new int[2];
		score[4] = new int[3];
		
		/* score.length    --> 2차원 배열에게 length 함수를 사용하면 행의 개수를 반환한다
		 * score[A].length --> 2차원 배열의 특정 행에게 length 함수를 사용하면 그 행의 열의 개수를 반환한다
		 */
		for(int i = 0; i<score.length; i++) {
			for(int j = 0; j<score[i].length; j++) {
				score[i][j] += i;
				System.out.printf("score[%d][%d] : %d\n", i, j, score[i][j]);
			}
		}
		
//		personal experiment of mine... unfinished...
//		for(int i = 5; i > 0; i--) {
//			for(int j = 0; j < 5; j++) {
//				array[j] = new int[i];
//				for(int k = 1; k <= i; k++) {
//					for(int l = 1; l <= i; l++) {
//						array[j][i] = k;
//					}
//				}
//			}
//		}
	}

}
