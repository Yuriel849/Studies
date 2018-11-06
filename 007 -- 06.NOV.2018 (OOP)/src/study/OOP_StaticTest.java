package study;

class StaticBlockTest {
	// 길이가 10인 int 배열
	// 이 배열에 임의의 정수값를 채우고 싶다
	static int[] arr = new int[10]; // static 멤버의 간단한 초기화
	
	static { // static initialization block --> static 멤버의 복잡한 초기화에 사용
				// --> 인스턴스는 생성자로 초기화하지만 static 멤버는 생성자를 사용하지 않기에 복잡한 초기화가 불가능하다
		// 임의의 값으로 배열을 채우기 위해서는 for문이 필요하지만, 메서드 밖에 for문을 사용할 수 없다.
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 10);
		}
	}
}

public class OOP_StaticTest {
	public static void main(String[] args) {
	}

}
