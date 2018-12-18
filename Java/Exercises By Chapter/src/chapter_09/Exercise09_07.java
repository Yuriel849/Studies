package chapter_09;

// contains 메서드를 작성하라.

class Exercise09_07 {
	static boolean contains(String src, String target) {
		return src.contains(target);
	} // contains() 끝.
	
	public static void main(String[] args) {
		System.out.println(contains("12345", "23"));
		System.out.println(contains("12345", "67"));
	} // main() 끝.
} // 클래스 끝.