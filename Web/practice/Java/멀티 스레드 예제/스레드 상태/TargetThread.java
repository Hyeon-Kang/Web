package thread_state;

public class TargetThread extends Thread{

	@Override
	public void run() {
		for(long i=0; i<1000000000; i++) {}

		try { // 인위적으로 1.5초 대기를 주어 TIMED_WATING 관측
			System.out.println("1.5초 sleep");
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for(long i=0; i<1000000000; i++) {}
      // Runnable 상태를 얻기 위해 소모적 연산 실행
	}

}
