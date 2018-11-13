package console;

import java.util.Scanner;

// 사용자가 입력한 명령라인을 공백(' ')을 구분자로 해서 잘라서 배열에 저장한 다음에 배열의 내용을 출력하는 예제
class ConsoleAppMod1 {
	static String[] argArr;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = "";
		
		while(true)	{
			String prompt = ">> ";
			System.out.print(prompt);
			
			// 화면으로부터 라인단위로 입력받는다.
			input = scan.nextLine();
			
			// 입력 받은 값에서 앞뒤 공백을 제거한다
			input.trim();
			
			// 입력 받은 명령라인의 내용을 공백을 구분자로 해서 나눠서 argArr에 담는다. (String 클래스의 split() 사용)
			argArr = input.split(" ");
			
			// q 또는 Q를 입력하면 실행종료한다.
			if(input.equalsIgnoreCase("q")) {
				// break; --> while문 벗어나는 것
				System.exit(0); // --> 프로그램 종료하는 것
			} else {
				for(String str : argArr) {
					if(str.equals("")) { continue; }
						/* 빈 문자열이면 continue인 이유 >>
						 * ex) 사용자 입력 --> "1 2  3   4" --> 1 & 2 사이에 공백 한 칸, 2 & 3 사이에 공백 2칸, 3 & 4 사이에 공백 3칸
						 * 	>> 공백을 기준으로 나누니까 (split(" ")) 공백 앞뒤가 각각 다른 문자열에 저장
						 * 	>> 문제는 공백이 2칸 이상일 때 --> 공백 여러칸을 공백을 기준으로 나누면, 각 공백과 공백 사이는 아무것도 없다
						 * 	>> 아무것도 없으니까 argArr에서 해당 칸은 빈 문자열이 저장된다
						 */
					else { System.out.println(str); }
				} // for문의 끝.
			} // if-else문의 끝.
		} // while(true)의 끝.
	} // main()의 끝.
} // class의 끝.
