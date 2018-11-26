package study;

import java.io.*;
import java.net.*;
import java.util.*;

// 16-13 예제 --> Ex06_Networking06에 사용하기 위해서

class Ex05_Networking05 {
	@SuppressWarnings("rawtypes")
	HashMap clients;
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	Ex05_Networking05() {
		clients = new HashMap();
		Collections.synchronizedMap(clients);
	}
	
	
	public static void main(String[] args) {
		new Ex05_Networking05().start();
	}
	
	
	public void start() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("서버가 시작되었습니다.");
			
			while(true) {
				socket = serverSocket.accept();
				System.out.println("[" + socket.getInetAddress() + ":" + socket.getPort() + "]" + "에서 접속하였습니다.");
				ServerReceiver thread = new ServerReceiver(socket);
				thread.start();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	} // start() 끝.
	
	
	@SuppressWarnings("rawtypes")
	void sendToAll(String msg) {
		Iterator it = clients.keySet().iterator();
		
		while(it.hasNext()) {
			try {
				DataOutputStream out = (DataOutputStream)clients.get(it.next());
				out.writeUTF(msg);
			} catch(Exception e) {}
		}
	} // sendToAll() 끝.
	
	
	class ServerReceiver extends Thread {
		Socket socket;
		DataInputStream in;
		DataOutputStream out;
		
		ServerReceiver(Socket socket) {
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());
			} catch(IOException e) {}
		}
		
		@SuppressWarnings("unchecked")
		public void run() {
			String name = "";
			try {
				name = in.readUTF();
				sendToAll("#" + name + "님이 들어왔습니다.");
				
				clients.put(name, out);
				System.out.println("현재 서버접속자 수는 " + clients.size() + "입니다.");
				
				while(in != null) {
					sendToAll(in.readUTF());
				}
			} catch(IOException e) {
				// ignore
			} finally {
				sendToAll("#" + name + "님이 나갔습니다.");
				clients.remove(name);
				System.out.println("[" + socket.getInetAddress() + ":" + socket.getPort() + "]" + "에서 접속을 종료하였습니다.");
				System.out.println("현재 서버접속자 수는 " + clients.size() + "입니다.");
			} // try-catch-finally문 끝.
		} // run() 끝.
	} // ServerReceiver 내부 클래스 끝.
} // 클래스 끝.