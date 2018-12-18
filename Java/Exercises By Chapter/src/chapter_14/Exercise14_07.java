package chapter_14;

import java.util.Random;
import java.util.stream.*;

// 임의의 로또번호(1~45)를 정렬해서 출력하라.

class Exercise14_07 {
	public static void main(String[] args) {
		IntStream intSt = new Random().ints(6, 1, 46);
		
		intSt.sorted().forEach(System.out::println);
	} // main() 끝.
} // 클래스 끝.