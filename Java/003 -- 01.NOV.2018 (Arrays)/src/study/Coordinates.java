package study;

public class Coordinates {
	public static void main(String[] args) throws Exception {
		// 좌표 찍기 --> 먼저 전체 좌표의 위치 확인
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= 5; j++) {
				if(true) {
					System.out.print("[" + i + "," + j + "]");
				} else {
					System.out.print("     ");
				}
			}
			System.out.println();
		}
		System.out.println();
		
		// 찍기 싶은 좌표만 찍을 조건을 넣기
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= 5; j++) {
				if(i >= j) {
					System.out.print("[" + i + "," + j + "]");
				} else {
					System.out.print("     ");
				}
			}
			System.out.println();
		}
		System.out.println();
		
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= 5; j++) {
				if(i<=j) {
					System.out.print((char) (j+'A'-i));
				} else {
					System.out.print("     ");
				}
			}
			System.out.println();
		}
		
	}

}
