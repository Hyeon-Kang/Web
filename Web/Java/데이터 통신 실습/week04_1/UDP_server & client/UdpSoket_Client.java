package week04_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class UdpSoket_Client {

	public static void main(String[] args) {
		String ip = "localhost"; // 로컬호스트 ip, loopback ip
		int port = 2000;
		int server_port = 3000; // 접근할 서버의 포트
		InetAddress inetaddr = null; // ip주소 표현 객체 생성
		
		try {
			inetaddr = InetAddress.getByName(ip); // ip 객체에 주소 부여
		} catch (UnknownHostException e) { // 임의의 호스트 예외처리
			e.printStackTrace();
		}
		
		DatagramSocket dsock = null; // 데이터 그램 패킷 전송을 위한 소캣객체 생성
		try {
			// 키보드로부터 서버에게 전송할 문자열을 입력받기 위해
			// System.in을 BufferedReader 형태로 변환
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			dsock = new DatagramSocket(port); // 데이터 소켓 객체에 포트 번호 부여 (자신의 포트번호)
			String line = null;
			while((line = br.readLine())!= null) {
				//DatagramPacket 에 각 정보를 담고 전송 ( 보낼 데이터, 데이터의 길이, ip 주소, 서버의 port)
				DatagramPacket sendPacket = new DatagramPacket(line.getBytes(), line.getBytes().length, inetaddr, server_port);
				dsock.send(sendPacket); // 소켓 객체로 데이터 전송
				if(line.equals("quit")) break; // 종료 감시
				byte[] buffer = new byte[line.getBytes().length];
				// 반송되는 DatagramPacket을 받기 위해
				// receivePacket 객체를 생성한 후 대기
				DatagramPacket receivePacket =  new DatagramPacket(buffer, buffer.length); // 받을 데이터 객체 양식
				
				dsock.receive(receivePacket); // dscok으로 데이터 패킷을 받아옴
				
				String msg = new String(receivePacket.getData(), 0, receivePacket.getData().length);// String에 받은 데이터 객체 전달
				
				System.out.println("전송받은 문자열 : "+msg);// 받은 결과 출력
			}
			
		System.out.println("UDPEchoClient를 종료합니다.");
		
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			if(dsock != null)
				dsock.close(); // 자원 반납
		}

	}

}
