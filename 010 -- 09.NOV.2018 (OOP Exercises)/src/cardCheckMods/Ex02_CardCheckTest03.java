package cardCheckMods;

// project "Day06" --> package "study" --> file "DeckTestTest.java"

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Card {
	int num;
	String kind;
	
	Card() {
		this("S", 1);
	}
	
	Card(String kind, int num) {
		this.kind = kind;
		this.num = num;
	}
	
	public String toString() {
		return "(" + kind + "," + num + ")";
	}
}

class CardCheckMod3 {
		// 강사님 코드 (INCOMPLETE)
	String rankCheck(Card[] cArr) {
		// 카드 숫자 범위 1 ~ 13
		int[] cntArr = new int[14];
		String rank = "No rank";
		int pairCnt = 0; // pair 개수 카운트
		
		// 카운팅
		for(int i = 0; i < cArr.length; i++) {
			cntArr[cArr[i].num]++;
		}
		
		// 카운팅한 결과를 읽는다.
		for(int i = 0; i < cntArr.length; i++) {
			if(cntArr[i] == 2 ) { pairCnt++; }
			if(cntArr[i] == 3 ) { rank = "THREE CARD"; }
			if(cntArr[i] == 4 ) { rank = "FOUR CARD"; }
		}
		
		// STRAIGHT인지 확인
		
		// FLUSH인지 확인 (모든 같은 무늬인지 확인)
		String kind = cArr[0].kind;
		
		int i = 1;
		for(; i < cArr.length; i++) {
			if(!(kind.equals(cArr[i].kind))) { break; }
		}
		if(i == 5) { rank = "FLUSH"; }
		
		return kind;
	}
	
	// 5개의 숫자가 연속이면 "STRAIGHT"
	@Test
	void test() {
		Card[] cArr = {
			new Card("S", 1), new Card("C", 2), new Card("H", 3),
			new Card("H", 4), new Card("D", 5)
		};
		assertTrue(rankCheck(cArr).equals("STRAIGHT"));
	}
	
	// 같은 숫자의 카드가 한 쌍이면 "1 PAIR"
	@Test
	void test2() {
		Card[] cArr = {
			new Card("C", 1), new Card("C", 3), new Card("H", 5),
			new Card("H", 1), new Card("D", 2)
		};
		assertTrue(rankCheck(cArr).equals("1 PAIR"));
	}
	
	// 같은 숫자의 카드가 2쌍이면 "2 PAIR"
	@Test
	void test3() {
		Card[] cArr = {
			new Card("H", 1), new Card("D", 4), new Card("H", 4),
			new Card("S", 1), new Card("D", 3)
		};
		assertTrue(rankCheck(cArr).equals("2 PAIR"));
	}
	
	// 같은 숫자의 카드가 3장이면 "THREE CARD"
	@Test
	void test4() {
		Card[] cArr = {
			new Card("C", 1), new Card("C", 4), new Card("H", 4),
			new Card("D", 4), new Card("D", 1)
		};
		assertTrue(rankCheck(cArr).equals("THREE CARD"));
	}

	// 같은 숫자의 카드가 4장이면 "FOUR CARD"
	@Test
	void test5() {
		Card[] cArr = {
			new Card("D", 1), new Card("S", 1), new Card("H", 1),
			new Card("H", 1), new Card("D", 5)
		};
		assertTrue(rankCheck(cArr).equals("FOUR CARD"));
	}
	
	// 모든 카드의 무늬가 같으면 "FLUSH"
	@Test
	void test6() {
		Card[] cArr = {
			new Card("H", 1), new Card("H", 2), new Card("H", 1),
			new Card("H", 4), new Card("H", 3)
		};
		assertTrue(rankCheck(cArr).equals("FLUSH"));
	}
	
	// 모든 카드의 무늬도 같고 5개의 숫자도 연속되면 "STRAIGHTFLUSH"
	@Test
	void test7() {
		Card[] cArr = {
			new Card("H", 1), new Card("H", 2), new Card("H", 3),
			new Card("H", 4), new Card("H", 5)
		};
		assertTrue(rankCheck(cArr).equals("STRAIGHTFLUSH"));
	}
}
