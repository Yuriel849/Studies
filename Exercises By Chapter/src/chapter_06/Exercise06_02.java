package chapter_06;

// SutdaCard 클래스를 작성하라.

public class Exercise06_02 {
	public static void main(String[] args) {
		SutdaDeck deck = new SutdaDeck();
		
		System.out.println("Original deck in order >>");
		for(int i = 0; i < deck.cards.length; i++) {
			System.out.print(deck.cards[i] + ", ");
		}
		
		System.out.println("\n1st element >> " + deck.pick(0));
		System.out.println("Random element >> " + deck.pick());
		deck.shuffle();
		
		System.out.println("\nShuffled deck >>");
		for(int i = 0; i < deck.cards.length; i++) {
			System.out.print(deck.cards[i] + ", ");
		}
		System.out.println("\n1st element >> " + deck.pick(0));
	}
}

class SutdaDeck {
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];

	SutdaDeck() {
		// 배열 SutdaCard를 적절히 초기화 하시오.
		for(int i = 0; i < CARD_NUM; i++) {
			if(i < 10) {
				if(i == 0 || i == 2 || i == 7) {
					cards[i] = new SutdaCard(i+1, true);
				} else { cards[i] = new SutdaCard(i+1, false); }
			} else { cards[i] = new SutdaCard(i-9, false); }
			
			/* int num = i % 10 + 1;
			 * boolean isKwang = (i < 10) && (num == 1 || num == 3 || num == 8);
			 * cards[i] = new SutdaCard(num, isKwang);
			 */
		}
	}
	
	// 배열 cards에 담긴 카드의 위치를 뒤섞는다. (Math.random() 사용)
	void shuffle() {
		SutdaCard temp;
		for(int i = 0; i < 100; i++) {
			int ra = (int)(Math.random() * 19 + 1);
			// cards[0] & cards[ra]의 값을 서로 바꾼다.
			temp = cards[0];
			cards[0] = cards[ra];
			cards[ra] = temp;
		}
	}
	
	// 배열 cards에서 지정된 위치의 SutdaCard를 반환한다.
	SutdaCard pick(int index) {
		// 유효성체크
		if(index < 0 || index >= CARD_NUM) { return null; }
		return cards[index];
	}
	
	// 배열 cards에서 임의의 위치의 SutdaCard를 반환한다. (Math.random() 사용)
	SutdaCard pick() {
		int r = (int)(Math.random() * 20);
		return cards[r]; // pick(int index)를 호출한다.
	}
} // SutdaDeck 종료

class SutdaCard {
	final int NUM; // SutdaCard 클래스 외부에서 카드의 숫자와 종료를 수정할 수 없게 만듦.
	final boolean IS_KWANG;
	
	SutdaCard() {
		this(1, true);
	}
	
	SutdaCard(int num, boolean isKwang) {
		this.NUM = num;
		this.IS_KWANG = isKwang;
	}
	
	// info() 대신 Object 클래스의 toString()을 오버라이딩했다.
	public String toString() {
		return NUM + ( IS_KWANG ? "K" : "");
	}
}