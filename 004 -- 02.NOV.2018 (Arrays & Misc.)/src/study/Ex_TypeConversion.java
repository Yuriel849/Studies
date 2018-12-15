package study;

public class Ex_TypeConversion {
	public static void main(String[] args) {
		// f에 8자리 수를 입력 --> float의 정밀도는 7자리까지만 --> 8자리부터 숫자는 신뢰할 수 없는 숫자
		float f = 9.1234567f;
		// 이미 f에서 신뢰할 수 없는 값이 f에 담겼는데, 이것을 double로 형변환해도 값이 제대로 입력되지 않는다
		double d = (double) f;
		// d2에 8자리 수를 입력 --> double의 정밀도는 15자리까지 --> 제대로 입력됨
		double d2 = 9.1234567;
		// d를 float로 형변환하면 f에 실수를 대입할 때와 같이 오차가 발생하여 동일한 숫자가 대입된다
		float f2 = (float) d;
		
		System.out.printf("f  = %20.18f%n", f);
		System.out.printf("f2 = %20.18f%n", f2);
		System.out.printf("d  = %20.18f%n", d);
		System.out.printf("d2 = %20.18f%n", d2);
	
	}
}
