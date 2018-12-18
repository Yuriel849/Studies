package study;

/* TO RENAME IN THE PACKAGE EXPLORER
 * 		>> highlight the class or package and press 'F2' on the keyboard
 * 
 * TO MAKE A COPY IN THE PACKAGE EXPLORER
 * 		>> ctrl+c + ctrl+v로 파일 복사본 만들 수 있다.
 * 		>> 기존 파일의 내용 전체를 재사용하고 싶을 때 사용 가능
 */
public class Ex15_Switch01 {
	public static void main(String args[]) {
		int number = 1;
		
		// switch의 case는 단순비교만 가능하다
		switch(number) {
		case 1: // if(number == 1);
			System.out.println("case 1 실행");
			if (true) {
				break;
			} // break는 중괄호 하나를 벗어난다... break는 반복문 switch문에만 효과있고 if문에는 무의미
		case 2: // else if(number == 2);
			System.out.println("case 2 실행"); break;
		case 3: // else if(number == 3);
			System.out.println("case 3 실행"); break;
		default:// else
			System.out.println("default 실행");
			// 어차피 default가 마지막이기에 default에서 break;는 optional
		}
	}
}