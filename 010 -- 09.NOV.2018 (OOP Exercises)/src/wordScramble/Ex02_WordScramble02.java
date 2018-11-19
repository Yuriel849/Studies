package wordScramble;

import java.util.Scanner;

public class Ex02_WordScramble02 {
    public static void main(String[] args) { 
        String[] strArr = { "CHANGE", "LOVE", "HOPE", "VIEW"}; 
        
        String answer = getAnswer(strArr); 
        String question = getScrambledWord(answer); 

        Scanner scan = new Scanner(System.in);
        String input = "";
        
        // 사용자 입력을 받아서 'q' or 'Q'면 종료하고, 아니면 사용자가 맞출 때까지 무한반복한다
        while(true) {
        	System.out.println("Question : " + question);
            System.out.println("Your answer is : ");
            System.out.println("Enter 'Q' to quit");
            input = scan.next();
            if (input.equalsIgnoreCase("q")) {
            	System.out.println("Terminating...");
            	break;
            } else if (input.equalsIgnoreCase(answer)) {
            	System.out.println("Successful!!");
            	break;
            }
        }
        scan.close();
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
}