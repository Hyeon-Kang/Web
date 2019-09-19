//package week04;


// 송신 스레드 클래스

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Send_thread extends Thread {
	Socket sock;
	public Send_thread(Socket sock) { // 인자로 받은 소켓 정보와 송신 스레드 실행
		this.sock = sock;
	}

	public void run( ) {
		try {
			OutputStream out; // 송신 Stream 객체 out 생성
			out = sock.getOutputStream(); // 전송 스트림 객체 out에 sock 데이터로 상대 정보 전달
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
			// 입력을 받아 전송하는 객체, 전송 스트림 out과 연결됨
			String line;
			BufferedReader keyboard = new BufferedReader(new InputStreamReader (System.in));
			// 키보드로부터 입력받은 데이터를 버퍼 객체에 저장

			while(true) {
				if ((line=keyboard.readLine()) != null) { // 키보드 버퍼에 데이터가 있다면(들어왔다면)
					pw.println(line); // pw에 전달 후
					pw.flush(); // pw에 들어있는 모든 데이터를 출력 후 초기화(비우기)
				}

				if(line.equals("quit")) break; // quit 입력시 종료
			}

			pw.close(); // pw 자원 회수
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
