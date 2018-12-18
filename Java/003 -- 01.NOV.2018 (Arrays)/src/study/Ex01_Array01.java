package study;

public class Ex01_Array01 {
	public static void main(String[] args) {
		// 배열 (변수) 선언
		int number; // data 저장공간 확보 --> 변수 선언
				// --> 변수명 앞의 int는 int 자료형 데이터 1개만 들어갈 수있다는 명령
		int[] array; // data의 주소 저장공간 확보, 아직 배열 생성 X --> 배열 (레퍼런스) 변수 선언
				// --> 변수명 앞의 int[]는 int형 데이터만 저장할 수 있는 1차원 배열이라는 명령
		int[][] array2; // data의 주소 저장공간 확보, 아직 배열 생성 X --> 배열 (레퍼런스) 변수 선언
				// --> 변수명 앞의 int[][]는 int형 데이터만 저장할 수 있는 2차원 배열이라는 명령
		
		/* int type 배열 생성
		 * 		>> 배열 선언은 배열명만 메모리에 저장하는 것
		 * 		>> 배열 생성은 메모리에 배열의 저장공간을 확보하고
		 * 			(동시에 초기화할 수도 있고) 그 주소값을 배열명에 저장하는 것
		 * 
		 * int[3]
		 * 		>> int data 3개를 담는 공간 확보
		 * 		>> int 배열 공간 3개가 각각 기본값인 0으로 초기화됨
		 */
		array = new int[3];
		
		array[0] = 10;
		array[1] = 20;
		array[2] = 30;
		
		// array; --> 배열 전체의 주소
		// array[0]; --> 배열 요소 하나의 주소
		
		
		System.out.printf("array[%d] = %d%n",  0, array[0]);
		System.out.printf("array[%d] = %d%n",  1, array[1]);
		System.out.printf("array[%d] = %d%n",  2, array[2]);
		
		System.out.println();
		for(int i = 0; i < 3; i++) {
			System.out.printf("array[%d] = %d%n", i, array[i]);
		}
		
		System.out.println();
		for(int i = 0; i < 3; i++) {
			array[i] = 10;
			System.out.printf("array[%d] = %d%n", i, array[i]);
		}
		
		int value = 10;
		System.out.println();
		for(int i = 0; i < 3; i++) {
			array[i] = (i+1) * value;
			System.out.printf("array[%d] = %d%n", i, array[i]);
		}
	}

}
