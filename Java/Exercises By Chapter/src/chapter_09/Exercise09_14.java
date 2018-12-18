package chapter_09;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 사용자에게 전화번호의 일부를 입력받아 일치하는 전화번호를 주어진 문자열 배열에서 찾아서 출력하라.
// Pattern & Matcher를 사용하라.

class Exercise09_14 {
	public static void main(String[] args) {
		String[] phoneNumArr = {
				"010-3456-7890",
				"099-2456-7980",
				"088-2346-9870",
				"013-3456-7890"
		};
		
		@SuppressWarnings("rawtypes")
		ArrayList list = new ArrayList();
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println(">>");
			String input = scan.nextLine().trim();
			
			if(input.equals("")) {
				continue;
			} else if(input.equalsIgnoreCase("Q")) {
				System.exit(0);
			}

			Pattern p = Pattern.compile(".*" + input + ".*");
			for(int i = 0; i < phoneNumArr.length; i++) {
				String phone = phoneNumArr[i].replace("-", "");
				
				Matcher m = p.matcher(phone );
				if(m.matches()) {
					list.add(phoneNumArr[i]);
				}
			}
			
			if(list.size() > 0) {
				System.out.println(list);
				list.clear();
			} else {
				System.out.println("일치하는 번호가 없습니다.");
			}
		} // while문 끝.
	} // main() 끝.
} // 클래스 끝.