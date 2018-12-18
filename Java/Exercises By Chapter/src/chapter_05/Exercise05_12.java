package chapter_05;

import java.util.Scanner;

class Exercise05_12 {
	public static void main(String[] args) {
		String[][] words = {
				{"chair", "의자"}, // words[0][0], words[0][1]
				{"computer", "컴퓨터"}, // words[1][0], words[1][1]
				{"integer", "정수"} // words[2][0], words[2][1]
		};
		
		int cnt = 0; // 맞춘 문제의 수를 저장하기 위한 변수
		
		Scanner scan = new Scanner(System.in);
		
		for(int i = 0; i < words.length; i++) {
			System.out.printf("Q%d. %s의 뜻은? ", i+1, words[i][0]);
			
			String tmp = scan.nextLine();
			
			if(tmp.equals(words[i][1])) {
				System.out.printf("정답입니다.%n%n");
				cnt++;
			} else {
				System.out.printf("틀렸습니다. 정답은 %s입니다.%n%n", words[i][1]);
			}
		} // for문 끝.
		
		System.out.printf("전체 3문제 중 %d문제 맞추셨습니다.", cnt);
	} // main() 끝.
} // 클래스 끝.