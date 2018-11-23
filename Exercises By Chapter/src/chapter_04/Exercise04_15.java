package chapter_4;

class Exercise4_15 {
	public static void main(String[] args) {
		int number = 12321;
		int tmp = number;
		
		int result = 0; // 변수 number를 거꾸로 변환해서 담을 변수
		String str = "";

		while(tmp != 0) {
			str += tmp % 10;
			// alternative
			// result = result*10 + tmp%10; // 기존 결과에 10을 곱해서 더한다.
			tmp /= 10;
		}
		result = Integer.parseInt(str);
		
		if(number == result) {
			System.out.println(number + "는 회문수입니다.");
		} else {
			System.out.println(number + "는 회문수가 아닙니다.");
		}
	} // main() 끝.
} // 클래스 끝.