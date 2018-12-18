package chapter_09;

class Exercise09_03 {
	public static void main(String[] args) {
		String fullPath = "c:\\jdk1.8\\work\\PathSeparateTest.java"; // 이스케이프 문자 "\\"는 "\" 하나로 저장된다
		String path = "";
		String fileName = "";
		
		int pos = fullPath.lastIndexOf("\\");
		if(pos != -1) {
			path = fullPath.substring(0, pos);
			fileName = fullPath.substring(pos);
		}
		
		System.out.println("fullPath : " + fullPath);
		System.out.println("path : " + path);
		System.out.println("fileName : " + fileName);
	} // main() 끝.
} // 클래스 끝.