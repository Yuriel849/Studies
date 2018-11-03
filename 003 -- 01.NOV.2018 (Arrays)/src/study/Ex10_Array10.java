package study;

public class Ex10_Array10 {
	public static void main(String[] args) {
		checkArray();
		checkArray02();
	}
	
	private static void checkArray() {
		// 3칸짜리 배열 2개가 있다. 두 배열을 서로 비교하여, 같으면 "같습니다" 같지 않으면 "다릅니다" 출력하기
		int[] arr1 = {1,2,3};
		int[] arr2 = {1,4,3};
		int flag = 0; // 같은 값이 몇 개인지 세는데 사용할 변수
		
		if(arr1.length != arr2.length) {
			System.out.println("두 배열이 다릅니다.");
		}
		
		// 두 배열이 같은지 확인한다. 같은 위치의 값이 모두 같아야 두 배열이 같은 것이다
		// 3번 같아야 한다 (arr1.length == 3)
		for(int i = 0; i < arr1.length; i++) {
			if (arr1[i] == arr2[i]) {
				flag++;
			}
		}
		if(flag == arr1.length) {
			System.out.println("같습니다.");
		} else {
			System.out.println("다릅니다.");
		}
	}
	
	private static void checkArray02() {
		/* 길이 불명의 첫번째 배열 속에 두번째 배열이 있는지 알고싶다. 두번째 배열이 있는지, 몇 개 있는지, 그리고 그 위치를 출력하라.
		 * arr1 = {1,2,3,4,5,6,7,8,9,10}
		 * arr2 = {5,6,7}
		 */
		int[] arr3 = {10,21,32,43,54,65,76,87,98,19,40};
		int[] arr4 = {54,62,71};
		int flag = 0;
		int loc = 0;
		
		for(int i = 0; i < arr3.length; i++) {
			for(int j = 0; j < arr4.length; j++) {
				if (arr3[i+j] != arr4[j]) {
					break;
				} else {
					flag++;
				}
				if(flag == arr4.length) {
					loc = i;
					break;
				}
			}
		}
		if(flag == arr4.length) {
			System.out.print("배열 arr4 (");
			for(int a = 0; a < arr4.length; a++) {
				System.out.print(arr4[a]);
				if(a+1 != arr4.length) {
					System.out.print(", ");
				}
			}
			System.out.printf(")은 arr3[%d]에 있습니다.", loc);
		} else {
			System.out.println("찾는 배열이 arr3에 없습니다.");
		}
	}
}




