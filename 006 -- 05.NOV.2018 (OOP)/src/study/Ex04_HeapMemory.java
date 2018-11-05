package study;

/* HEAP Memory
 * 	>> 프로그램 실행 중 생성되는 메모리 공간을 관리하는 영역
 * 	>> new 연산자에 의해서 생성된다
 * 	1. 동적 데이터를 저장하는 메모리 공간
 * 	2. 자동초기화가 지원된다
 * 	3. 자동해제도 지원된다 (via "garbage collector")
 */

/* 소스코드를 컴파일하면 클래스파일이 된다
 * 	>> 컴파일하면서 main 메소드와 main에서 사용하는 다른 클래스를 파악한다
 * 	>> 클래스파일을 JVM에서 실행하면 main & main이 쓰는 클래스가 함께 Method area 영역으로 로딩된다
 * 	>> main을 실행하다가 new가 나오면 해당 class를 활성화시키고 class의 멤버변수를 Heap 영역으로 로딩한다
 * 	>> (클래스를 활성화시키기 전에도 클래스는 로딩된 상태, 다만 못 쓴다)
 * 
 * Instance VS Object
 * 	>> new를 이용하여 특정 클래스를 한 번 활성화시키고 heap으로 로딩하면 그것이 instance
 * 	>> new를 이용하여 클래스를 활성화시켜 Heap으로 로딩하면 그것이 object (instance보다 포괄적)
 * 		>> new를 이용하여 똑같은 클래스를 다시 활성화시키면 다른 instance가 생겨나는 것
 * 		>> 같은 이름의 멤버변수 & 멤버메소드를 가진다
 * 		>> 멤버변수는 Heap 영역에 자신만의 고유 메모리 공간을 가지고 속성은 같아도 내용물이 다르다
 * 		>> 멤버메소드는 instance 간 공유하며 똑같은 데이터를 호출하여 똑같이 실행한다
 * 	ex)
 * 		Car c = new Car();
 * 		Car c2 = new Car();
 * 		c.start() == c2.start() --> 똑같은 메소드다
 * 		c.door != c2.door 		--> 이름만 같을뿐, 내용도 다르고 메모리 공간과 주소값도 다르다 
 */

// main이 담긴 클래스만 앞에 public이 필요하다
public class Ex04_HeapMemory {
	public static void main(String[] args) {
		String str = new String("abc");
		
		/* 클래스를 사용가능한 상태로 활성화시킨 것이 바로 객체
		 * 	>> 활성화시킬 때 멤버변수만 Heap에 로딩하고 멤버메소드는 Method 영역에 남아있는다
		 * 		>> 멤버변수는 각 객체마다 값이 달라질 수 있기 때문에 고유 메모리 공간 확보
		 * 		>> 멤버메소드는 각 객체마다 달라지지 않고 똑같기 때문에 공용 메모리 공간에 남겨진다 (Method 영역)
		 * 			>> 멤버메소드는 Heap에 없지만, 같은 클래스 소속이기에 멤버메소드를 쓸 수 있게 참조하고 있다
		 */
		
		// 클래스를 Heap에 로딩하여 활성화시키기 --> 이제 Car 클래스의 모든 변수, 메소드에 접근할 수 있다
		Car c = new Car();
		/* 클래스 활성화 시, 주소값을 받는 참조형 변수의 자료형과 new 연산자에 적은 자료형하고 일치해야한다!!!
		 * Bus car = new Car(); --> 에러!!!
		 */
		
		c.start(); // Car 클래스의 start 메소드 실행
		c.start("서울"); // start 메소드 중 String 매개변수가 있는 것을 실행
		System.out.println(c.color); // 만약 클래스 내에서 값을 설정하지 않았다면 여기서는 초기값이 나온다
		System.out.println(c.handle);
		System.out.println(c.door);
		c.color = "black";
		System.out.println(c.color);
		c.handle = 1;
		System.out.println(c.handle);

		c = null;
			/* c가 참조하고 있는 클래스 Car의 객체를 덮어쓴다
			 * 클래스 Car의 객체는 garbage collector SW에 의해 삭제된다
			 */
	}

}

// 간단한 클래스 만들기
class Car {
	String color; // 값을 설정하지 않았다 --> String의 초기값은 null
	int handle; // 값을 설정하지 않았다 --> int의 초기값은 0
	int door = 4;
	
	public void start() {
		System.out.println("출발합니다");
	}
	public void start(String str) {
		System.out.println(str + "로 출발합니다");
	}
	public void stop() {
		System.out.println("정지합니다");
	}
}
