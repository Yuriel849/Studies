package study;

public class Ex29_While01 {
	public static void main(String[] args) {
		for(int i=1; i<=3; i++) {
			System.out.println(i);
		}
		// 위 for문을 while문으로 바꾸기
		int i = 1;
		while(i<=3) {
			System.out.println(i++);
			
			/* System.out.println(i++);
			 * 
			 * IS THE SAME AS
			 * 
			 * System.out.println(i);
			 * i++;
			 */
		}
	}

}
