package study;

public class Ex11_Array11 {
	public static void main(String[] args) {
		// 1. 5X5 2차원 배열 선언
		int[][] array = new int[5][5]; 
		
		// 2. 배열에 1 ~ 25 값 입력 (초기화)
		int add = 1;
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				array [i][j] = add;
				add++;
			}
		}
		
		// 3. 2차원 형태로 배열 출력
		System.out.println("5 X 5 2차원 배열 : ");
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
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
		System.out.println("5 X 5 배열 섞은 후: ");
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.printf("%2d ", array[i][j]);
			}
			System.out.println();
		}
	}

}
