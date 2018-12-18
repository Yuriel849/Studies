package study; // <-- 어느 package에 속한 것인지 표시

//<-- 한 줄 주석 (설명문)

/*
* <-- 여러 줄 주석
*/

//중괄호 {} 사이를 "스코프"라고 부른다

//public <-- 소스파일의 이름과 같은 클래스 앞에 붙임 
public class N01_Hello { // "{" <-- 코드블럭의 시작
	// "main()" 메소드 <-- 자바프로그램의 시작
	public static void main(String args[]){ // 메소드 설명문; main() 메소드의 시작
		System.out.println("Hello Java"); // 메소드 명령문(실행문) --> 실행시키고자 하는 문장 넣음
										  // ";" <-- 마침표
		// sysout 입력 후 ctrl + space --> System.out.println();
	} // main() 메소드의 종료
} // "}" <-- 코드블럭의 끝

/* class 선언 :
* 		"class 클래스이름 { }"
* 	class 내부에는 멤버변수와 멤버메소드 작성
*/
class BitCamp { }