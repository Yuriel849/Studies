package study;

// 정렬하기 (Bubble Sort) --> 오름차순 / 내림차순으로 배열을 정렬
public class Ex_Array06 {
	public static void main(String[] args) {
		int[] numArr = new int[10];
		
		for(int i = 0; i < numArr.length; i++) {
			System.out.print(numArr[i] = (int)(Math.random() * 10));
		}
		System.out.println();
		
		for(int i = 0; i < numArr.length - 1; i++) {
			boolean changed = false;
			
			for(int j = 0; j < numArr.length - 1 - i; j++) {
				/* 반복횟수 감소 (numArr.length - 1 - i)
				 * 	>> 반복할 때마다 한 값씩 정렬을 완료한다
				 * 	>> 반복할 때마다 한 값씩 덜 비교해도 된다
				 * 		(>> 비교해도 어차피 정렬되었기에 교환이 일어나지 않는다)
				 *  	(>> 비교할 필요 없는 값들은 비교하지 않는 것이 효율적이다)
				 */
				if(numArr[j] > numArr[j+1]) { // 오름차순으로 정렬한다
						/* 내림차순으로 정렬하려면 if(numArr[j] < numArr[j+1])으로 비교연산자의 방향만 수정
						 * 		>> 현재 위치의 값과 다음 위치의 값을 비교하여, 더 큰 것이 왼쪽으로 가게 교환
						 */
					int temp = numArr[j];
					numArr[j] = numArr[j+1];
					numArr[j+1] = temp;
					changed = true;
				}
			}
			
			if(!changed) { // 자리바꿈이 일어나지 않았으면 반복문을 벗어난다 --> 자리바꿈이 일어나지 않으면 정렬이 완료되었다는 의미다
				break;
			}
			/* 실행 예시)
			 * 	>> 8226422989
			 * 	>> 2264228899
			 * 	>> 2242268899
			 * 	>> 2222468899
			 * 
			 * 바깥 for문이 3회 반복만에 정렬 완료 --> changed == false --> break
			 * 	--> changed가 바뀌지 않았다는 것은 값의 교환이 일어나지 않았다는 의미
			 * 	--> 이미 정렬 완료되어서 교환이 일어나지 않는 것
			 * 	--> break로 반복을 종료 
			 */
			
			
			for(int k = 0; k < numArr.length; k++) {
				System.out.print(numArr[k]);
			}
			System.out.println();
		}
	}

}