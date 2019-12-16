package thread_group;

import java.util.Map;
import java.util.Set;

public class groupExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AutoSaveThread  autosave = new AutoSaveThread();
		autosave.setName("AutoSaveThread"); // 스레드 식별네임 설정
		autosave.setDaemon(true); // 데몬 스레드 등록
		autosave.start();

		Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();

		//클랙션 객체를 통해 스택에 상주한 모든 스레드 데이터 추적
		//jvm이 생성한 모든 스레드 추적

		Set<Thread> threads = map.keySet();
		// set 안에 현재 사용중인 모든스레드가 들어감

		for(Thread thread : threads) {
			System.out.println("Name : " + thread.getName() + ((thread.isDaemon()?"(데몬)":"(주)")));
			System.out.println("\t" + "소속그룹 : " + thread.getThreadGroup().getName());
			System.out.println();
		}
	}

}
