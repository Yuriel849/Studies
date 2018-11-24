package chapter_09;

// format 메서드를 작성하라.

public class Exercise09_10 {
	static String format(String str, int length, int alignment) {
		// str -> 변환할 문자열
		// length -> 변환된 문자열의 길이
		// alignment -> 변환된 문자열의 정렬조건 (0: 왼쪽 정렬, 1: 가운데 정렬, 2: 오른쪽 정렬)
	
		// 1. length의 값이 str의 길이보다 작으면  length만큼만 잘라서 반환한다.
		if(str.length() > length) {
			return str.substring(0, length);
		} else {
			// 2. 1의 경우가 아니면, length크기의 char배열을 생성하고 공백으로 채운다.
			char[] origin = str.toCharArray();
			char[] result = new char[length];
			for(int i = 0; i < result.length; i++) {
				result[i] = ' '; // 배열 result를 공백으로 초기화한다.
			}
			// 3. 정렬조건(alignment)의 값에 따라 문자열(str)을 복사할 위치를 결정한다.
			if(alignment == 0) {
				System.arraycopy(origin, 0, result, 0, origin.length);
			} else if(alignment == 1) {
				System.arraycopy(origin, 0, result, (length - str.length())/2, origin.length);
			} else if(alignment == 2) {
				System.arraycopy(origin, 0, result, (length - str.length()), origin.length);
			}
			// 4. 2에서 생성한 char배열을 문자열로 만들어서 반환한다.
			return new String(result);
		}
	} // format() 끝.
	
	public static void main(String[] args) {
		String str = "가나다";
		
		System.out.println(format(str,7,0)); // 왼쪽 정렬
		System.out.println(format(str,7,1)); // 가운데 정렬
		System.out.println(format(str,7,2)); // 오른쪽 정렬
	} // main() 끝.
} // 클래스 끝.