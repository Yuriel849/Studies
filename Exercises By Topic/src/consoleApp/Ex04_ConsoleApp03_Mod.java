package consoleApp;

import java.util.LinkedList;
import java.util.Scanner;

// enhanced for & regex(" +")쓸 수 있도록 업데이트 (12NOV2018의 ConsoleAppMod2 참조하기...)

// 사용자가 입력한 명령라인을 save(String input)메서드로 저장하고 history()메서드로 사용자의 입력 이력을 보여주는 예제
class Ex04_ConsoleApp03_Mod {
	static String[] argArr; // 사용자 입력을 담기위한 문자열 배열
	static LinkedList q = new LinkedList(); // 사용자의 입력을 저장할 queue로서 LinkedList 클래스의 객체 생성
	static final int MAX_SIZE = 5; // q의 최대 크기
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = "";
		String command = "";
		while(true)	{
			String prompt = ">> ";
			System.out.print(prompt);
			
			// 화면으로부터 라인단위로 입력받는다.
			input = scan.nextLine();
			
			// 입력값을 q에 저장한다
			save(input);
			
			// 입력 받은 값에서 앞뒤 공백을 제거한다
			input.trim();
			
			// 입력 받은 명령라인의 내용을 공백을 구분자로 해서 나눠서 argArr에 담는다. (String 클래스의 split() 사용)
			argArr = input.split(" +");
				// split의 인수로는 정규식을 줘야 하는데, " +"의 의미는 + 앞의 문자(여기서는 공백)가 한 개 혹은 그 이상이라는 의미다.
			
			// input을 split()한 후 그 첫번째 내용을 command에 대입한다.
			command = argArr[0].trim();
			
			// 0번째 요소가 공백이면 while을 다음 반복을 continue한다.
            if("".equals(command)) { continue; } 

            // 명령어를 소문자로 바꾼다.
            command = command.toLowerCase(); 

            if(command.equals("q")) { // q 또는 Q를 입력하면 실행종료한다. 
                  System.out.println("Thank you for utilizing our services :)");
                  System.exit(0); 
            } else if(command.equals("history")) {  // equalsIgnoreCase대신 equals를 사용.
                  history(); 
            } else {
            	for(String str : argArr) {
            		System.out.println(str);
            		// split()에 정규식 " +"을 사용하면서 여기서 빈 문자열인지 확인할 필요가 없다.
//					if(str.equals("")) { continue; }
//						/* 빈 문자열이면 continue인 이유 >>
//						 * ex) 사용자 입력 --> "1 2  3   4" --> 1 & 2 사이에 공백 한 칸, 2 & 3 사이에 공백 2칸, 3 & 4 사이에 공백 3칸
//						 * 	>> 공백을 기준으로 나누니까 (split(" ")) 공백 앞뒤가 각각 다른 문자열에 저장
//						 * 	>> 문제는 공백이 2칸 이상일 때 --> 공백 여러칸을 공백을 기준으로 나누면, 각 공백과 공백 사이는 아무것도 없다
//						 * 	>> 아무것도 없으니까 argArr에서 해당 칸은 빈 문자열이 저장된다
//						 */
//					else { System.out.println(str); }
				} // for문 끝.
            } // if-else문 끝.
		} // while(true) 끝.
	} // main() 끝.
	
	// 사용자의 입력을 q에 저장하는 메서드
	public static void save(String input) { 
		if(input==null || "".equals(input)) { return; }
			// queue의 최대크기(MAX_SIZE)를 넣으면 제일 오래된 저장값을 삭제한다.
		else if(q.size() == MAX_SIZE) { q.remove(0); }
			// queue에 저장한다.
		q.add(input);
	} // save() 끝.

	// 사용자가 입력한 최근 명령을 보여주는 메서드
	public static void history() { 
		int i = 0;
			// LinkedList에 저장된 내용(최근 MAX_SIZE개의 명령어)을 보여준다.
		for(; i < MAX_SIZE; i++) {
			System.out.println((i+1) + "." + q.get(i));
		}
	} // history() 끝.
} // class 끝.
