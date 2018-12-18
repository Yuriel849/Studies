package chapter_09;

// 커맨드라인으로부터 2~9사이의 두 개 숫자를 받아서 두 숫자 사이의 구구단을 출력하라.

class Exercise09_11 {
	public static void main(String[] args) {
		int start = 0, end = 0;
		
		try {		
			if(args.length < 2) {
				throw new Exception("시작 단과 끝 단, 두 개의 정수를 입력하세요.");
			}

			start = Integer.parseInt(args[0]);
			end = Integer.parseInt(args[1]);
			
			if((start < 2 || 9 < start) || (end < 2 || 9 < end)) {
				throw new Exception("단의 범위는 2와 9사이의 값이어야 합니다.\nUSAGE : GugudanTest 3 5");
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("USAGE : GugudanTest 3 5");
			System.exit(0);
		} // try-catch문 끝.
		
		if(start > end) {
			int temp;
			temp = start;
			start = end;
			end = temp;
		} else if(start < end) {
			for(; start <= end; start++) {
				for(int i = 1; i <= 9; i++) {
					System.out.println(start + "*" + i + "=" + (start*i));
				}
				System.out.println();
			}
		} // if-else문 끝.
	} // main() 끝.
} // 클래스 끝.