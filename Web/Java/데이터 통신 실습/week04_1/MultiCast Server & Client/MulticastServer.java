package week04_1;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastServer {

	public static void main(String[] args) {
		int port = 3000;
		InetAddress address = null;
		MulticastSocket m_sock = null;
		// 멀티캐스트 소켓 객체 생성
		
		try {
			address = InetAddress.getByName("235.123.44.55");
			// 멀티캐스트를 위한 가상 주소. 지정되어있음
			// 일반적으로 UDP 통신은 클라이언트가 서버 ip로 찾아오지만 멀티캐스트는
			// 채널을 하나 잡아놓고 해당 채널에 다수의 유저가 들어와 데이터를 전달받는 형식이다.
			
			System.out.println("접속 대기상태");
			m_sock = new MulticastSocket(port);
			// 멀티캐스트 객체에 포트 번호 부여
			String line = "안녕하세요, 멀티케스트 중입니다.";
			
			// 입력을 기다렸다가 line에 집어넣으면 입력한 데이터를 보내줄 프로그램 완성!
			
			while(true) {
				byte[] buffer = new byte[1024];
				DatagramPacket multicastPacket = new DatagramPacket(line.getBytes(), line.getBytes().length, address, port);
				// 멀티캐스트 채널에 전달할 데이터를 담는 객체
				m_sock.send(multicastPacket);
				// 소캣을 통해 멀티캐스트 채널에 데이터 송신
				Thread.sleep(3000);
				// 3초 스레드 대기
			}
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			if(m_sock != null)
				m_sock.close();
		}

	}

}
