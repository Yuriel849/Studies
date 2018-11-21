package threads;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex_PatternTest {
	public static void main(String[] args) {
		String data = "   abs   adds  ";
		String pattern = " +";
		System.out.println(data);
		data = data.trim();
		String[] input = data.split(pattern);
		System.out.println(data);
		for(int i = 0; i < input.length; i++) {
			System.out.println(input[i]);
		}
		
	}

}
