package Bloking_type_notification;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ResultByRunnableExample {

	public static void main(String [] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(
				Runtime.getRuntime().availableProcessors()
				);

		System.out.println("[작업 처리 요청]");

		class Task implements Runnable {

			Result result;

			Task(Result result) {
				this.result = result;
			}

			@Override
			public void run() {
				// TODO Auto-generated method stub
				int sum =0;

				for(int i=1; i<=10; i++) {
					sum += i;
				}

				result.addValue(sum); // sum이 result에 누적 되도록 처리
			}


		};

		// 스레드 외부 공유객체 생성
		Result result = new Result();

		// 두개의 작업 정의
		Runnable task1 = new Task(result);
		Runnable task2 = new Task(result);

		// 작업 결과 받아오기 (취합 전 저장)
		Future<Result> future1 = executorService.submit(task1, result);
		Future<Result> future2 = executorService.submit(task2, result);

		try {
			result = future1.get();
			result = future2.get();

			// task1, 2가 모두 처리 끝난 뒤 작업 진행
			System.out.println("[처리 결과] " + result.accumValue);
			System.out.println("[작업 처리 완료]");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("[실행 예외 발생] " + e.getMessage());

		}

	}

} // main class end


class Result {
	int accumValue;

	synchronized void addValue(int value) {
		accumValue += value;
	} // 스레드의 연산 결과 취합
}
