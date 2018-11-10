package study;

public class Ex04_Max {
	public static void main(String[] args) {
		int[] data = {3,2,9,4,7};
		System.out.println(java.util.Arrays.toString(data));
		System.out.println("최대값:" + max(data));
		System.out.println("최대값:" + max(null));
		System.out.println("최대값:" + max(new int[] {})); // 크기가 0인 배열
	}
	
	// 주어진 int형 배열의 값 중에서 제일 큰 값을 반환한다.
	// 만일 주어진 배열이 null이거나 크기가 0인 경우, -999999를 반환한다.
	static int max(int[] arr) {
		if(arr == null || arr.length == 0) { return -999999; }
		int max = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] > max) { max = arr[i]; }
		}
		return max;
	}
}
