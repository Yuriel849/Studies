package chapter_09;

// SutdaCard 클래스의 equals()가 멤버변수 num & isKwang의 값을 비교하도록 오버라이딩하라.

class Exercise09_01 {
	public static void main(String[] args) {
		SutdaCard c1 = new SutdaCard(3, true);
		SutdaCard c2 = new SutdaCard(3, true);
		
		System.out.println("c1 = " + c1);
		System.out.println("c2 = " + c2);
		System.out.println("c1.equals(c2) : " + c1.equals(c2));
	} // main() 끝.
} // 클래스 끝.

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
	
	public boolean equals(Object obj) {
		if(obj instanceof SutdaCard) {
			SutdaCard sutdaC = (SutdaCard) obj;
			return (this.IS_KWANG == sutdaC.IS_KWANG && this.NUM == sutdaC.NUM);
		}
		return false;
	}
	
	public String toString() {
		return NUM + ( IS_KWANG ? "K" : "");
	}
} // SutdaCard 클래스 끝.