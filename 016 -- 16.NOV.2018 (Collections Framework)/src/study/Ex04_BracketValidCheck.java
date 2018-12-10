package study;

import java.util.EmptyStackException;
import java.util.Stack;

public class Ex04_BracketValidCheck {
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("Usage : java Ex04_BracketValidCheck \"EXPRESSION\"");
			System.out.println("Example : java Ex04_BracketValidCheck \"((2+3)*1)+3\"");
			System.exit(0);
		}
		/* 커맨드라인 입력을 eclipse에서 하려면...
		 * 	>> "Run" >> "Run Configurations" >> "Arguments" >> "Program Arguments" >> "Apply" & "Run"
		 */
		
		Stack st = new Stack();
		String expression = args[0];
		
		System.out.println("expression : " + expression);
		
		try {
			for(int i = 0; i < expression.length(); i++) {
				char ch = expression.charAt(i);
				
				if(ch == '(') { st.push(ch+""); }
				else if(ch == ')') { st.pop(); }
			}
			
			if(st.isEmpty()) { System.out.println("괄호가 일치합니다."); }
			else { System.out.println("괄호가 일치하지 않습니다."); }			
		} catch (EmptyStackException e) {
			System.out.println("괄호가 일치하지 않습니다.");
		} // try-catch문 끝.
	} // main() 끝.
} // 클래스 끝.
