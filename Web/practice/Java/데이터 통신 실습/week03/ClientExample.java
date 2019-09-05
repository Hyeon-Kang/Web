package week3;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientExample {

	public static void main(String[] args) {
		try {
			// 서버와 연결을 위해 소켓 생성
			Socket sock = new Socket("127.0.0.1", 10001);
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

			// 생성된 소켓으로부터 InputStream과 OutputStream을 구함
			OutputStream out = sock.getOutputStream();
			InputStream in = sock.getInputStream();


			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));


			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line = null;


			while ((line = keyboard.readLine()) != null) {
				if(line.contentEquals("quit")) break;


				pw.println(line);
				pw.flush();



				String echo = br.readLine();
				System.out.println("서버로부터 전달받은 문자열 : " + echo);
			}

			pw.close();
			br.close();
			sock.close();
		} catch (Exception e ) {
			System.out.println(e);
		}





	}

}
