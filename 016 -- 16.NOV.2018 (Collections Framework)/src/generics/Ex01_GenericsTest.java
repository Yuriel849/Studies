package generics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

class Ex01_GenericsTest {
	public static void main(String[] args) {
		/* ArrayList는 내부에서 Object 배열을 사용하기 모든 타입의 객체를 대입할 수 있다.
		 * 하지만 일반적으로 같은 타입의 객체들만 사용한다. Generics는 아예 지정된 타입의 객체들만 넣을 수 있게 제한한다.
		 * 
		 * Generics의 장점 - 01 -->> 지정 타입 이외의 타입이 들어가는 것을 막아준다.
		 */
		ArrayList<String> list = new ArrayList<String>(); //--> i.e. list에 String타입 객체만 넣을 거야!
		list.add("String");
		
		/* Generics의 장점 - 02 -->> 불필요한 타입체크(instanceof) & 형변환을 제거한다.
		 */
		HashSet<String> set = new HashSet<String>();
		set.add("abc"); // boolean add(Object o) --> 무엇을 인수로 전달하던 받을 수 있어야 한다. --> 무엇을 인수로 전달하던 Object타입으로 받는다.
		set.add("ABC");
		
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
//			String str = (String)it.next(); // next() 리턴타입은 Object --> 형변환 필요 --> Generics 안 썼을 때 
			String str = it.next();
		}
	} // main() 끝.
} // 클래스 끝.