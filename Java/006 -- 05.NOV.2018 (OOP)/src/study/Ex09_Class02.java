package study;

public class Ex09_Class02 {
	public static void main(String[] args) {
		Variables.cv = 20; // 참조변수도 인스턴스도 없는 상황에서 바로 클래스로 접근할 수 있는 것이 static variable
		System.out.println("참조변수도 인스턴스도 없는 상태에서 Variables.cv : " + Variables.cv);
		
		// cv = 20; --> 참조변수를 선언/생성하지 않아서 어디에 있는 cv인지 알 수가 없어 에러난다
		// vary.iv = 10; --> 참조변수를 선언/생성하지 않은 시점에서 접근할 수 없다
		// 				 --> 인스턴스를 생성하지 않은 시점에서 접근할 수 없다
		
		Variables vary1 = new Variables();
		System.out.println("인스턴스 vary1의 지역변수 초기값 --> vary1.iv : " + vary1.iv);
															// 초기화될 뿐, 값이 없다
		vary1.iv = 20;
		System.out.println("인스턴스 vary1의 지역변수 바꾼 후 --> vary1.iv : " + vary1.iv);
		System.out.println("인스턴스 vary1에서 static variable 접근 --> vary1.cv : " + vary1.cv);
		vary1.cv = 120;
		System.out.println("인스턴스 vary1에서 static variable 바꾼 후 --> vary1.cv : " + vary1.cv);
		Variables.cv = 240;
		Variables vary2 = new Variables();
		System.out.println("Variables에서 static variable 바꾼 후 --> vary2.cv : " + vary2.cv);
		System.out.println("인스턴스 vary2의 지역변수 초기값 --> vary2.iv : " + vary2.iv); // 초기화될 뿐, 값이 없다
		vary1.iv = 40;
		System.out.println("인스턴스 vary2의 지역변수 바꾼 후 -->vary1.iv : " + vary1.iv);
		vary2.cv = 500;
		System.out.println("인스턴스 vary2에서 static variable 바꾼 후 -->vary1.cv : " + vary1.cv);
		System.out.println("인스턴스 vary1에서 static variable 접근 --> vary1.cv : " + Variables.cv);
		System.out.println("Variables에서 static variable 접근 --> Variables.cv : " + Variables.cv);
	}

}

class Variables {
	int iv; // "iv" --> instance variable
	static int cv; // "cv" --> class variable == static variable == 공유변수
	
	public void method() {
		int lv; // "lv" --> local variable
	}
}