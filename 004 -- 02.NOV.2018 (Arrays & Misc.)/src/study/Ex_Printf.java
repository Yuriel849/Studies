package study;

public class Ex_Printf {
	public static void main(String[] args) {
		byte b = 1;
		short s = 2;
		char c = 'A';
		
		int finger = 123456789;
		long big = 100_000_000_000L;
		long hex = 0xFFFF_FFFF_FFFF_FFFFL;
		
		int octNum = 010; // 8진수로 10, 10진수로는 8
		int hexNum = 0x10; // 16진수로 10, 10진수로는 16
		int binNum = 0b10; // 2진수로 10, 10진수로는 2
		
		System.out.printf("b=%d%n", b);
		System.out.printf("s=%d%n", s);
		System.out.printf("c=%c, %d%n", c, (int) c);
		System.out.printf("finger=[%5d]%n", finger); // %Ad에서 숫자가 A 이상 자리수라면 숫자가 모두 찍힌다 
		System.out.printf("finger=[%-5d]%n", finger);
		System.out.printf("finger=[%05d]%n", finger);
		System.out.printf("big=%d%n", big);
		System.out.printf("hex=%#x%n", hex);
		System.out.printf("octNum=%o, d%n", octNum, octNum);
		System.out.printf("hexNum=%x, d%n", hexNum, hexNum);
		System.out.printf("binNum=%s, d%n", Integer.toBinaryString(binNum), binNum);
	}

}
