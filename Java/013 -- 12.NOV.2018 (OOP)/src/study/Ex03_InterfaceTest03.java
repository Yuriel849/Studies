package study;

class Ex03_InterfaceTest03 {
	public static void main(String[] args) {
		A3 a = new A3();
		a.methodA(); // OR a.methodA(new B3());
	}
}

class A3 {
	void methodA() { // OR methodA(I3 i)
		I3 i = InstanceManager.getInstance(); // A 클래스에 매개변수를 표시하는 대신 제3의 클래스의 별도 메서드에게 일을 맡긴다.
		i.methodB();
		System.out.println(i.toString()); // i로 Object클래스의 메서드 호출 가능
	}
}

interface I3 {
	public static int add() { return 1 + 2; } // 인터페이스에 static 메서드를 넣어도 문제없다.
											  // 이미 구현된 것이기에 <인터페이스명>.<static메서드명>로 바로 사용할 수 있다.  
	public abstract void methodB();
}

class B3 implements I3 {
	public void methodB() { 
		System.out.println("methodB in B3 class");
		System.out.println(I3.add());
	}
	
	public String toString() { return "class B3"; }
}

class InstanceManager {
	public static I3 getInstance() {
		return new B3();
	}
}