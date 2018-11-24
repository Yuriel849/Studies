package chapter_09;

// count 메서드를 작성하라.

class Exercise09_05 {
	public static int count(String src, String target) {
		int count = 0; // 찾은 횟수
		int pos = 0;   // 찾기 시작할 위치
		
		while(true) {
			// 1. src에서 target을 pos의 위치부터 찾는다.
			pos = src.indexOf(target, pos);
			// 2. indexOf의 결과가 -1이면 반복문을 빠져나가서 count를 반환한다.
			if(pos == -1) {
				break;
			} else {
				// 3. 찾으면 count의 값을 1 증가시키고, pos의 값을 target.length만큼 증가시킨다.
				count++;
				pos += target.length();
			}
		} // while문 끝.
		return count;
	} // count() 끝.

	public static void main(String[] args) {
		System.out.println(count("12345AB12AB345AB", "AB"));
		System.out.println(count("12345", "AB"));
	} // main() 끝.
} // 클래스 끝.