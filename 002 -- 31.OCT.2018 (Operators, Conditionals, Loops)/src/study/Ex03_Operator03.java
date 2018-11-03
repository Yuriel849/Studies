package study;

public class Ex03_Operator03 {
	public static void main(String args[]) {
		
		/* 증가(감소) 연산자
		 * 특정 변수의 값을 1씩 증가(감소)시키는 연산자
		 * 대입연산자 없이 값을 변형시킴!!!
		 */
		int num = 10;
		System.out.println("1. num : " + num);
		System.out.println("2. num : " + num++);
		System.out.println("3. num : " + num);
		// num++는 println 실행 후 증감하기에 num의 값은 증가했으나 println 실행했을 때는 보이지 않는다
		System.out.println("4. num : " + ++num + "\n");
		// ++num는 println 실행 전 증감하기에 println 실행했을 때 보인다
		
		/*
		 * 전위/후위 증가(감소) 연산자의 차이
		 */
		int num1 = 10;
		int num2 = ++num1;
		System.out.printf("전위 증감연산자 : num1 = %d, num2 = %d\n", num1, num2);
		
		int num3 = 10;
		int num4 = num3++;
		System.out.printf("후위 증감연산자 : num3 = %d, num4 = %d\n\n", num3, num4);
		
		num = 10;
		System.out.printf("%d %d %d %d %d %d\n", num++, ++num, num--, ++num, num++, num);
	}

}

