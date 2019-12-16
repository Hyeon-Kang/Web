package thread_group;

public class AutoSaveThread extends Thread {
	public void save() {
		System.out.println("작업 내용이 저장되었습니다.");
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				break; // 예외 발생 시 while문 탈출
			}

			save();
		}
	}

}
