package study;

public class Ex15_Array15 {
	public static void main(String[] args) {
		noCheckRepetition();
		checkRepetition();
		baseballGame();
	}
	
	private static void noCheckRepetition() {
		// 두 배열에 같은 숫자가 몇게 있는지 세어서 출력하라.
		int[] arr1 = {1,2,3};
		int[] arr2 = {1,1,3,1,1,};
		int cnt = 0;
		
		for(int i = 0; i < arr1.length; i++) {
			for(int j = 0; j < arr2.length; j++) {
				if (arr1[i] == arr2[j]) {
					cnt++;
				}
			}
		}
		System.out.println("같은 숫자의 개수 = " + cnt);
	}
	
	// INCOMPLETE!!! --> rethink the logic...
	private static void checkRepetition() {
		// 두 배열에 같은 숫자가 몇게 있는지 세고, 다만 중복되는 값은 중복하여 세지 않는다.
		int[] arr1 = {1,2,3};
		int[] arr2 = {1,1,3,1,1,};
		int array;
		if (arr1.length >= arr2.length) {
			array = arr1.length;
		} else {
			array = arr2.length;
		}
		int[] cnt = new int[array];
		int a = 0;
		
		for(int i = 0; i < arr1.length; i++) {
			for(int j = 0; j < arr2.length; j++) {
				if (arr1[i] == arr2[j]) {
					for(int k = 0; k < cnt.length; k++) {
						if(cnt[k] == arr1[i]) {
							break;
						} else {
							a++;	
						}
					}
				}
			}
		}
		System.out.println("같은 숫자의 개수 = " + a);
	}
	
	private static void baseballGame() {
		// 두 배열에 같은 숫자가 몇게 있는지 세어서 출력하라.
		int[] arr1 = {1,2,3};
		int[] arr2 = {2,1,3};

		// ball 같은 숫자가 있는데, 위치가 다를 때
		int b = 0;
		// strike 같은 숫자가 있는데, 위치가 같을 때
		int s = 0;
		
		for(int i = 0; i < arr1.length; i++) {
			for(int j = 0; j < arr2.length; j++) {
				if (arr1[i] == arr2[j]) { // 두 값이 같을 때, ball or strike
					if (i != j) { // 값은 같은데 위치가 다를 때
						b++;
					} else { // 값은 같은데 위치가 같을 때
						s++;
					}
				}
			}
		}
		System.out.printf("%dS%dB\n", s, b);
	}
}

