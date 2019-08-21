package thread_group;

public class WorkThread extends Thread {
	public WorkThread(ThreadGroup threadGroup, String threadName) {
		super(threadGroup, threadName);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				Thread.sleep(1000); // 인터럽트 예외 발생을 위한 강제 sleep 유도
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println(getName() + "interrupted");
				break;
			}
		}

		System.out.println("스레드 종료.");
	}
}
