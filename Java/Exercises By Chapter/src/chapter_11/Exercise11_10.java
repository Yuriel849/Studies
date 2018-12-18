package chapter_11;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

// 빙고판을  1~30 사이의 숫자로 채우고, 섞어라

class Exercise11_10 {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
//		Set set = new HashSet(); // HashSet이 순서 없지만 규칙에 따라 값을 저장한다 --> 비슷한 숫자끼리 뭉치는 현상 발생 
		Set set = new LinkedHashSet(); // 골고루 섞기 위해 순서를 유지하는 LinkedHashSet 사용한다.
		int[][] board = new int[5][5];
		
		for(int i = 0; set.size() < 25; i++) {
			set.add((int)(Math.random() * 30) + 1 + "");
		}
		
		Iterator it = set.iterator();
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				board[i][j] = Integer.parseInt((String) it.next());
				System.out.print((board[i][j] < 10 ? "  " : " ") + board[i][j]);
					// 빙고판 행과 열을 정렬하기 위하여, 값이 10보다 작으면 앞에 공백 2칸을 붙이고, 작지 않으면 공백 1칸을 붙인다.
			}
			System.out.println();
		}
	} // main() 끝.
} // 클래스 끝.