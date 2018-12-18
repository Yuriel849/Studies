package study;

public class Ex_Array01 {
	public static void main(String[] args) {
		// 1. 5X5 2차원 배열 만든다 --> bingo[0][0] - bingo [4][4]
		int[][] bingo = new int[5][5]; 
		
		// 2. 1 ~ 25 의 숫자로 초기화
		int cnt = 0;
		for(int i = 0; i < bingo.length; i++) {
			for(int j = 0; j < bingo[i].length; j++) {
				bingo[i][j] = ++cnt; // cnt 사용하는 대신 --> i*5+j+1
			}
		}
		
		// 3. 배열의 모든 요소를 출력
		for(int i = 0; i < bingo.length; i++) {
			/* 2번째 for문 & print(bingo[i][j]) 사용하는 대신 2차원 배열은 1차원 배열의 집합이라는 특성 사용
			 * 		>> System.out.println(Arrays.toString(bingo[i]));
			 */
			for(int j = 0; j < bingo[i].length; j++) {
				System.out.printf("%2d ", bingo[i][j]);
			}
			System.out.println();
		}
		
		// 4. 각 요소의 순서를 바꾼다 (섞는다)
		for(int i = 0; i < bingo.length; i++) {
			for(int j = 0; j < bingo[i].length; j++) {
				int x = (int)(Math.random()*5);
				int y = (int)(Math.random()*5);
				
				int tmp = bingo[i][j];
				bingo[i][j] = bingo [x][y];
				bingo[x][y] = tmp;
			}
		}
		
		// 5. 배열의 모든 요소 다시 출력
		System.out.println();
		for(int i = 0; i < bingo.length; i++) {
			for(int j = 0; j < bingo[i].length; j++) {
				System.out.printf("%2d ", bingo[i][j]);
			}
			System.out.println();
		}
	}

}
