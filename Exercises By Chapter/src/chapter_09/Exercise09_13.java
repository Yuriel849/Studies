package chapter_09;

// 하나의 긴 문자열(source) 중에서 특정 문자열과 일치하는 문자열의 개수를 구하라.

class Exercise09_13 {
	public static void main(String[] args) {
		String src = "aabbccAABBCCaa";
		System.out.println(src);
		System.out.println("aa를 " + stringCount(src, "aa") + "개 찾았습니다.");
	} // main() 끝.
	
	static int stringCount(String src, String key) {
		return stringCount(src,key,0);
	} // stringCount(String, String) 끝.
	
	static int stringCount(String src, String key, int pos) {
		int count = 0;
		int index = 0;
		
		if(key == null || key.length() == 0) {
			return 0;
		}
		
		while((index = src.indexOf(key, pos)) != -1) {
			count++;
			pos = index + key.length();
		}
		
		return count;
	} // stringCount(String, String, int) 끝.
} // 클래스 끝.