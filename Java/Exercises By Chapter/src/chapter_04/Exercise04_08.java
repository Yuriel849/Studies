package chapter_04;

// 2x + 4y = 10의 모든 해를 구하라 (0<=x<=10, 0<=y<=10)

public class Exercise04_08 {
	public static void main(String[] args) {
		for(int x = 0; x <= 10; x++) {
			for(int y = 0; y <= 10; y++) {
				if(2*x + 4*y == 10) {
					System.out.println("x = " + x + ", y = " + y);
				}
			}
		} // 바깥 for문.
	} // main() 끝.
} // 클래스 끝.