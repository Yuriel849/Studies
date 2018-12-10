package generics;

import java.util.List;
import java.util.Optional;

class Ex03_GenericsTest {
	public static void main(String[] args) {
		// 1.
		Optional<Object> op = new Optional<String>(); // 에러! --> 서로 지네릭타입이 Object & String으로 불일치!
		
		// 2.
		Optional<?> op2 = new Optional<String>(); // 가능!
			// "?" == "? extends Object" --> Object의 child 타입 모두 사용 가능 --> 제약 없이 그 어떤 타입이여도 사용 가능 
		// 3.
		Optional<String> op3 = new Optional<String>(); // 가능!
			// 그래도 에러나는 이유는 Optional 클래스의 생성자가 private이기 때문
		
		// 4.
		Optional<? extends List> op4 = new Optional<Integer>(); // List 클래스의 child 클래스이기만 하면 어떤 타입이여도 사용 가능
		// 5.
		Optional<? super List> op5 = new Optional<Integer>(); // List 클래스의 parent 클래스의 타입만 사용 가능
		
		// 6.
		Optional op6 = new Optional();
			// "?" 없이 지네릭 아예 안 쓰면? --> 지네릭스의 장점을 포기하는 것 --> 원치않는 다른 타입이 입력되는 것을 방지 & 매번 타입체크와 형변환을 해야 한다.
	}
}
