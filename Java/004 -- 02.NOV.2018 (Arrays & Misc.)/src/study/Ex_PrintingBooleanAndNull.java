package study;

public class Ex_PrintingBooleanAndNull {

	public static void main(String[] args) {
		System.out.println("true" + null); // 문자열과의 덧셈연산의 결과는 문자열
		System.out.println(true); // boolean 값 혼자는 출력 가능
		// System.out.println(true + null); // boolean 값인 true, null 값은 덧셈연산이 불가능
		// System.out.println(null); // null 값 그 자체는 출력도 불가능

		System.out.println(3 << 96);
	}

}
