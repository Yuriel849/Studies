package chapter_05;

// 배열 star를 시계방향으로 90도 회전시켜서 출력하라.

class Exercise05_09 {
	public static void main(String[] args) {
		char[][] star = {
				{'*', '*', ' ', ' ', ' '},
				{'*', '*', ' ', ' ', ' '},
				{'*', '*', '*', '*', '*'},
				{'*', '*', '*', '*', '*'},
		};
		
		char[][] result = new char[star[0].length][star.length];
		
		// 배열 star를 있는 그대로 출력.
		for(int i = 0; i < star.length; i++) {
			for(int j = 0; j < star[i].length; j++) {
				System.out.print(star[i][j]);
			}
			System.out.println();
		} // for문 끝.
		
		System.out.println();
		
		// 배열 star를 시계방향으로 90도 회전시켜서 출력.
		for(int i = 0; i < star.length; i++) {
			for(int j = 0; j < star[i].length; j++) {
				result[j][star.length-(1+i)] = star[i][j];
			}
		} // for문 끝.
		
		for(int i = 0; i < result.length; i++) {
			for(int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j]);
			}
			System.out.println();
		} // for문 끝.
	} // main() 끝.
} // 클래스 끝.