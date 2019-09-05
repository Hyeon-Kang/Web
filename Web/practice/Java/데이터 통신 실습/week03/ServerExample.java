package week3;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {

	public static void main(String[] args) {
		try {
			// 10001번  ServerSocket생성
			ServerSocket server = new ServerSocket(10001);
			System.out.println("Wating Connect ...");


			// 클라이언트가 접속할 경우 accept() 메소드는 Socekt 객체를 반환
			Socket sock = server.accept();
			InetAddress inetaddr = sock.getInetAddress();
			System.out.println(inetaddr.getHostAddress() + " 로부터 접속했습니다.");


			// 반환받은 Socket으로부터 InputStream과 OutputStream을 구함
			OutputStream out = sock.getOutputStream();
			InputStream in = sock.getInputStream();


			// InputStream은 BufferedReader 형식으로 변환
			// OutputStream은 PrintWriter 형식으로 변환
			OutputStreamWriter out_writer = new OutputStreamWriter(out);
			PrintWriter pw = new PrintWriter(out_writer);
			//PrintWriter pw = new PrintWriter(new OutputStreamWriter(out)); out_writer 객체가 아닌 생성자에서 바로 객체를 받아 씀

			InputStreamReader in_reader = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(in_reader);
			//BufferedReader br = new BufferedReader(new InputStreamReader(in)); // 생성자에서 객체를 바로 받아 사용
			String line = null;


			// BufferedReader의 readLine() 메소드를 이용해 클라이언트가 보내는 문자열 한 줄을 읽어들임 (byte단위가 아니다)
			while((line = br.readLine()) != null) {
				System.out.println("클라이언트로부터 전송받은 문자열 : "+line);


				// PrintWriter의 println을 이용해 다시 클라이언트로 전송
				pw.println(line);
				pw.flush();
			}

			// IO 객체와 소켓의 Close() 호출
			pw.close();
			br.close();
			sock.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
