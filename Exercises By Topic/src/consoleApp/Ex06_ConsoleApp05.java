package consoleApp;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 현재 디렉토리의 파일과 디렉토리의 목록을 보여주는 명령어 dir을 구현하라.
 * 	>> dir만 입력하면 모든 파일과 디렉토리를, dir *ex?.* 와 같이 패턴을 입력하면 패턴과 일치하는 파일 또는 디렉토리의 목록을 보여줘야한다.
 * 	>> (패턴에서 '*'와 '?'는 와일드 카드로 '*'는 임의의 여러 글자가 올 수 있으며, '?'는 임의의 한글자를 의미한다.
 */

class Ex06_ConsoleApp05 { 
	static String[] argArr; // 사용자 입력을 담기위한 문자열 배열
	@SuppressWarnings("rawtypes")
	static LinkedList q = new LinkedList(); // 사용자의 입력을 저장할 queue로서 LinkedList 클래스의 객체 생성
	static final int MAX_SIZE = 5; // q의 최대 크기
	
    static File curDir; // 현재 디렉토리

	static {
		try {
			// 1. 시스템속성 "user.dir" 값을 읽어서 File 객체를 만들고, curDir에 할당하라.
			curDir = new File(System.getProperty("user.dir"));
			// 2. 1번의 코드를 간단히 예외처리하라.
		} catch (Exception e) {}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = "";
		String command = "";
		while(true)	{
			try {
				String prompt = curDir.getCanonicalPath() + ">>";
				System.out.print(prompt);
				
				// 화면으로부터 라인단위로 입력받는다.
				input = scan.nextLine();
				
				// 입력값을 q에 저장한다
				save(input);
				
				// 입력 받은 값에서 앞뒤 공백을 제거한다
				input.trim();
				
				// 입력 받은 명령라인의 내용을 공백을 구분자로 해서 나눠서 argArr에 담는다. (String 클래스의 split() 사용)
				argArr = input.split(" +");
					// split의 인수로는 정규식을 줘야 하는데, " +"의 의미는 + 앞의 문자(여기서는 공백)가 한 개 혹은 그 이상이라는 의미다.
				
				// input을 split()한 후 그 첫번째 내용을 command에 대입한다.
				command = argArr[0].trim();
				
				// 0번째 요소가 공백이면 while을 다음 반복을 continue한다.
				if("".equals(command)) { continue; } 
				
				// 명령어를 소문자로 바꾼다.
				command = command.toLowerCase(); 
				
				if(command.equals("q")) { // q 또는 Q를 입력하면 실행종료한다. 
					System.out.println("Thank you for utilizing our services :)");
					System.exit(0); 
				} else if(command.equals("history")) {  // equalsIgnoreCase대신 equals를 사용.
					history(); 
				} else if(command.equals("dir")) { 
					dir(); 
				} else {
					for(String str : argArr) {
						System.out.println(str);
					} // for문 끝.
				} // if-else문 끝.
			} catch(Exception e) {
				System.out.println("입력오류입니다.");
			} // 예외처리 끝.
		} // while(true) 끝.
	} // main() 끝.
	
	// 사용자의 입력을 q에 저장하는 메서드
	public static void save(String input) { 
		if(input==null || "".equals(input)) { return; }
			// queue의 최대크기(MAX_SIZE)를 넣으면 제일 오래된 저장값을 삭제한다.
		else if(q.size() == MAX_SIZE) { q.remove(); }
			// queue에 저장한다.
		q.add(input);
	} // save() 끝.

	// 사용자가 입력한 최근 명령을 보여주는 메서드
	public static void history() { 
		int i = 0;
			// LinkedList에 저장된 내용(최근 MAX_SIZE개의 명령어)을 보여준다.
		@SuppressWarnings("rawtypes")
		Iterator it = q.iterator();
		while(it.hasNext()) {
			System.out.println((i+1) + "." + it.next());
		}
//		for(; i < MAX_SIZE; i++) {
//			System.out.println((i+1) + "." + q.get(i));
//		}
	} // history() 끝.
	
	public static void dir() { 
		String pattern = ""; 
		
		File[] file = curDir.listFiles();
		switch(argArr.length) { 
			case 1 : // dir만 입력한 경우 현재 디렉토리의 모든 파일과 디렉토리를 보여준다.
				// 1. 반복문을 이용해서 현재디렉토리의 모든 파일의 목록을 출력한다.
				for(File f : file) { 
					// 2. 조건문을 같이 사용해서 디렉토리(폴더)인 경우, 이름의 앞뒤에 '[' 와 ']'를 붙여서 출력한다.
					if(f.isDirectory()) { 
						System.out.println("["+f.getName()+"]"); 
					} else { 
						System.out.println(f.getName()); 
					} 
				} 
				break; 
			case 2 : // // dir과 패턴을 같이 입력한 경우, 예를 들면 dir *.class
				pattern = argArr[1]; 
				
				pattern = pattern.toUpperCase(); // 패턴에서 대소문자를 구별하지 않도록 대문자로 변경한다.
				 
				// 1. 입력된 패턴(pattern)을 정규식 표현(Regular Expression)에 알맞게 치환한다.
				pattern = pattern.replace("*",".*"); 
				pattern = pattern.replace("?","."); 

				Pattern p = Pattern.compile(pattern); 

				for(File f : file) {
                    // 2. 대소문자구별을 하지 않기 위해서, 패턴과 마찬가지로 파일이나 디렉토리명을 대문자로 변경해야한다.
					String tmp = f.getName().toUpperCase();
					Matcher m = p.matcher(tmp); 
					
					// 3. 반복문을 이용해서 현재 디렉토리 중, 입력된 패턴과 일치하는 것들만 출력한다.
					if(m.matches()) {
						// 4. 조건문을 같이 사용해서 디렉토리(폴더)인 경우, 이름의 앞뒤에 '[' 와 ']'를 붙여서 출력한다.
						if(f.isDirectory()) {
							System.out.println("["+f.getName()+"]");
						} else {
							System.out.println(f.getName());
						}
					}
				} // for문 끝.
				break; 
			default : 
				System.out.println("USAGE : dir [FILENAME]"); 
		} // switch문 끝. 
	} // dir() 끝. 
} // 클래스 끝.