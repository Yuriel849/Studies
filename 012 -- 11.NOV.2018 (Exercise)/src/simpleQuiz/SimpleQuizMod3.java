package simpleQuiz;

import java.util.Scanner;

// data의 내용을 문제, 답, 선택지로 나눠서 출력하지만 반복문을 이용하면서 계속 기존 내용을 덮어쓴다.
class SimpleQuizMod3 { 
	public static void main(String[] args) { 
		String[] data = { 
				"다음 중 키워드가 아닌 것은?`2`final`True`if`public", 
                "다음 중 자바의 연산자가 아닌 것은?`6`&`|`++`!=`/`^", 
                "다음 중 메서드의 반환값이 없음을 의미하는 키워드는?`1`void`null`false", 
			}; 
		
		Scanner scan = new Scanner(System.in);
		int score = 0; // 사용자가 맞춘 문항의 개수
		
		shuffle(data); // 우선 문제의 순서를 섞는다 --> 문제, 답, 선택지로 나누고 나서 섞으려면 복잡해서 미리 한다.
		
		String question; // 문제를 저장하기 위한 문자열 변수
		String answer; // 문제의 답을 저장하기 위한 문자열 변수
		String select; // 사용자가 선택한 답을 저장하기 위한 문자열 변수
		String[] temp; // data를 split으로 나눴을 때 반환되는 문자열을 임시로 보관하기 위한 문자열 배열
		String[] choices; // data 중에서 선택지만 split으로 나눈 후 보관하기 위한 문자열 배열
		
		for(int i=0;i<data.length;i++) {
			// 문제와 답과 선택지를 나눈다.
			temp = data[i].split("`", 3);
			question = temp[0];
			answer = temp[1];
			choices = temp[2].split("`");

			// 선택지를 섞기 전, answer에 답을 저장한다.
			answer = choices[Integer.parseInt(answer) - 1]; // answer에는 답에 해당하는 번호가 아니라 문자열이 저장된다
			
			// 선택지를 섞는다.
			shuffle(choices);
			
			// 문제를 출력한다.
			System.out.println("[" + (i+1) + "] " + question);
			
            // 반복문을 이용해서 선택지를 출력한다.
			for(int j = 0; j < choices.length; j++) {
				System.out.print((j+1) + "." + choices[j] + "\t");
				if(answer == choices[j]) { answer = String.valueOf(j+1); }
					/* answer에 저장된 문자열에 해당하는 choice의 index 값 j를 저장한다.
					 * 	>> 사용자는 숫자(j+1)를 입력하기 때문에 answer도 숫자로 바뀌어야 한다.
					 */
			}
			System.out.println();
			
			// 사용자의 입력을 받는다.
			System.out.print("[답] ");
			select = scan.next();
			
			// 사용자의 입력한 값이 정답과 일치한다면 정답개수를 1증가한다.
			if(select.equals(answer)) { score++; System.out.println("run");}
			System.out.println();
		} // for문 종료
		
		// 사용자가 몇 개 중에 몇 개를 맞췄는지 출력한다.
		System.out.println("정답개수 / 전체문항개수 : " + score + "/" + data.length);
	} // main() 종료
	
	public static void shuffle(String[] data) {
		// 배열 data의 개수가 0보다 작거나 같으면 메서드를 종료한다.
		if(data.length <= 0) { return; }

		// 2. 선택지의 순서를 섞는다. 반복문 & Math.random() 사용하라.
		for(int i = 0; i < 10; i++) {
			int r = (int)(Math.random() * (data.length));
			int s = (int)(Math.random() * (data.length));
			String temp = data[r];
			data[r] = data[s];
			data[s] = temp;
		}
	} // shuffle() 종료
}