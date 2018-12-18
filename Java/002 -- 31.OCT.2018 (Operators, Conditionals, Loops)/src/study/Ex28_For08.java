package study;

import java.util.ArrayList;

public class Ex28_For08 {
	public static void main(String[] args) {
		// 일반 for문
		for(int i=0; i<9; i++) {
			System.out.println(i);
		}
				
		// 향상된 for문... 자료구조 Collection과 관련
		ArrayList<String> list = new ArrayList<String>();
		// list는 새로 만들어진 ArrayList<String>의 위치를 나타내는 주소값을 저장하고 있다
		/* <>... generic하다
		* 일반 배열은 같은 자료형의 데이터만 받아들일 수 있다... char로 선언한 배열은 char만
		* 자료구조 ArrayList는 서로 다른 자료형도 같이 저장할 수 있다... 하지만 같은 자료형만 모아놓는 것이 효율적
		* <> 속에 자료형을 지정하면 이 ArrayList는 그 자료형의 데이터만 저장할 수 있게 잠긴다
		*/
				
		list.add("딸기");
		list.add("사과");
		list.add("수박");
		list.add("포도");
		list.add("망고");
				
		// enhanced for
		for(String fruit : list) {
		/* list에서 반복할 때마다 순서대로 데이터를 꺼내서 fruit 변수에 저장
		* 첫번째 반복에는 fruit = 딸기, 두번째 반복에는 fruit = 사과...
		*/
		System.out.println(fruit);
		}
	}
}