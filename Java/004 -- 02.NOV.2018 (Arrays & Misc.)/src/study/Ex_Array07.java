package study;

/* 빈도수 구하기 (Counting)--> 배열에 어떤 값이 몇 개 저장되어 있는지 세어서 보여준다.
 * 
 * Counting 후 그 자료로 쉽게 할 수 있는 일
 * 	>> 정렬 --> 이것이 bucket sort
 * 	>> 중복제거
 * 		>> counting 후 bucket sort는 한 번만 counting하면 되기에 가볍고 효율적이다
 * 			<--> bubble sort는 매우 많이 반복하면서 정렬하기에 비효율적 (코드는 간단하지만...)
 */

public class Ex_Array07 {
	public static void main(String[] args) {
		int[] numArr = new int[10];
		int[] counter = new int[10];
		
		for(int i = 0; i < numArr.length; i++) {
			numArr[i] = (int)(Math.random() * 10);
			System.out.print(numArr[i]);
		}
		System.out.println();
		System.out.println();
		
		for(int i = 0; i < numArr.length; i++) {
			counter[numArr[i]]++;
		} 
		for(int i = 0; i < numArr.length; i++) {
			System.out.println(i + "의 개수 :" + counter[i]);
		}
		System.out.println();
		
		// 중복제거 --> if counter[i] not empty print i
		for(int i = 0; i < counter.length; i++) {
			if(counter[i] != 0) {
				System.out.print(i);
			}
		}
		System.out.println();
		System.out.println();
		
		// 정렬하기 --> if counter[i] not empty print i as many times as counter[i]
		for(int i = 0; i < counter.length; i++) {
			if(counter[i] != 0) {
				for(int j = 0; j < counter[i]; j++) {
					System.out.print(i);
				}
			}
		}
		System.out.println();
	}

}