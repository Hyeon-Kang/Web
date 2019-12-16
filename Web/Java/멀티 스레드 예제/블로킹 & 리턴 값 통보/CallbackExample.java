package callback;

import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallbackExample {
	private ExecutorService executorService; // 메인 스레드 에서 사용하기 위해 객체 선언

	public CallbackExample() {
		executorService = Executors.newFixedThreadPool(
			Runtime.getRuntime().availableProcessors()
		);
	}

	// callback 함수에서 참조 객체를 사용하지 않는다면 void 사용 가능 (Void 패키지 객체 첫 자리 V 대문자임을 유의!)
	private CompletionHandler<Integer, Void> callback = new CompletionHandler<Integer, Void>() {
		@Override
		public void completed(Integer result, Void attachment) { // 첨부객체를 사용하지 않으므로 Void 패키지 선언
			System.out.println("completed() 실행: " + result);
		}

		@Override
		public void failed(Throwable exc, Void attachment) {
			System.out.println("failed() 실행: " + exc.toString()); // 에러 내용 출력 (exc 예외 객체 참조)
		}
	};

	public void doWork(final String x, final String y) {
		Runnable task = new Runnable() {
			@Override
			public void run() {
				try {
					int intX = Integer.parseInt(x); // x, y 객체를 받아서 정수화
					int intY = Integer.parseInt(y);
					int result = intX + intY;       // 최종 결과값 획득
					callback.completed(result, null); // 뒷 쪽의 첨부객체는 Void 형식을 받기 때문에 null 값을 넣는다.
				} catch(NumberFormatException e) {
					callback.failed(e, null);
					// 만약 정수화가 불가능한 문자열이 들어오면 NumberFormatException이 발생하므로 예외 처리
				}
			}
		};
		executorService.submit(task); // 작업 큐에 선언한 task 실행객체 전달
	}

	public void finish() {			// 해당 스레드 풀 종료 함수 (프로그램 종료 절차)
		executorService.shutdown();
	}

	public static void main(String[] args) {
		CallbackExample example = new CallbackExample();
		example.doWork("3", "3");  // 정상 처리
		example.doWork("3", "삼"); // NumberFormatException 예외 발생
		example.finish();  // 스레드 풀 종료 절차 진입
	}
}
