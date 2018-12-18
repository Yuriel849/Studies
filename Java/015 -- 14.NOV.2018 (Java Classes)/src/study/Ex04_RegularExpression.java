package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Ex04_RegularExpression {
	public static void main(String[] args) {
		String[] data = {"bat", "baby", "bonus", "cA", "ca", "co", "c.",
							"c0", "car", "combat", "count", "data", "disc"};
		
		Pattern p = Pattern.compile("c[a-z]*"); // c로 시작하는 소문자 영단어 모두

		for(int i = 0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches()) { System.out.print(data[i] + ","); }
		}
	} // main() 끝.
} // 클래스 끝.