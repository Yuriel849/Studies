package chapter_13;

import java.util.*;

// WordGenerator 쓰레드가  Vector에 2초마다 단어를 하나씩 추가하고,
// 	사용자가 단어를 입력하면 Vector에서 일치하는 단어를 삭제하도록 되어 있다.
//	>> WordGenerator의 run()을 완성하라.

class Exercise13_08 {
	@SuppressWarnings("rawtypes")
	Vector words = new Vector();
	String[] data = {"태연","유리","윤아","효연","수영","서현","티파니","써니","제시카"};

	int interval = 2 * 1000; // 2초
	
	WordGenerator wg = new WordGenerator();
	
	@SuppressWarnings("rawtypes")
	public static void main(String args[]) {
		Exercise13_08 game = new Exercise13_08();
		
		game.wg.start();
	
		Vector words = game.words;
	
		while(true) {
			System.out.println(words);
			String prompt = ">>";
			System.out.print(prompt);

			// 화면으로부터 라인단위로 입력받는다.
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			String input = scan.nextLine().trim();
	
			int index = words.indexOf(input);
			if(index!=-1) {
				words.remove(index);
			}
		}
	} // main() 끝.

	class WordGenerator extends Thread {
		@SuppressWarnings("unchecked")
		public void run() {
			// 1. interval(2초)마다 배열 data의 값 중 하나를 임의로 선택해서,
			while(true) {
				int r = (int)(Math.random() * data.length);
				// 2. words에 저장한다.
				words.add(data[r]);

				try {
					Thread.sleep(interval);
				} catch(Exception e) {}
			} // while문 끝.
		} // run() 끝.
	} // WordGenerator 내부 클래스 끝.
} // 크래스  끝.