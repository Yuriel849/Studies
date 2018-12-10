package generics;

import java.util.ArrayList;

class Ex04_GenericsTest {
	public static void main(String[] args) {
		FruitBox.<Apple>makeJuice(new FruitBox<Apple>()); // 객체 생성 없이 지네릭 메서드 makeJuice 호출
			// 일반적으로 리턴타입 앞에 위치한 <T>는 매개변수의 <T>와 같기 때문에 생략할 수 있다.
		FruitBox.makeJuice(new FruitBox<Apple>());
		FruitBox.makeJuice(new FruitBox<Toy>()); // 와일드카드 사용으로 Fruit의 child 타입만 입력될 수 있다 --> Toy 사용 불가
	}

}

class Fruit { }
class Apple extends Fruit { }
class Grape extends Fruit { }
class Juice { }
class Toy { }

class FruitBox1<T> { // 클래스의 <T>는 객체 생성 시점에 타입이 결정된다
	// 지네릭 메서드 --> <T>는 메서드 내에서만 사용할 목적으로 지네릭 사용
	static <T extends Fruit> Juice makeJuice(FruitBox<? extends Fruit> box) { // Toy클래스 같은 원치 않는 타입의 객체가 입력되는 것을 막기 위해 와일드카드 사용
		// 리턴타입 Juice 앞에 위치한 <T>는 클래스 선언부의 <T>와 관련없다! --> 해당 메서드의 호출 시점에 <T>의 타입이 결정된다
		return null;
	}
	
	// 와일드 카드가 사용된 메서드 --> 여러 타입의 지네릭을 입력할 목적으로 지네릭 사용
	static Juice makeJuiceW(FruitBox<Fruit> box) {
		return null;
	}
	
	ArrayList<T> list = new ArrayList<T>();
	
	void add(T item) {
		list.add(item);
	}
	
	T get(int i) {
		return list.get(i);
	}
} // FruitBox<T> 클래스 끝.