package study;

class InterfaceTest {
	public static void main(String[] args) {
		A a = new A();
		a.methodA(new B()); /* A클래스의 객체 a의 methodA 메서드를 호출, 인자로는 B클래스의 객체를 새롭게 생성하여 전달
							 * methodA에서는 매개변수로 B클래스의 객체를 받아서 그 객체의 methodB 메서드 호출
							 * 	>> 메서드의 사용자인 A클래스 입장에서는 methodB의 구현부를 몰라도 호출해서 사용한다.
							 * 	>> 하지만 B클래스의 내용이 바뀌면 A클래스는 작동못하고, 그러면 A클래스를 사용하는 main()에서도 에러난다.
							 * 		>> 인터페이스를 적용하면 이런 문제를 해결할 수 있다.	
							 */
	}
}

class A {
	public void methodA(B b) {
		b.methodB();
	}
}

class B {
	public void methodB() {
		System.out.println("methodB()");
	}
}