package study;

import java.util.Scanner;

public class Ex23_For05 {
	public static void main(String[] args) {
		// 정수 3개를 입력 받아서 합계, 가장 큰 수, 가장 작은 수를 구하세요
		Scanner scan = new Scanner(System.in);
		
		// 합계, 가장 큰 수, 가장 작은 수를 저장할 변수
		int sum, max, min;
		sum = max = min = 0;
				
		for(int i=1, input; i<=3; i++) {
			System.out.printf("%d 번째 정수를 입력하세요 : \n", i);
			// 입력받은 정수를 input에 할당하고 변수 sum에 누적시킨다
			sum += input = scan.nextInt();
			/* input은 scan.nextInt()로 기존값을 덮어쓰기 때문에 초기화 필요없다
			 * max & min은 비교연산을 하는데, 비교연산이 if-else 때문에 항상 실행하는 것도 아니기에 초기화가 필요
			 * 		>> if를 실행 안한다면 max & min은 input이 대입되지 않는다
			 * 		>> else에서 초기화되지 않은 상태로 비교연산을 시도하게 된다... 
			 */
			
			// 최대값 & 최소값 구하기
			// i가 1일 때 == 첫번째 반복 시
			if(i == 1) {
				// max & min을 input으로 초기화
				max = min = input;
			}else {
				// input값이 max값보다 크면 새로운 max 값이 됨
				if(input > max) {
					max = input;
				}
				// input값이 min값보다 작으면 새로운 min 값이 됨
				if(input < min) {
					min = input;
				}
			}
		}
		System.out.printf("합계 : %d 최대값 : %d 최소값 : %d\n", sum, max, min);	
	}

}
