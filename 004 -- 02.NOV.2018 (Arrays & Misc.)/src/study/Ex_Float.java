package study;

public class Ex_Float {
	public static void main(String[] args) {
		float f  = 9.12345678901234567890f;
		float f2 = 1.2345678901234567890f;
		double d = 9.12345678901234567890;
		
		System.out.printf("    123456789012345678901234%n");
		System.out.printf("f  :   %f%n", f); // 자동으로 소수점 이하 6자리까지 출력한다 --> 7자리에서 반올림해서 "9.123457"
		System.out.printf("f  : %24.20f%n", f);
		System.out.printf("f2 : %24.20f%n", f2);
		System.out.printf("d  : %24.20f%n", d);
	}

}
