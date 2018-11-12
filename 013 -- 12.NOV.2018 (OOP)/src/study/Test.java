package study;

class Test {
	public static void main(String[] args) {
		Child c = new Child();
			/* 생성자 호출 순서
			 * 	>> Child() --> Child(int x) --> Parent() --> Parent(int x) --> Object()
			 */
		System.out.println("x="+c.getX(5));
			/* 출력결과는 "x=200"
			 * 	>> getX 메서드는 x를 반환할 뿐, x가 무엇인지 명시하지 않았다. 그래서 소속 클래스의 인스턴스 변수 x를 반환한다.
			 * 	>> 만약 Child 클래스에서 오버라이딩했으면 결과는 달라졌을 것.
			 */
	}
}

class Parent {
	int x=100;
	Parent() {
		this(200); // Parent(int x)를 호출
		}
	Parent(int x) {
		this.x = x;
		}
	int getX(int a) {
		return x;
		}
	}

class Child extends Parent {
	int x = 3000;
	Child() {
		this(1000); // Child(int x)를 호출
		}
	Child(int x) {
		this.x = x;
		}
	int getX(int a) {
		return x;
	}
}