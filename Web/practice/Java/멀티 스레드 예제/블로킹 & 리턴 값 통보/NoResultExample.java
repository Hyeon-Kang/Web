package Bloking_type_notification;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class NoResultExample {

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(
				Runtime.getRuntime().availableProcessors());

		System.out.println("[작업 처리 요청]");

		// Runnable 실행 객체 생성
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				int sum = 0;
				for(int i =1; i<= 10; i++) {
					sum += i;
				}

				System.out.println("[처리 결과] : " + sum);

			}
		};

		Future future = executorService.submit(runnable);
		// future 객체에 executorService 스레드 풀에서 submit 옵션으로 runnable 객체를 돌린 결과를 반환한다.
		// 아래에 future.get() 메소드를 선언하였으므로 runnable의 작업이 완료 될 때까지 main 스레드는 블로킹 상태로 대기한다.


		try {
			future.get();
			System.out.println("[작업 처리 완료]");
		} catch (InterruptedException e) {

			// Interrupt() 메소드 호출 시 해당 예외처리 실행
			System.out.println("[인터럽트 예외 발생함] " + e.getMessage());
			e.printStackTrace();
		} catch (ExecutionException e) {

			// 작업 처리 도중 예외 발생 시 해당 예외처리 실행
			System.out.println("[실행 예외 발생함] " + e.getMessage());
			e.printStackTrace();
		}



		executorService.shutdown(); // 스레드 풀 종료 절차
	}

}
