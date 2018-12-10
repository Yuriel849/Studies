package collectionsFramework;

import java.util.Set;
import java.util.TreeSet;

// TreeSet은 객체가 Comparable을 구현하던가 별도의 Comparator가 필요하다
// 	>> 이 상태로는 실행 시 에러!

class Ex05_TreeSetTest {
	public static void main(String[] args) {
		Set set = new TreeSet();
		
		set.add(new Student("홍길동", 50, 15));
		set.add(new Temp()); // 에러! --> Temp에 Comparable이 들어 있거나, 별도의 Comparator를 제공해야 한다.
	} // main() 끝.
} // Student 클래스 끝.

class Temp { }

