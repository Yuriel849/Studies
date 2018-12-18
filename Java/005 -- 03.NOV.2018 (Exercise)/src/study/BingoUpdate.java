package study;

public class BingoUpdate {
	public static void main(String[] args) {
		// 1. 5X5 2차원 배열 선언
		int[][] array = new int[5][5]; 
		
		// 2. 배열에 1 ~ 25 값 입력 (초기화)
		int add = 1;
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				array [i][j] = add;
				add++;
			}
		}
		
		// 3. 2차원 형태로 배열 출력
		System.out.println("5 X 5 2차원 배열 : ");
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				System.out.printf("%2d ", array[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		
		// 4. 섞기
		int a = 0, b = 0;
		int temp = 0;
		for(int i = 0; i < 100; i++) {
			a = (int) (Math.random() * 5);
			b = (int) (Math.random() * 5);
			temp = array[0][0];
			array[0][0] = array[a][b];
			array[a][b] = temp;
		}
		
		// 5. 사용자 입력 받기
		int input = BingoScanner.main(null);
		
		// 6. 사용자가 입력한 값과 일치하는 값을 찾아서 0으로 바꾸기 
		search : for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				if(array[i][j] == input) {
					array[i][j] = 0;
					break search;
				}
			}
		}
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				System.out.printf("%2d ", array[i][j]);
			}
			System.out.println();
		}
	}

}
