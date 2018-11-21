package chapter_4;

// 1과 6 사이의 난수를 반환하라.

public class Exercise4_07 {
	public static void main(String[] args) {
		int value = (int)(Math.random() * 6 + 1);
		
		System.out.println("value : " + value);
	} // main() 끝.
} // 클래스 끝.