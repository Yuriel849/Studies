package study;

// 코드 한 줄 이상을 하이라이트하고 alt + shift + z하면 try-catch, if, for, while 블럭 등을 적용할 수 있다
// source 탭에 toString, getter & setter 생성할 수 있다

//public class Ex01_ExceptionHandling {
//	public static void main(String[] args) {
//		System.out.println(1);
//		System.out.println(2);
//		
//		try {
//			System.out.println(3);
//			System.out.println(4);
//		} catch (Exception e) {
//			System.out.println(5);
//		} // try-catch의 끝.
//		System.out.println(6);
//	} //main()의 끝.
//} // 클래스의 끝.

class Ex01_ExceptionHandling {
	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		
		try {
			System.out.println(3);
			System.out.println(0/0); // 출력결과는 1 2 5 6
			System.out.println(4);   // 	>> 윗줄에서 예외처리 들어가니까 아래 코드는 실행되지 않는다
									 // 	>> 예외처리 들어가면 catch의 예외를 하나씩 확인하여 일치하는 에러를 찾음
									 // 	>> 찾으면 그 하위 코드블럭을 수행하고 try-catch 부문을 종료
		} catch (ArithmeticException ae) {
			System.out.println(5);
		} // try-catch의 끝.
		System.out.println(6);
	} //main()의 끝.
} // 클래스의 끝.