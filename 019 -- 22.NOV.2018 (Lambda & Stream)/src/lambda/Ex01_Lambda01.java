package lambda;

// 기본적인 람다식 사용 예제 

class MyClass {
	// 원래 메서드는 무조건 어딘가의 클래스 속에 위치해야 한다
	int max(int a, int b) {
		return a > b ? a : b;
	}
	
}

class Ex01_Lambda01 {
	public static void main(String[] args) throws Exception {
		MyClass m = new MyClass();
		int result = m.max(3, 5);
		System.out.println(result);
			// 별것 아닌 계산을 하는데 (1) 새 클래스 만들고, (2) 새 메서드 만들고, (3) 새 객체 선언과 생성해서 (4) 연산해야 한다!! --> 너무 번거롭고 귀찮다!! --> 람다식 사용
		
		// 람다식의 실체는 익명 객체 --> 클래스의 선언과 객체 생성을 동시에 실행 --> 익명 객체를 만들었다!
		// obj는 max를 클래스의 메서드 대신 익명 객체로 표현
		Object obj = new Object() {
			int max(int a, int b) {
				return a > b ? a : b;
			}
		};
		
		// obj보다 더욱 람다식에 가까운 표현 방법 --> 여전히 문제가 있다
//		Object obj2 = (a,b) -> a > b ? a : b;
		
		// 람다식
		// 메서드를 식으로 간단히 표현하기 위한 것 --> (목적) 간단히 표현한 후 메서드처럼 사용할 수 있어야 한다.
		// 람다식은 이름이 없다 --> 부를 이름이 없으니 호출하기 어렵다 --> 메서드를 호출할 때는 이름이 필요하다 --> 그럼 람다식도 사용하려면 이름이 필요하다
		// 람다식(익명객체)을 다룰려면? 참조변수가 필요. --> 람다식을 호출할 수 있는 이름(메서드명)이 필요 --> 함수형 인터페이스 사용 --> 하나의 추상 메서드만을 가지는 데 이 하나의 추상메서드에 람다식을 연결(람다식에 이름을 붙여준다)한다.
		// 함수형 인터페이스가 단 하나의 추상메서드만 가질 수 있는 이유는, 추상메서드가 2개 이상이면 어느 것과 람다식을 연결해줘야할지 알 수 없기 때문이다
		// "@FunctionalInterface"에 의해 추상메서드가 한 개인지 2개 이상인지 확인된다 --> 한 개만 있는게 아니면 에러 난다.

		MyFunction f = (a,b) -> a > b ? a : b;
		
		result = f.max(3, 5); // 람다식 호출
		System.out.println(result);
	}
}

// 함수형 인터페이스 --> 단 하나의 추상 메서드만 가진 인터페이스!
@FunctionalInterface
interface MyFunction {
	int max(int a, int b);
}