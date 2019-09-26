package week04_1;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastClient {

	public static void main(String[] args) {
		int port = 3000;
		MulticastSocket m_sock = null;
		// 멀티케스트 소켓 객체 생성
		
		try {
			InetAddress address = InetAddress.getByName("235.123.44.55");
			// 224.0.0.0 부터 239.255.255.255 까지의 가상 주소가 멀티캐스트를 위해서 쓰일 수 있다.
			
			m_sock = new MulticastSocket(port);
			// 멀티캐스트 객체에 포트 지정
			byte[] buffer = new byte[1024];
			DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
			// 소켓을 통해 전달할 데이터를 담는 객체
			
			m_sock.joinGroup(address); // 로컬 ip 그룹에 참가
			while(true) {
				m_sock.receive(receivePacket); // 소켓을 통해 데이터를 받는다.
				String msg = new String(receivePacket.getData()); // 받은 데이터를 String 객체에 전달
				System.out.println(msg); // 받은 데이터 msg 출력
				if(msg.contentEquals("quit")) // 종료 입력 감시
					break;
			}
			m_sock.leaveGroup(address); // 멀티캐스터 채널 이탈 (접속 해제)
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		m_sock.close();
	}
	

}
