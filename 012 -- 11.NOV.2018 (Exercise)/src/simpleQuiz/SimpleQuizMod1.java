package simpleQuiz;

//data의 내용을 문제, 답, 선택지로 나눠서 배열에 다시 저장한다.
class SimpleQuizMod1 { 
	public static void main(String[] args) { 
		String[] data = { 
				"다음 중 키워드가 아닌 것은?`2`final`True`if`public", 
                "다음 중 자바의 연산자가 아닌 것은?`5`&`|`++`!=`/`^", 
                "다음 중 메서드의 반환값이 없음을 의미하는 키워드는?`1`void`null`false", 
			}; 
		String[][] sData = new String[3][3];
		
		String[] temp; // sData의 3번째 칸의 내용, 선택지 문자열을 split으로 나눴을 때 반환되는 문자열을 임시로 저장하기 위한 문자열 배열
		for(int i=0;i<data.length;i++) {
			// 1. String클래스의 String[] split(String regex, int limit)를 사용해서 문제와 선택지를 나누세요.
			sData[i] = data[i].split("`", 3);

			// 2. 문제를 출력하세요.
			System.out.println("[" + (i+1) + "] " + sData[i][0]);

			// 3. 선택지를 나누기 위해 String[] split(String regex)를 사용하세요.
			temp = sData[i][2].split("`");

            // 4.반복문을 이용해서 선택지를 출력하세요.
			for(int j = 0; j < temp.length; j++) {
				System.out.print((j+1) + ". " + temp[j] + " ");
			}
			System.out.println();
		} // for문 종료
	} // main() 종료 
}