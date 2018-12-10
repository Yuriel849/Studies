package collectionsFramework;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Ex02_FillSetTest {
	public static void main(String[] args) {
		Set set = new HashSet();
		
		// 임의의 값으로 set 채우기
		for(int i = 0; set.size() < 10; i++) { // 중복되는 값은 입력 실패하기에, 실제 반복 횟수는 3보다 많을 수 있다.
			int r = (int)(Math.random()*100) + 1;
			set.add(r);
			System.out.println("r = " + r);
		}
		System.out.println(set);
		
		// set 값들을 정렬하기
		List list = new LinkedList(set); // LinkedList(Collection c) 생성자 사용
		Collections.sort(list); // 매개변수가 list, set은 사용할 수 없다.
		System.out.println(list);

	}

}
