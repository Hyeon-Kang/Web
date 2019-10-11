package week06;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class ChatServer {
	int port = 6000;
	ServerSocket server = null;
	Socket child = null;
	HashMap<String, PrintWriter> hm;
	
	public ChatServer() {
		ChatServerThread sr;
		Thread t;
		try {
			server = new ServerSocket(port); // 서버 소켓을 생성
			System.out.println("**********");
			System.out.println("* 채팅 서버 *");
			System.out.println("**********");
			System.out.println("클라이언트의 접속을 기다립니다.");
			hm = new HashMap<String, PrintWriter>();// 클라이언트의 객체를 관리할 HashMap
			while(true) {
				child = server.accept(); // 서버 클라이언트에서 접슥을 원하는 클라이언트의 소켓을 전달받음.
				if(child != null) {// 서버 클라이언트 소켓과 연결시
					sr = new ChatServerThread(child, hm); //채팅 스레드를 생성합니다.
					t = new Thread(sr);
					t.start(0;)
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ChatServer();
		
	}

}
