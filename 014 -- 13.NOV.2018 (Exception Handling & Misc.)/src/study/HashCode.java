package study;

// Object 클래스의 equals() 메서드를 오버라이딩한다면 hashCode() 메서드도 오버라이딩해야 한다
public class HashCode {
	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new Object();
		Object obj3 = new Object();
		
		System.out.println("<일반 오브젝트>");
		System.out.println(obj1.hashCode()); // <객체명>.hashCode() --> 실제 메모리 주소값을 반환
		System.out.println(obj2.hashCode()); // 	--> 주소가 다르다는 것은 다른 객체라는 의미
		System.out.println(obj3.hashCode());
		
		// BUT
		System.out.println("\n<문자열>");
		
		String str1 = new String("abc");
		String str2 = new String("abc");
		
		System.out.println(str1.hashCode()); // String은 주소값이 같다 --> 같은 문자열 타입 객체이다
		System.out.println(str2.hashCode()); // 	--> why?? --> String 클래스에서 Object 클래스 hashCode()메서드를 오버라이딩 했다
	}
}
