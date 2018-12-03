package chapter_14;

import java.util.*;
import java.util.stream.*;

// 문자열 배열 strArr의 모든 문자열의 길이를 더한 결과를 출력하라.

class Exercise14_05 {
	public static void main(String[] args) {
		String[] strArr = { "aaa","bb","c", "dddd" };

		Stream<String> strStream = Arrays.stream(strArr);
		
		int sum = strStream.map(String::length).reduce(0, (a,b) -> a+b);
//		int sum = strStream.mapToInt(String::length).sum();
		System.out.println("sum="+sum);
	} // main() 끝.
} // 클래스 끝.