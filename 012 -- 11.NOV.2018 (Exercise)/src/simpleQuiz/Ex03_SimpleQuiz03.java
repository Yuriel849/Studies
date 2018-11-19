package simpleQuiz;

import java.util.Scanner;

// data의 내용을 문제, 답, 선택지로 나눠서 출력하지만 반복문을 이용하면서 계속 기존 내용을 덮어쓴다.
class Ex03_SimpleQuiz03 { 
	public static void main(String[] args) { 
		String[] data = { 
				"다음 중 키워드가 아닌 것은?`2`final`True`if`public", 
                "다음 중 자바의 연산자가 아닌 것은?`6`&`|`++`!=`/`^", 
                "다음 중 메서드의 반환값이 없음을 의미하는 키워드는?`1`void`null`false", 
			}; 
		
		Scanner scan = new Scanner(System.in);
		int score = 0; // 사용자가 맞춘 문항의 개수
		
		String question, answer, select; // data를 문제 & 답로 나눠서 저장하고, 사용자의 선택을 저장하기 위한 문자열 변수
		String[] temp, choices; // data를 split으로 나눴을 때 반환되는 문자열을 임시로 저장하기 위한 문자열 배열
							    // data 중에서 선택지만 split으로 나눈 후 저장하기 위한 문자열 배열
		for(int i=0;i<data.length;i++) {
			// 1. String클래스의 String[] split(String regex, int limit)를 사용해서 문제와 선택지를 나누세요.
			temp = data[i].split("`", 3);
			question = temp[0];
			answer = temp[1];
			choices = temp[2].split("`");

			// 2. 문제를 출력하세요.
			System.out.println("[" + (i+1) + "] " + question);

            // 3. 반복문을 이용해서 선택지를 출력하세요.
			for(int j = 0; j < choices.length; j++) {
				System.out.print((j+1) + "." + choices[j] + "\t");
			}
			System.out.println();
			
			// 4. 사용자의 입력을 받으세요.
			System.out.print("[답] ");
			select = scan.next();
			
			// 5. 사용자의 입력한 값이 정답과 일치한다면 정답개수를 1증가하세요.
			if(select.equals(answer)) { score++; }
			System.out.println();
		} // for문 종료
		
		// 6. 사용자가 몇 개 중에 몇 개를 맞췄는지 출력하세요.
		System.out.println("정답개수 / 전체문항개수 : " + score + "/" + data.length);
	} // main() 종료 
}