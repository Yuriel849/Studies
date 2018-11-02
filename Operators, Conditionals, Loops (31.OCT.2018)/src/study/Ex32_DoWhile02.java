package study;

public class Ex32_DoWhile02 {
	public static void main(String[] args) throws Exception {
		int input = 0;
		
		System.out.println("Enter a sentence of your choice (type 'x' to conclude your entry)");
		
		do {
			input = System.in.read();
			System.out.print((char) input);
		} while (input != -1 && input != 'x'); // EOF 찾으면 '-1' 반환된다 	
	}

}
