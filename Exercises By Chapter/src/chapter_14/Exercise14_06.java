package chapter_14;

import java.util.*;
import java.util.stream.*;

// 문자열 배열 strArr의 문자열 중에서 가장 긴 것의 길이를 출력하라.

class Exercise14_06 {
	public static void main(String[] args) {
		List<String> strList = Arrays.asList("aaa","bb","c", "dddd");
		Stream<String> strStream = strList.stream();
		
		Optional<String> result = strStream.max(Comparator.comparingInt(String::length));
		System.out.println(result.get().length());
		
		// Alternate solution
//		String[] strArr = { "aaa","bb","c", "dddd" };
//		Stream<String> strStream = Stream.of(strArr);
//		strStream.map(String::length) // strStream.map(s-> s.length())
//				 .sorted(Comparator.reverseOrder()) // 문자열 길이로 역순 정렬
//				 .limit(1).forEach(System.out::println); // 제일 긴 문자열의 길이 출력
	} // main() 끝.
} // 클래스 끝.