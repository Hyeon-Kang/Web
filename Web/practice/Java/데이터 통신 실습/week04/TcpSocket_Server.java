package week04;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpSocket_Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			ServerSocket server = new ServerSocket(10001);
			// 서버 접속에 필요한 서버소켓 포트 선언
			System.out.println("Waiting connect ...");
			//접속 안내 문구 출력
			
			Socket sock = server.accept(); // 통신 수락
			InetAddress inetaddr = sock.getInetAddress();
			// 접속 소켓으로부터 ip address 획득
			System.out.println(inetaddr.getHostAddress()+ " 로부터 접속했습니다.");
			
			Send_thread send = new Send_thread(sock); // sock 과 송신 스레드 생성
			Recieve_thread recieve = new Recieve_thread(sock); // sock 과 수신 스레드 생성
			
			send.start(); // 송신 스레드 시작
			recieve.start(); // 수신 스레드 시작
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
