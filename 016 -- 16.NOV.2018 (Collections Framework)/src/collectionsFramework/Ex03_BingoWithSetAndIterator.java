package collectionsFramework;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

class Ex03_BingoWithSetAndIterator {
	public static void main(String[] args) {
//		Set set = new HashSet(); // HashSet이 순서는 없지만 나름의 규칙에 따라 값을 저장한다 --> 아래 코드를 실행하면 비슷한 숫자끼리 뭉치는 현상 발생 
		Set set = new LinkedHashSet(); // 골고루 섞기 위해 순서를 유지하는 LinkedHashSet 사용한다.
		int[][] board = new int[5][5];
		
		for(int i = 0; set.size() < 25; i++) {
			set.add((int)(Math.random()*50) + 1 + ""); // 끝에 빈문자열과 덧셈연산하면서 임의의 정수값은 문자열 형태로 add된다.
		}
		
		Iterator it = set.iterator();
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				board[i][j] = Integer.parseInt((String)it.next());
				System.out.print((board[i][j] < 10 ? "  " : " ") + board[i][j]);
			}
			System.out.println();
		}
	} // main() 끝.
} // 클래스 끝.
