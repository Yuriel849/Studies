package enumAndAnnotation;

import java.util.Date;

class Parent {
	void method01() {
		System.out.println("Parent method()");
	}
}

class Child extends Parent {
	@Override // "@Override"를 메서드 앞에 붙이면 컴파일러에서 오버라이딩을 제대로 했는지 안헀는지를 확인해준다.
	@Deprecated // 바로 아래 메서드(method01())가 deprecated라고 알리는 목적
	@SuppressWarnings("deprecation") // 경고 메세지 억지용, 괄호 속 문제에 대한 경고를 하면지 않는다
	void method01() {
		System.out.println("Child Method");
	}
}

class Ex02_Annotation {
	public static void main(String[] args) {
		Child c = new Child();
		c.method01(); // @SupressWarnings 없이 @Deprecated만 하면 여기서 경고가 뜬다
		Date d = new Date();
		d.getDate(); // Deprecated하다고 취소선 쳐지고 경고 생긴다. --> 실행은 가능하지만
	}
}
