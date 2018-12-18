package wordScramble;

import java.util.Scanner;

public class Ex04_WordScramble04 {
    public static void main(String[] args) { 
        String[] strArr = { "BERLIN IS THE CAPITAL OF GERMANY", "BOSTON IS A CITY IN AMERICA", "ROME IS THE CRADLE OF WESTERN CIVILIZATION", "APPLE IS NOT A GOOD APPLE"}; 
        
        String answer = ""; 
        String question = ""; 

        Scanner scan = new Scanner(System.in);
        String input = "";
        
        // 사용자 입력을 받아서 'q' or 'Q'면 종료하고, 아니면 사용자가 맞출 때까지 무한반복한다
        // 사용자가 맞춘 후에도 종료할 때까지 새로운 문제를 보여준다
        while (true) {
        	answer = getAnswer(strArr);
        	question = getScrambledWord(answer);
        	char[] hint = new char[answer.length()];
        	
        	// hint를 "_"로 초기화한다. 정답이 LOVE라면 hint는 "____"가 된다.
        	for(int i = 0; i < hint.length; i++) { hint[i] = '_'; }
        	
        	while(true) {
        		System.out.println("Question : " + question);
        		System.out.println("Your answer is : ");
        		System.out.println("Enter 'Q' to quit");
        		input = scan.nextLine();
        		if (input.equalsIgnoreCase("q")) {
        			System.out.println("Terminating...");
        			System.exit(0);
        		} else if (input.equalsIgnoreCase(answer)) {
        			System.out.println("Successful!!");
        			break;
        		} else {
        			System.out.println("Wrong answer... try again");
        			System.out.println("Hint : " + getHint(answer, hint));
        		}
        	} // inner while
        } // outer while
    } // main 

    // getAnswer(String[] strArr)는 배열strArr의 요소중의 하나를 임의로 골라서 반환한다
    public static String getAnswer(String[] strArr) { 
       int index = (int)(Math.random() * strArr.length);
       return strArr[index];
    }
    
    // getScrambledWord(String str)는 주어진 문자열 str의 각 문자의 순서를 뒤섞은 다음, 새로운 문자열로 반환한다
    public static String getScrambledWord(String str) { 
        char[] scr = str.toCharArray();
        
        char temp;
        for(int i = 0; i < 10; i++) {
        	int r = (int)(Math.random() * scr.length);
        	temp = scr[0];
        	scr[0] = scr[r];
        	scr[r] = temp;
        }

        return new String(scr);
    } // scramble(String str) 
    
    public static String getHint(String answer, char[] hint) {
    	 int count = 0; // 힌트에 포함된 '_'의 개수
    	 
    	 for(int i = 0; i < hint.length; i++) {
    		 if (hint[i] == '_') { count++; }
    	 }
    	 
    	 if (count > 2) {
    		 int r;
    		 do {
        		 r = (int)(Math.random() * hint.length); 
        	 } while (hint[r] != '_');
    		 hint[r] = answer.charAt(r);
    	 }

    	 return new String(hint);    	 
    } // getHint()
    
    
}