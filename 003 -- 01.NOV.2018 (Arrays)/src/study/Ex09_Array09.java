package study;

public class Ex09_Array09 {
	public static void main(String[] args) {
		// 45개의 정수값을 저장하기 우한 배열 생성.
		int[] ball = new int[45];
		
		// 배열의 각 요소에 1 ~ 45의 값을 저장한다.
		for(int i = 0; i< ball.length; i++) {
			ball[i] = i + 1;
		}
		
		int temp = 0; // 두 값을 바꾸는데 사용할 임시변수
		int j = 0; // 임의의 값을 얻어서 저장할 변수
		
		for(int i = 0; i < 100; i++) {
			j = (int) (Math.random() * 45); // 배열의 범위(0~44)에서 임의의 값을 얻는다.
			temp = ball[0];
			ball[0] = ball[j];
			ball[j] = temp;
		}
		
		// 배열 ball의 앞에서부터 6개의 요소를 출력한다.
		for(int i = 1; i < 46; i++) {
			System.out.printf("%3d ", ball[i-1]);
			if(i % 5 == 0) {
				System.out.println();
			}
		}
	}

}
