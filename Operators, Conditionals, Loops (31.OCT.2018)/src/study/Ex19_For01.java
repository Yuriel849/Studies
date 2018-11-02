package study;

public class Ex19_For01 {
	public static void main(String[] args) {
		// 메인의 메모리 영역에서 선언된 변수이기에 main이 끝나지 않는한 없어지지 않는다
		int number1 = 10;
		int i, sum;
		i = sum = 0;
		/* int i = sum = 0;
		 * 에러
		 * ...아마, 변수 선언과 동시에 초기화하니까 에러인듯
		 */
		
		for(; i<=10; i++) {
			// 초기식이 없어도 for문 내에서 사용하는 변수는 모두 for문 밖의 변수이고 초기화되었기에 초기식이 비어도 실행됨
			
			/* for(int sum; ...)
			 * 에러
			 * 여기서 int를 붙이면 새롭게 i & sum 선언하는 것
			 * for문 밖에 위치한 i & sum과 이름만 같은 다른 변수다
			 */
			System.out.println(i);
			sum += i;
			/* if (i==10) {
			 * 		System.out.println(i + "까지의 합 :" + sum);
			 * }
			 * 이렇게 해도 실행되고, for문 밖에서 i & sum에 접근하려는 문제도 해결 가능하다
			 * 다만 for문 반복할 때마다 매번 if문 조건식을 확인하기에 비효율적
			 */
		}
		System.out.println("\n" + (i-1) + "까지의 합 :" + sum);
		/* 에러
		 * i & sum은 for문의 메모리 영역에서 선언된 변수, for문이 끝나면서 함께 없어지는 변수
		 * 하지만 여기서는 i & sum을 for문 밖에서 접근하려하기에 에러
		 * i & sum을 for문 밖에서 선언함으로써 해결
		 */
	}

} // 닫히는 중괄호{}에 double-click하면 그 중괄호의 스코프를 확인할 수 있다
