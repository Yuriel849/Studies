package study;

import java.io.*;
import java.net.*;

// 16-4 예제

class Ex02_Networking02 {
	public static void main(String[] args) {
		URL url = null;
		BufferedReader input = null;
		String address = "https://www.oracle.com/technetwork/developer-tools/sql-developer/downloads/index.html";
		String line = "";
		
		try {
			url = new URL(address);
			
			input = new BufferedReader(new InputStreamReader(url.openStream()));
			
			while((line = input.readLine()) != null) {
//				if(line.indexOf('@') != -1) {
					System.out.println(line);
//				}
			}
			input.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	} // main() 끝.
} // 클래스 끝.