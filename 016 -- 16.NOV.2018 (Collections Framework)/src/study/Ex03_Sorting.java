package study;

import java.util.ArrayList;
import java.util.Collections;

public class Ex03_Sorting {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		
		for(int i = 10; i >= 0; i--) {
			list.add(new Integer(i));
		}
		System.out.println(list);
		
		Collections.sort(list); // 정렬이 된다 --> 그런데 나는 정렬의 기준을 안 줬는데??
						// 사실 Collections.sort()에는 매개변수가 2개 --> 두번째 매개변수가 사용자가 지정할 수 있는 정렬기준용 매개변수
						// 여기서는 객체인 Integer가 "오름차순" 정렬기준 기본값을 가지고 있고, 그 기본값을 Collections.sort()에게 제공한다
		System.out.println(list);

	}

}
