package consoleApp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 지정된 파일의 내용을 보여주는 type명령을 구현하라. type명령의 형식은 'type FILE_NAME'이며, FILE_NAME으로 지정된 파일을 찾아서 그 내용을 화면에 보여줘야한다.
 * 단, FILE_NAME은 현재 디렉토리에 포함된 파일이어야 하며, 해당 파일이 존재하지 않으면 존재하지 않는 파일이라고 화면에 출력한다.
 */

class Ex07_ConsoleApp06 { 
	static String[] argArr; // 사용자 입력을 담기위한 문자열 배열
	@SuppressWarnings("rawtypes")
	static LinkedList q = new LinkedList(); // 사용자의 입력을 저장할 queue로서 LinkedList 클래스의 객체 생성
	static final int MAX_SIZE = 5; // q의 최대 크기
	
    static File curDir; // 현재 디렉토리

	static {
		try {
			// 시스템속성 "user.dir" 값을 읽어서 File 객체를 만들고, curDir에 할당하라.
			curDir = new File(System.getProperty("user.dir"));
		} catch (Exception e) {}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // 한번만 생성해서 재사용하면되니까 while문 밖에 위치
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
				} else if(command.equals("history")) {  // 이전에 command를 소문자로 바꿔놨으니까 equalsIgnoreCase대신 equals를 사용.
					history(); 
				} else if(command.equals("dir")) {
					dir();
				} else if(command.equals("type")) {
					type();
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
	
	public static void type() throws IOException {
		if(argArr.length != 2) {
			System.out.println("Usage : type FILE_NAME");
			return;
		}
		
		String fileName = argArr[1];
		
		File tmp = new File(curDir, fileName); // 생성자 File(String pathName, String fileName)
		
		// 1. 파일(tmp)가 존재하는지 확인하고,
		if(tmp.exists()) {
			// 2. 존재하면, 파일의 내용을 화면에 출력한다.
			FileReader fr = new FileReader(tmp);
			BufferedReader br = new BufferedReader(fr);
			
			String line = "";
			for(int i = 1; (line = br.readLine()) != null; i++) {
				System.out.println(i + ":" + line);
			}
			br.close();
			// 3. 존재하지 않으면, 존재하지 않는 파일이라고 출력한다.
		} else { System.out.println(fileName + " - 존재하지 않는 파일입니다."); }
		
		return;
	} // type() 끝.
} // 클래스 끝.