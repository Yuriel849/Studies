package study;

public class Ex03_Array03 {
	public static void main(String args[]) {
		// 배열 (레퍼런스) 변수 3개를 한 줄에 선언하기
		int[] num1, num2, num3;
		num1 = new int[3];
		num2 = new int[5];
		num3 = new int[3];
		
		int num4[], num5, num6;
		
		// int[] num; == int num[];
		num4 = new int[5];
		num5 = 50;
		num6 = 60;
		
		num4 = new int[]{10,20,30,40,50}; // 5칸짜리 1차원 배열을 새롭게 생성해서 num4로 참조한다.
										  // 기존에 num4가 참조하던 배열은 더이상 num4에게 참조되지 않는다.
		for(int num : num4) {
			System.out.println(num);
		}
		
		num4 = new int[]{10,20}; // 2칸짜리 1차원 배열을 새롭게 생성해서 num4로 참조한다.
		  						 // 기존에 num4가 참조하던 배열은 더이상 num4에게 참조되지 않는다.
		for(int num : num4) {
			System.out.println(num);
		}
	}
}