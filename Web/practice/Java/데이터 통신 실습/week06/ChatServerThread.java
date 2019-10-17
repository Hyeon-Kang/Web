package week06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

public class ChatServerThread implements Runnable {
	Socket child; // 클라이어느의 소켓이 저장될 객체
	BufferedReader ois; // 서버 입장에서 클라이언트가 보내는 메세지를 수신하는 reader
	PrintWriter oos; // 서버에서 클라이언트로 메세지를 송신하는 writer

	String user_id; // 클라이언트의 id
	HashMap<String, PrintWriter> hm; // 채팅에 참여하는 참여자의 소켓ID와 보낼 데이터 객체가 담기는 HashMap 변수
	InetAddress ip; // 클라이언트의 IP
	String msg; // 클라이언트가 송신한 메세지가 저장될 변수

	public ChatServerThread(Socket s, HashMap<String, PrintWriter> h) {
		// 소켓과 채팅에 참여하는 참여자의 소켓과 ID 정보가 담기는 HashMap을 전달받음
		child = s;
		hm = h;

		try {
			ois = new BufferedReader( new InputStreamReader(child.getInputStream()));
			// 서버가 보낸 데이터를 스트림리더(문자열 단위)로 읽어 버퍼에 저장
			oos = new PrintWriter(child.getOutputStream());
			// 서버에서 클라이언트를 향해 OutputStream 리더로 보낼 데이터를 담는 객체

			user_id = ois.readLine(); // 클라이언트는 최초1회 자신의 ID를 전송하게 정해짐.
			ip = child.getInetAddress();
			System.out.println(ip + "로부터 " + user_id + "님이 접속하셨습니다."); // 서버 콘솔에 클라이언트가 접속한 것을 출력
			broadcast(user_id + "님이 접속하셨습니다.");

			synchronized(hm) { // 접속자 정보와 데이턱 담긴 hashmpa 데이터를 동시에 접근하지 못하도록 동기화 처리
				hm.put(user_id, oos); // hm에 클라이언트의 이름과 송신을 위한 OutputStream Writer 객체 저장
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> 5ab265f01e09ccdc62da581d3d5a9ab9d5346185
=======

>>>>>>> 5ab265f01e09ccdc62da581d3d5a9ab9d5346185
	}

	public void run() {
		String receiveData; // 수신된 데이터가 저장될 변수

		try {
			while((receiveData = ois.readLine()) != null) {
				if(receiveData.equals("/quit")) { // 접속 종료 절차
					synchronized (hm) {
						hm.remove(user_id); // 종료시 hashmmap에서 우저 Id정보를 가진 객체 삭제

					}
					break;
				} else if (receiveData.indexOf("/to") >= 0) { // 귓속말 구현
					sendMsg(receiveData);
				} else if (receiveData.indexOf("/userList") >=0 ) {// 유저 리스트 확인
					userList(receiveData);
				} else if (receiveData.indexOf("/myName") >= 0) {// 자신의 이름 확인
					userList(receiveData);
				} else {
					System.out.println(user_id + " >> " + receiveData); // 서버의 콘솔에 user가 송신한 텍스트 출력
					oos.println("나>>" + receiveData); //클라이언트에게 자신이 전송한 메세지를 되돌려서 송신해줌
					oos.flush();
					broadcast(user_id + " >> " + receiveData); // 해당 클라이어트를 제외한 다른 클라이언트들에게 broadcast

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			synchronized (hm) {
				hm.remove(user_id);
			}
			broadcast(user_id + "님이 퇴장하셨습니다.");
			System.out.println(user_id + "님이 퇴장하셨습니다.");
			try {
				if(child != null) {
					ois.close();
					oos.close();
					child.close();
				}
			} catch(Exception e) {}
		}
	}

	// 누군가 입력을 하면 다른 사용자들에게 전파 (hashmap을 통해 다른 사용자들의 Output Stream에 접근 가능)
	public void broadcast(String message) { // 파이썬의 for문처럼 list데이터를 순환하며 불러 저장 후 반복문 시랳ㅇ
		synchronized (hm) {
			try {
				Iterator<String> keys = hm.keySet().iterator(); // 키 반복 저장
				while ( keys.hasNext() ) {
                    String key = keys.next();
					if(!key.contentEquals(user_id)) {// 유저를 제외한 hashmap에 저장된 모든 클라이언트들에게 메시지 broadcast
						PrintWriter temp_oss = hm.get(key);
						temp_oss.println( message);
						temp_oss.flush();
					}
				}

			} catch (Exception e) {}

		}
	}

	// Hashmap에서 원하는 사용자의 OutputStream에 접근한 뒤 원하는 메시지 전송
	public void sendMsg(String message){
        int senderID_head = message.indexOf(" ") + 1;
        int senderID_tail  = message.indexOf(" ", senderID_head);

        // 메소드 알아두기
        if(senderID_tail != -1){
            String id = message.substring(senderID_head, senderID_tail);
            String msg = message.substring(senderID_tail+1);
            PrintWriter oos_whisper = hm.get(id);
            try{
                if(oos_whisper != null){
                	oos_whisper.println( user_id + "님이 다음과 같은 귓속말을 보내셨습니다. : " + msg );
                	oos_whisper.flush();
                }

            }catch(Exception e)
            {

            }
        }
    }

	// HashMap에 있는 모든 유저의 이름 출력
	public void userList(String message) {
		try {
			// 메소드 알아두기
			for ( String key : hm.keySet() ) {
        	    oos.println(key);
        	    oos.flush();
        	}
		} catch(Exception e) {}
	}

	// 서버에 저장된 나의 이름을 반환
	public void myName(String message) {
		try {
			// 메소드 알아두기
			oos.println("내 이름: " + user_id);
        	        oos.flush();
		} catch (Exception e) {}
	}

}
