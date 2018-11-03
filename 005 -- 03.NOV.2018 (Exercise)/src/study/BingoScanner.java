package study;

import java.util.Scanner;

public class BingoScanner {
	public static int main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input = 0;
		do {
			System.out.println("숫자 하나를 입력하세요 (1 ~ 25) >>");
			System.out.print("입력을 취소하시려면 음수를 입력하세요.");
			// printf()에서만 \n을 %n로 대체할 수 있다!!!
			input = scan.nextInt();
			if (input < 0) {
				System.out.println("입력을 취소하셨습니다.");
				System.out.println("원래 값대로 출력합니다.");
				break;
			}
//			if(input >= 1 && input <= 25) {
//				break;
//			}
		} while (input < 1 || input > 25);
		
		return input;
	}

}
