package consoleApp;

import java.io.*;
import java.util.*;
import java.util.regex.*;

/* 디렉토리를 변경하는 cd명령을 구현하라.
 * 	>> 명령어의 형식은 'cd DIRECTORY'이며 DIRECTORY는
 * 		>> 현재 디렉토리의 하위 디렉토리이거나
 * 		>> 현재 디렉토리를 의미하는 '.'이거나
 * 		>> 조상 디렉토리를 의미하는 '..'일 수 있다.
 */

class Ex10_ConsoleApp09 {
	static String[] argArr; // 사용자 입력을 담기위한 문자열 배열
	@SuppressWarnings("rawtypes")
	static LinkedList q = new LinkedList(); // 사용자의 입력을 저장할 queue로서 LinkedList 클래스의 객체 생성
	static final int MAX_SIZE = 5; // q의 최대 크기

	static File curDir; // 현재 디렉토리

	static {
		try {
			// 시스템속성 "user.dir" 값을 읽어서 File 객체를 만들고, curDir에 할당하라.
			curDir = new File(System.getProperty("user.dir"));
		} catch (Exception e) {
		}
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // 한번만 생성해서 재사용하면되니까 while문 밖에 위치
		String input = "";
		String command = "";
		while (true) {
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
				if ("".equals(command)) {
					continue;
				}

				// 명령어를 소문자로 바꾼다.
				command = command.toLowerCase();

				if (command.equals("q")) { // q 또는 Q를 입력하면 실행종료한다.
					System.out.println("Thank you for utilizing our services :)");
					System.exit(0);
				} else if (command.equals("history")) { // 이전에 command를 소문자로 바꿔놨으니까 equalsIgnoreCase대신 equals를 사용.
					history();
				} else if (command.equals("dir")) {
					dir();
				} else if (command.equals("type")) {
					type();
				} else if (command.equals("find")) {
					find();
				} else if (command.equals("find2")) {
					find2();
				} else if (command.equals("cd")) {
					cd();
				} else {
					for (String str : argArr) {
						System.out.println(str);
					} // for문 끝.
				} // if-else문 끝.
			} catch (Exception e) {
				System.out.println("입력오류입니다.");
			} // 예외처리 끝.
		} // while(true) 끝.
	} // main() 끝.

	// 사용자의 입력을 q에 저장하는 메서드
	@SuppressWarnings("unchecked")
	public static void save(String input) {
		if (input == null || "".equals(input)) {
			return;
		}
		// queue의 최대크기(MAX_SIZE)를 넣으면 제일 오래된 저장값을 삭제한다.
		else if (q.size() == MAX_SIZE) {
			q.remove();
		}
		// queue에 저장한다.
		q.add(input);
	} // save() 끝.

	// 사용자가 입력한 최근 명령을 보여주는 메서드
	public static void history() {
		int i = 0;
		// LinkedList에 저장된 내용(최근 MAX_SIZE개의 명령어)을 보여준다.
		@SuppressWarnings("rawtypes")
		Iterator it = q.iterator();
		while (it.hasNext()) {
			System.out.println((i + 1) + "." + it.next());
		}
		// for(; i < MAX_SIZE; i++) {
		// System.out.println((i+1) + "." + q.get(i));
		// }
	} // history() 끝.

	// 현재 디렉토리의 파일과 디렉토리를 보여주는 메서드
	public static void dir() {
		String pattern = "";

		File[] file = curDir.listFiles();
		switch (argArr.length) {
		case 1: // dir만 입력한 경우 현재 디렉토리의 모든 파일과 디렉토리를 보여준다.
			// 1. 반복문을 이용해서 현재디렉토리의 모든 파일의 목록을 출력한다.
			for (File f : file) {
				// 2. 조건문을 같이 사용해서 디렉토리(폴더)인 경우, 이름의 앞뒤에 '[' 와 ']'를 붙여서 출력한다.
				if (f.isDirectory()) {
					System.out.println("[" + f.getName() + "]");
				} else {
					System.out.println(f.getName());
				}
			}
			break;
		case 2: // // dir과 패턴을 같이 입력한 경우, 예를 들면 dir *.class
			pattern = argArr[1];

			pattern = pattern.toUpperCase(); // 패턴에서 대소문자를 구별하지 않도록 대문자로 변경한다.

			// 1. 입력된 패턴(pattern)을 정규식 표현(Regular Expression)에 알맞게 치환한다.
			pattern = pattern.replace("*", ".*");
			pattern = pattern.replace("?", ".");

			Pattern p = Pattern.compile(pattern);

			for (File f : file) {
				// 2. 대소문자구별을 하지 않기 위해서, 패턴과 마찬가지로 파일이나 디렉토리명을 대문자로 변경해야한다.
				String tmp = f.getName().toUpperCase();
				Matcher m = p.matcher(tmp);

				// 3. 반복문을 이용해서 현재 디렉토리 중, 입력된 패턴과 일치하는 것들만 출력한다.
				if (m.matches()) {
					// 4. 조건문을 같이 사용해서 디렉토리(폴더)인 경우, 이름의 앞뒤에 '[' 와 ']'를 붙여서 출력한다.
					if (f.isDirectory()) {
						System.out.println("[" + f.getName() + "]");
					} else {
						System.out.println(f.getName());
					}
				}
			} // for문 끝.
			break;
		default:
			System.out.println("USAGE : dir [FILENAME]");
		} // switch문 끝.
	} // dir() 끝.

	// 지정된 파일의 내용을 보여주는 메서드
	public static void type() throws IOException {
		if (argArr.length != 2) {
			System.out.println("Usage : type FILE_NAME");
			return;
		}

		String fileName = argArr[1];

		File tmp = new File(curDir, fileName); // 생성자 File(String pathName, String fileName)

		// 1. 파일(tmp)가 존재하는지 확인하고,
		if (tmp.exists()) {
			// 2. 존재하면, 파일의 내용을 화면에 출력한다.
			FileReader fr = new FileReader(tmp);
			BufferedReader br = new BufferedReader(fr);

			String line = "";
			for (int i = 1; (line = br.readLine()) != null; i++) {
				System.out.println(i + ":" + line);
			}
			br.close();
			// 3. 존재하지 않으면, 존재하지 않는 파일이라고 출력한다.
		} else {
			System.out.println("존재하지 않는 파일입니다.");
		}

		return;
	} // type() 끝.

	// 지정된 키워드를 지정된 파일에서 찾아서 화면에 보여주는 메서드
	@SuppressWarnings("resource")
	public static void find() throws IOException {
		if (argArr.length != 3) {
			System.out.println("USAGE : find KEYWORD FILE_NAME");
			return;
		}

		String keyword = argArr[1];
		String fileName = argArr[2];

		File tmp = new File(fileName);
		// 1. 파일(tmp)이 존재하면,
		if (tmp.exists()) {
			// 2. 반복문을 이용해서 라인별로 읽어서 keyword가 포함되었는지 확인한다.
			FileReader fr = new FileReader(tmp);
			BufferedReader br = new BufferedReader(fr);

			String line = "";
			for (int i = 1; (line = br.readLine()) != null; i++) {
				if (line.contains(keyword)) { // contains()는 내부적으로 indexOf()를 사용한다 --> i.e. 둘이 똑같다!!
					// 3. keyword가 포함된 라인을 발견하면, 라인번호와 함께 해당 라인을 화면에 출력한다.
					System.out.printf("%d : %s\n", i, line);
				}
			}
		} else {
			// 4. tmp가 존재하지 않으면, 존재하지 않는 파일이라고 화면에 출력한다.
			System.out.println(fileName + "은 존재하지 않는 파일입니다.");
		}
		return;
	} // find() 끝.

	// 지정된 키워드를 지정된 정규식과 일치하는 현재 디렉토리의 모든 파일에서 찾아서 화면에 보여주는 메서드
	@SuppressWarnings("resource")
	public static void find2() throws IOException {
		if (argArr.length != 3) {
			System.out.println("USAGE : find2 KEYWORD FILE_NAME");
			return;
		}

		String keyword = argArr[1];
		String pattern = argArr[2];
		pattern = pattern.toUpperCase();

		// 1. 입력된 패턴(pattern)을 정규식 표현(Regular Expression)에 알맞게 치환한다.
		pattern = pattern.replace("*", ".*");
		pattern = pattern.replace("?", ".");

		Pattern p = Pattern.compile(pattern);

		// 2. 반복문을 이용해서 현재 디렉토리 중, 입력된 패턴과 일치하는 것들에 대해서,
		File[] file = curDir.listFiles();
		for (File f : file) {

			String tmp = f.getName().toUpperCase();
			Matcher m = p.matcher(tmp);

			if (m.matches()) {
				if (f.isDirectory()) {
					continue;
				}

				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);

				// 3. 반복문을 이용해서 라인별로 읽어서 keyword가 포함되었는지 확인한다.
				String line = "";
				System.out.println("---------------" + f);
				for (int i = 1; (line = br.readLine()) != null; i++) {
					if (line.contains(keyword)) { // contains()는 내부적으로 indexOf()를 사용한다 --> i.e. 둘이 똑같다!!
						// 4. keyword가 포함된 라인을 발견하면, 라인번호와 함께 해당 라인을 화면에 출력한다.
						System.out.printf("%d : %s\n", i, line.trim());
					}
				}
			}
		} // for문 끝.
		return;
	} // find2() 끝.

	// 디렉토리를 변경하는 메서드.
	public static void cd() {
		if (argArr.length == 1) {
			System.out.println(curDir);
			return;
		} else if (argArr.length > 2) {
			System.out.println("USAGE : cd directory");
			return;
		}

		String subDir = argArr[1];

		// 1. 입력된 디렉토리(subDir)가 ".."이면,
		if(subDir.equals("..")) {
			// 2. 현재 디렉토리의 조상 디렉토리를 얻어서 현재 디렉토리로 지정한다. (File클래스의 getParentFile()을 사용)
			File tmp = curDir.getParentFile();
			if(tmp == null) {
				System.out.println("유효하지 않은 디렉토리입니다.");
			} else {
				curDir = tmp;
			}
		} else if(subDir.equals(".")) {
			// 2. 입력된 디렉토리(subDir)가 "."이면, 단순히 현재 디렉토리의 경로를 화면에 출력한다.
			System.out.println(curDir);;
		} else {
			// 3. 1 또는 2의 경우가 아니면, 입력된 디렉토리(subDir)가 현재 디렉토리의 하위디렉토리인지 확인한다.
			File dir = new File(curDir, subDir);
			if(dir.exists() && dir.isDirectory()) {
				curDir = dir;
				// 4. 확인결과가 true이면, 현재 디렉토리(curDir)을 입력된 디렉토리(subDir)로 변경한다.
			} else {
				// 5. 확인결과가 false이면, "유효하지 않은 디렉토리입니다."고 화면에 출력한다.
				System.out.println("유효하지 않은 디렉토리입니다.");
			} // 내부 if-else문 끝.
		} // 바깥 if-else문 끝.
	} // cd() 끝.
} // 클래스 끝.