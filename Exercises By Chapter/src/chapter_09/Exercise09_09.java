package chapter_09;

// delChar 메서드를 작성하라.

class Exercise09_09 {
	static String delChar(String src, String delCh) {
		// 주어진 문자열(src)에서 금지된 문자들(delCh)을 제거한 후 반환하라.
		String temp = "";
		for(int i = 0; i < src.length(); i++) {
			if(delCh.indexOf(src.charAt(i)) == -1) {
				temp += src.charAt(i);
			}
		}
		return temp;
	} // delChar() 끝.
	
	public static void main(String[] args) {
		System.out.println("(1!2@3^4~5)" + " -> " + delChar("(1!2@3^4~5)", "~!@#$%^&*()"));
		System.out.println("(1 2    3   4\t5)" + " -> " + delChar("(1 2    3   4\t5)", " \t"));
	} // main() 끝.
} // 클래스 끝.