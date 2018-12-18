package study;

// 코드 올려주면 그것을 보고 완성하기
public class Ex01_Round_Rint {

	public static void main(String[] args) {
		double sum = 0;
		double sum1 = 0;
		double sum2 = 0;
		
		for(int i = 0; i < 10; i++) {
			double x = i + 0.5;
			sum += x;
			sum1 += Math.round(x);
			sum2 += Math.rint(x);
			System.out.printf("%3.1f\t %2d\t%3.1f %n", x, Math.round(x), Math.rint(x));
		}
		
		System.out.println("sum = " + sum);
		System.out.println("sum1 = " + sum1);
		System.out.println("sum2 = " + sum2);
	}
}
