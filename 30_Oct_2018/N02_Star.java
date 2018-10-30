package study;

public class N02_Star {
	public static void main(String[] args) {
		// sysout 입력 후 ctrl + space --> System.out.println();
		System.out.println();

		// ctrl + "/" --> 주석처리
//		System.out.println("Hello");
//		System.out.println("Hello");
//		System.out.println("Hello");
//		System.out.println("Hello");
//		System.out.println("Hello");
		
		// ctrl + "+" & ctrl + "-" --> 글씨 크기 키우기 & 줄이기
		// ctrl + "D" --> 해당 줄 삭제
		
		System.out.println("특정 위치에만 (x, y)좌표 출력 >>");
		// for 문 - 반복문, 1~5까지 모두 5번 반복
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= 5; j++) { // for 문 시작
			// alt + arrow key --> 해당 줄 위/아래 이동
				if (i == j) { // i & j가 같을 때
					System.out.print("[" + i + "," + j + "]");
				} else { // i & j가 같지 않을 때
					System.out.print("- - -"); // 빈칸 5칸 출력 ([i,j]가 5칸이기에)
				}
				
			}
			System.out.println();
		} // for 문 끝
		
		System.out.println("\n특정 위치에만 \"STAR\" 출력 >>");
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= 5; j++) {
				if (i == j) {
					System.out.print("(STAR)");
				} else {
					System.out.print("------");
				}
				
			}
			System.out.println();
		}

		System.out.println("\n영어 알파벳 역순으로 출력하기 >>");
		for(char ch1 = 'z'; ch1 >= 'a'; ch1--) {
			for(char ch2 = 'a'; ch2 <= 'z'; ch2++) {
				if (ch2 < ch1) {
					System.out.print(" ");
				} else {
					System.out.print(ch2);
				}
				
			}
			System.out.println();
		}
		
		System.out.println("\n1~9까지 역순으로 출력하기 >>");
		for(int i = 9; i > 0; i--) {
			System.out.print("     ");
			for(int j = 1; j <= 9; j++) {
				if (j < i) {
					System.out.print(" ");
				} else {
					System.out.print(j);
				}
				
			}
			System.out.println();
		}

	}
}
