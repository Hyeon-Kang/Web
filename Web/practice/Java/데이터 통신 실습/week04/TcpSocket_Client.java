package week04;

import java.net.Socket;

public class TcpSocket_Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		try {
			Socket sock = new Socket("127.0.0.1", 10001);
			// 접속할 서버의 ip, port정보를 담은 Socket 객체 생성
			Send_thread send = new Send_thread(sock);
			// 해당 소켓 정보제공자와 수신 스레드 생성
			Recieve_thread recieve = new Recieve_thread(sock);
			// 해당 소켓 정보제공자와 송신 스레드 생성
			
			send.start(); // 송신 스레드 실행
			recieve.start(); // 수신 스레드 실행
		} catch(Exception e) {
			System.out.println(e);
		}
	}

}
