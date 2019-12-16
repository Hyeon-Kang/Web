package week06;

import java.net.*;
import java.io.*;

public class ChatClient {
	String ipAddress;
	static final int port = 6000;
	Socket client = null;
	
	BufferedReader read;
	PrintWriter oos;
	BufferedReader ois;
	String sendData;
	String receiveData;
	
	String user_id;
	ReceiveDataThread rt;
	boolean endflag = false;
	
	public ChatClient(String id, String ip) {
		user_id = id;
		ipAddress = ip;
		try {
			System.out.println("**** 클라이언트 ****");
			client = new Socket(ipAddress, port);
			
			read = new BufferedReader(new InputStreamReader(System.in));
			
			ois = new BufferedReader ( new InputStreamReader(client.getInputStream()));
			oos = new PrintWriter(client.getOutputStream());
			
			oos.println(user_id);
			oos.flush();
			
			rt = new ReceiveDataThread(client, ois);//수신 쓰레드 생성
			Thread t = new Thread(rt);
			t.start();
			
			while(true) {
				sendData = read.readLine(); // 콘솔에 입력된 텍스트 읽어옴
				
				oos.println(sendData);// output Stream을 통해 서버로 데이터 전송
				
				if(sendData.contentEquals("/quit")) {
					endflag = true;
					break;
				}
				
			}
			System.out.println("클라이언트의 접속을 종료합니다. ");
			System.exit(0);
		} catch(Exception e) {
			if(!endflag) e.printStackTrace();
		} finally {
			try {
				ois.close();
				oos.close();
				client.close();
				System.exit(0);;
			} catch(IOException e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new ChatClient("11", "127.0.0.1");
	}

}
