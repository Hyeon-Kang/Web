package thread_state;

// target thread의 상태를 추적
public class StatePrintThread extends Thread {
	private Thread targetThread; // 해당 스레드에서 사용할 필드(객체)

	StatePrintThread(Thread targetThread) { // targetThread 객체를 인자로 받는다.
		this.targetThread = targetThread;
	}

	@Override
	public void run() {
		while(true) {

			Thread.State state = targetThread.getState(); // 열거형 변수 state 선언
			// 열거 상수가 궁금하면 api document 참조
			System.out.println("target Thread 상태 : " + state);

			// 해당 스레드가 NEW 상태면 스레드 실행
			if(state == Thread.State.NEW) {
				targetThread.start();
			}

      // 해당 스레드가 종료 처리되면 루프 탈출
			if(state == Thread.State.TERMINATED) {
				break; // 중단
			}

			try { // 루프마다 0.5초의 텀을 둔다
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
