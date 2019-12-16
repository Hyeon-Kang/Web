package thread_state;

public class ThreadStateExample {

	public static void main(String[] args) {
		// 모니터링 스레드 초기 참조 파라미터 값으로 target thread 부여
		StatePrintThread statePrintThread = new StatePrintThread(new TargetThread());

		statePrintThread.start();
	}

}
