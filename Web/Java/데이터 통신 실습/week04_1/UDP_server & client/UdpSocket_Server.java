package week04_1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpSocket_Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int port = 3000;
		// 클라이언트에게 DatagramPacket을 전송하거나 수신하기 위해 DatagramSocket 객체 생성
		DatagramSocket dsock = null;
		
		
		// *** TCP와 달리 검증 단계가 없기 때문에 절차가 훨씬 간단하다.
		
		try {
			System.out.println("접속 대기상태입니다.");
			dsock = new DatagramSocket(port);
			String line = null;
			
			while(true) {
				//수신 대기
				
				byte[] buffer = new byte [1024];
				DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
				// 클라이언트로부터 DatagramPacket을 전송받기 위해서 DatagramPacket 객체 하나를 생성하고 패킷을 전송할 때까지 대기
				dsock.receive(receivePacket); // 데이터를 보내면 receivePacket으로 전달
				// 전송받은 데이터를 String 객체에 지정하고 출력
				String msg = new String(receivePacket.getData(), 0,receivePacket.getLength()); // 대기하다가 데이터가 들어오면 실행 0은 뭘까?
				System.out.println("전송 받은 문자열 : " + msg);
				if(msg.contentEquals("quit")) break; // 종료 검사
				// 전송받은 객체를 그대로 반송
				DatagramPacket sendPacket = new DatagramPacket(receivePacket.getData(), receivePacket.getData().length, 
						receivePacket.getAddress(), receivePacket.getPort()); // 보낸 사람의 Address와 port 정보를 받아옴. 받은 데이터를 그대로 반송함

				dsock.send(sendPacket);
				
				

			}
		System.out.println("UDPEchoServer를 종료합니다.");
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			if(dsock != null)
				dsock.close();
		}
	}

}
