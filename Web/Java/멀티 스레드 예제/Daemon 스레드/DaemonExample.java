package thread_daemon;

public class DaemonExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AutoSaveThread autoSave = new AutoSaveThread();

		autoSave.setDaemon(true); // 오토세이브 스레드를 데몬 스레드로 설정

		autoSave.start();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("메인 스레드 종료.");
	}

}
