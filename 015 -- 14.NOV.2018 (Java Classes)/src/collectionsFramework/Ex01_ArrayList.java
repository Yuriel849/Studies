package collectionsFramework;

import java.util.ArrayList;
import java.util.Collections;

class Ex01_ArrayList {
	public static void main(String[] args) {
		ArrayList list1 = new ArrayList(10);
		list1.add(new Integer(5));
		list1.add(new Integer(4));
		list1.add(new Integer(2));
		list1.add(new Integer(0));
		list1.add(new Integer(1));
		list1.add(3); // add(Object obj)이기에 int형인 숫자를 넣을 수 없다 --> autoboxing에 의해 자동으로 Integer 클래스의 객체 값 "3"이 된다
		
		ArrayList list2 = new ArrayList(list1.subList(1,4));
		print(list1, list2);
		
		Collections.sort(list1); // list1과 list2를 정렬한다.
		Collections.sort(list2);
		print(list1, list2);
		
		// list1.containsAll(list2) --> list1이 list2의 모든 요소를 포함하고 있을 때만 true
		System.out.println("list1.containsAll(list2) : " + list1.containsAll(list2));
		
		list2.add("B");
		list2.add("C");
		list2.add(3, "A");
		print(list1, list2);
		
		list2.set(3, "AA");
		print(list1, list2);
		
		// list1에서 list2와 겹치는 부분만 남기고 나머지는 삭제한다.
		System.out.println("list1.retainAll(list2) : " + list1.retainAll(list2));
		print(list1, list2);
		
		// list2에서 list1에 포함된 객체들을 삭제한다.
		for(int i = list2.size()-1; i >= 0; i--) { // list의 객체를 삭제할 때는 뒤에서 부터 삭제해야 한다 --> 앞에서 삭제하면 i가 증가하면서 삭제되지 않는다!!
			if(list1.contains(list2.get(i))) { list2.remove(i); }
		}
		print(list1, list2);
	} // main() 끝.
	
	static void print(ArrayList list1, ArrayList list2) {
		System.out.println("list1 : " + list1);
		System.out.println("list2 : " + list2);
		System.out.println();
	} // print() 끝.
} // 클래스 끝.
