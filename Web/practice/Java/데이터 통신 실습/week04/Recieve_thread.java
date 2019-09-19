//ackage week04;

// 수신 스레드
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Recieve_thread extends Thread{
	Socket sock;
	public Recieve_thread(Socket sock) {
		this.sock = sock;

	}

	public void run() {
		try {
			InputStream in = sock.getInputStream(); // 통신에 사용할 InputStream 객체 in 생성
			// InputStream은 바이트 단위 인코딩, InputStreamReader는 문자단위 인코딩
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			// 입 출력 통신을 원활하게 하기 위한 버퍼 생성, 버퍼는 InputStreamReader로부터 문자 단위로 읽어온다.
			String line;

			while(true) {
				if ((line= br.readLine()) != null) { // line에 버퍼 br내용 저장, 이것이 null 이 아니라면 문장 출력
					System.out.println(sock.getInetAddress() + ":" + line);
				}
				if(line.contentEquals("quit")) break; // quit 입력시 탈출 (종료)
			}

			br.close(); // 버퍼 자원 수납

			// 데이터를 받는 스트림 객체 in 은 close 안 하나??

		}catch (Exception e ) {
			//
		}
	}
}
