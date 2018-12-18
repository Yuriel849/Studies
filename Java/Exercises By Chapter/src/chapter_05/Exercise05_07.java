package chapter_05;

// 커맨드라인으로부터 거슬러 줄 금액을 입력 받아 계산한다.
// 보유한 동전의 개수로 거스름돈을 지불할 수 없으면, "거스름돈이 부족합니다."라고 출력하고 종료한다.
// 지불할 돈이 충분하다면, 거스름돈을 지불한 만큼 가진 돈에서 뺴고 남은 동전의 개수를 화면에 출력한다.

class Exercise05_07 {
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("USAGE : java Exercise5_7 3120");
			System.exit(0);
		}
		
		// 문자열을 숫자로 변환한다. (입력한 값이 숫자가 아닐 경우 예외 발생)
		int money = Integer.parseInt(args[0]);
		
		System.out.println("money = " + money);
		
		int[] coinUnit = { 500, 100, 50, 10 }; // 동전의 단위
		int[] coin 	   = {   5,   5,  5,  5 }; // 단위별 동전의 개수
		
		for(int i = 0; i < coinUnit.length; i++) {
			int coinNum = 0;
				// 1. 금액(money)을 동전 단위로 나눠서 필요한 동전의 개수(coinNum)를 구한다.
			coinNum = money / coinUnit[i];
				// 2. coin에서 coinNum 만큼의 동전을 뺀다 (만일 동전이 충분하지 않다면 coin에 있는 만큼만 뺀다.)
			if(coinNum > coin[i]) {
				coinNum = coin[i];
				coin[i] = 0;
			} else {
				coin[i] -= coinNum;
			}
				// 3. 금액에서 동전의 개수(coinNum)와 동전 단위를 곱한 값을 뺀다.
				money -= coinNum * coinUnit[i];
				System.out.println(coinUnit[i] + "원 : " + coinNum);
		}
		
		if(money > 0) {
			System.out.println("거스름돈이 부족합니다.");
			System.exit(0); // 프로그램을 종료한다.
		}
		
		System.out.println(" = 남은 동전의 개수 = ");
		
		for(int i = 0; i < coinUnit.length; i++) {
			System.out.println(coinUnit[i] + "원 : " + coin[i]);
		}
	}
}