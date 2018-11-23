package chapter_04;

// 2개의 주사위를 던져서 눈의 합이 6일때만 출력하는 프로그램을 작성하라.

public class Exercise04_06 {
	public static void main(String[] args) {
		for(int i = 1; i < 7; i++) {
			for(int j = 1; j < 7; j++) {
				if(i+j == 6) {
					System.out.printf("[ i = %d, j = %d ]\n", i, j);
				}
			}
		} // 바깥 for문.
	} // main() 끝.
} // 클래스 끝.