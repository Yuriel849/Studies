package study;

public class StringClass {
	String str = "abc"; // 기존에 만들어져 이미 존재하는 객체를 str가 참조하게 한다.
						// 여러 참조변수가 같은 문자열을 참조할 수 있다 (i.e. 여러 참조변수가 담고 있는 주소값이 같다)
	String str2 = new String("abc"); // 완전히 새로운 객체를 새롭게 생성하여 str2가 참조하게 한다 (여러번 실행할 때마다 각각 다른 주소값을 가진다)
	
	/* ==
	 * 비교대상인 두 참조변수의 주소값을 비교한다.
	 * 
	 * .equals()
	 * 비교대상인 두 참조변수가 실제로 참조하고 있는 문자열(i.e. 내용)을 비교한다.
	 */
	
	/* "" == 빈문자열 == 크기가 0인 char타입 배열 == 내용이 없는 배열
	 * 
	 * 문자열 초기화할 때 기본값 null이 아닌 "" (빈 문자열)로 초기화하자!
	 * 	>> 왜? null로 초기화하면 에러나기 쉽다 --> ex) 어떻게 초기화된지 모르고 length 사용하면 null이기에 에러난다
	 */
	
	// 배열의 최대 길이 --> 기본값으로 설정된 메모리 크기가 있다 (물론 재설정할 수 있다)
	public static void main(String[] args) {
		char[][][] cArr = new char[1000][1000][800]; // [1000][1000][1000]만 해도 에러난다 (1 trillion)
		System.out.println(cArr);
	}
	
}
