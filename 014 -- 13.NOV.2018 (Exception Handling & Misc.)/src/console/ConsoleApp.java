package console;

import java.util.Scanner;

class ConsoleApp {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = "";
		while(true)	{
			String prompt = ">> ";
			System.out.print(prompt);
			
			// 화면으로부터 라인단위로 입력받는다.
			input = scan.nextLine();
			
			// q 또는 Q를 입력하면 실행종료한다.
			if(input.equalsIgnoreCase("q")) {
				// break; --> while문 벗어나는 것
				System.exit(0); // --> 프로그램 종료하는 것
			}
			
		} // while(true)의 끝.
	} // main()의 끝.
} // class의 끝.
