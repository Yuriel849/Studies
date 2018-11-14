package collectionsFramework;

import java.util.Vector;

class MyVectorTest {
	public static void main(String[] args) {
		MyVector v = new MyVector(5);
		// 잘 안된다면 Vector 객체를 선언/생성하여 실행, 비교해보자
		Vector v4 = new Vector();
		System.out.println(v.isEmpty());
//		v4.add("3");
//		v4.setSize(4);
//		v4.add("4");
//		System.out.println(v4.size());
//		System.out.println(v4);
//		System.out.println(v4.indexOf("4"));
		for(int i = 0; i < 10; i++) {
			v.add(new Integer(i*10));
		}

//		v.add("5");
//		v.add(null);
//		v.add(null);
//		v.add(null);
//		System.out.println(v.capacity());
//		v.add("4");
//		v.add("3");
//		v.add("2");
//		v.add("1");
		System.out.println("size = " + v.size());
		System.out.println("toString = " + v.toString());
		System.out.println("get(5) = " + v.get(5));
		System.out.println(v.indexOf(40));
		System.out.println(v.remove(20));
		System.out.println(v.capacity());
		System.out.println(v.toString());
	}
}
