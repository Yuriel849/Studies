package generics;

import java.util.ArrayList;
import java.util.List;

class Fruit {
	public String toString() {
		return "Fruit";
	}
} // Fruit 클래스 끝.

class Apple extends Fruit implements Eatable {
	public String toString() {
		return "Apple";
	}
} // Apple 클래스 끝.

class Grape extends Fruit {
	public String toString() {
		return "Grape";
	}
} // Grape 클래스 끝.

class Toy {
	public String toString() {
		return "Toy";
	}
} // Toy 클래스 끝.

class Ex02_GenericsTest {
	public static void main(String[] args) {
		// ArrayList<T> list = new ArrayList<T>(); --> 2개의 T에 같은 클래스명을 적어야 한다.
		// ArrayList<Fruit> list = new ArrayList<Apple>(); --> T에 들어가는 클래스명 간 parent-child 관계 불인정!
		List<Apple> list = new ArrayList<Apple>(); // --> 클래스 간 parent-child 관계는 문제 없다.
		
		FruitBox<Apple> appleBox = new FruitBox<Apple>(); // Fruit에서는 Eatable 인터페이스를 구현하지 않았지만, Apple에서 구현했음으로 사용 가능하다.
//		FruitBox<Fruit> fruitBox = new FruitBox<Fruit>(); // Fruit의 child클래스이지만 Eatable 인터페이스를 구현하지 않았다.
//		FruitBox<Toy> toyBox = new FruitBox<Toy>(); // <T> 위치에 들어갈 수 있는 클래스는 Fruit의 child클래스이고 Eatable 인터페이스를 구현한 클래스만 될 수 있다.
		
		fruitBox.add(new Fruit());
		fruitBox.add(new Apple()); // void add(Fruit item) --> Fruit 클래스의 child인 Apple 클래스 인스턴스를 넣을 수 있다.
		
		appleBox.add(new Apple());
		appleBox.add(new Apple());
//		appleBox.add(new Toy()); --> 에러 --> Box(Apple)에는 Apple을 담을 수 없다.
		
		toyBox.add(new Toy());
//		toyBox.add(new Apple()); --> 에러 --> Box(Toy)에는 Apple을 담을 수 없다.
		
		System.out.println(fruitBox);
		System.out.println(appleBox);
		System.out.println(toyBox);
	} // main() 끝.
} // 클래스 끝.

interface Eatable { } // 인터페이스도 똑같이 extends 사용
class FruitBox<T extends Fruit & Eatable> extends Box<T> { }

class Box<T> {
	ArrayList<T> list = new ArrayList<T>();
	void add(T item) { list.add(item); }
	T get(int i) { return list.get(i); }
	int size() { return list.size(); }
	public String toString() { return list.toString(); }
} // Box<T> 지네릭 클래스 끝.