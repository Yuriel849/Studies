package study;

public class Ex26_For06 {
	public static void main(String[] args) {
		/* 단의 수가 홀수면 곱해지는 수도 홀수가,
		 * 		단의 수가 짝수면 곱해지는 수도 짝수가 곱해지도록 하세요
		 */
		for(int i=2; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				if(i % 2 == j % 2) {
					System.out.printf("%d X %d = %d \n",  i, j, (i*j));
				}
			}
		System.out.println();
		}
	}
}
