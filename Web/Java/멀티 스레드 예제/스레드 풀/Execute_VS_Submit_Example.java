package thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Execute_VS_Submit_Example {

	public static void main(String [] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);

		for(int i=0; i<10; i++) {
			Runnable runnable = new Runnable() {
				public void run() {
					ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)executorService;

					int poolSize = threadPoolExecutor.getPoolSize(); // 현재 스레드 풀의 스레드 수 출력
					String threadName = Thread.currentThread().getName();
					System.out.println("[총 스레드 개수: " + poolSize+ "] 작업 스레드 이름 :" + threadName);

					int value = Integer.parseInt("삼"); // 인위적 예외 유발
				} // run end
			}; // Runnable end

			executorService.execute(runnable); // 작업 큐에 runnable 저장
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


		executorService.shutdown();


	} // main end
} // class end


이하 실행 결과

반복문이 너무 빨리 돌기때문에 중간에 Thread.sleep(10); 삽입

다음과 같이 스레드에서 예외가 발생하면 그 스레드는 제거되고 새로운 스레드가 생성됨을 확인


[총 스레드 개수: 1] 작업 스레드 이름 :pool-1-thread-1
Exception in thread "pool-1-thread-1" java.lang.NumberFormatException: For input string: "삼"
	at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:68)
	at java.base/java.lang.Integer.parseInt(Integer.java:658)
	at java.base/java.lang.Integer.parseInt(Integer.java:776)
	at thread_pool.Execute_VS_Submit_Example$1.run(Execute_VS_Submit_Example.java:21)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
	at java.base/java.lang.Thread.run(Thread.java:835)
[총 스레드 개수: 2] 작업 스레드 이름 :pool-1-thread-3
Exception in thread "pool-1-thread-3" java.lang.NumberFormatException: For input string: "삼"
	at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:68)
	at java.base/java.lang.Integer.parseInt(Integer.java:658)
	at java.base/java.lang.Integer.parseInt(Integer.java:776)
	at thread_pool.Execute_VS_Submit_Example$1.run(Execute_VS_Submit_Example.java:21)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
	at java.base/java.lang.Thread.run(Thread.java:835)
[총 스레드 개수: 2] 작업 스레드 이름 :pool-1-thread-2
Exception in thread "pool-1-thread-2" java.lang.NumberFormatException: For input string: "삼"
	at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:68)
	at java.base/java.lang.Integer.parseInt(Integer.java:658)
	at java.base/java.lang.Integer.parseInt(Integer.java:776)
	at thread_pool.Execute_VS_Submit_Example$1.run(Execute_VS_Submit_Example.java:21)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
	at java.base/java.lang.Thread.run(Thread.java:835)
[총 스레드 개수: 2] 작업 스레드 이름 :pool-1-thread-4
Exception in thread "pool-1-thread-4" java.lang.NumberFormatException: For input string: "삼"
	at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:68)
	at java.base/java.lang.Integer.parseInt(Integer.java:658)
	at java.base/java.lang.Integer.parseInt(Integer.java:776)
	at thread_pool.Execute_VS_Submit_Example$1.run(Execute_VS_Submit_Example.java:21)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
	at java.base/java.lang.Thread.run(Thread.java:835)
[총 스레드 개수: 2] 작업 스레드 이름 :pool-1-thread-5
Exception in thread "pool-1-thread-5" java.lang.NumberFormatException: For input string: "삼"
	at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:68)
	at java.base/java.lang.Integer.parseInt(Integer.java:658)
	at java.base/java.lang.Integer.parseInt(Integer.java:776)
	at thread_pool.Execute_VS_Submit_Example$1.run(Execute_VS_Submit_Example.java:21)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
	at java.base/java.lang.Thread.run(Thread.java:835)
[총 스레드 개수: 2] 작업 스레드 이름 :pool-1-thread-6
Exception in thread "pool-1-thread-6" java.lang.NumberFormatException: For input string: "삼"
	at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:68)
	at java.base/java.lang.Integer.parseInt(Integer.java:658)
	at java.base/java.lang.Integer.parseInt(Integer.java:776)
	at thread_pool.Execute_VS_Submit_Example$1.run(Execute_VS_Submit_Example.java:21)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
	at java.base/java.lang.Thread.run(Thread.java:835)
[총 스레드 개수: 2] 작업 스레드 이름 :pool-1-thread-7
Exception in thread "pool-1-thread-7" java.lang.NumberFormatException: For input string: "삼"
	at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:68)
	at java.base/java.lang.Integer.parseInt(Integer.java:658)
	at java.base/java.lang.Integer.parseInt(Integer.java:776)
	at thread_pool.Execute_VS_Submit_Example$1.run(Execute_VS_Submit_Example.java:21)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
	at java.base/java.lang.Thread.run(Thread.java:835)
[총 스레드 개수: 2] 작업 스레드 이름 :pool-1-thread-8
Exception in thread "pool-1-thread-8" java.lang.NumberFormatException: For input string: "삼"
	at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:68)
	at java.base/java.lang.Integer.parseInt(Integer.java:658)
	at java.base/java.lang.Integer.parseInt(Integer.java:776)
	at thread_pool.Execute_VS_Submit_Example$1.run(Execute_VS_Submit_Example.java:21)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
	at java.base/java.lang.Thread.run(Thread.java:835)
[총 스레드 개수: 2] 작업 스레드 이름 :pool-1-thread-9
Exception in thread "pool-1-thread-9" java.lang.NumberFormatException: For input string: "삼"
	at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:68)
	at java.base/java.lang.Integer.parseInt(Integer.java:658)
	at java.base/java.lang.Integer.parseInt(Integer.java:776)
	at thread_pool.Execute_VS_Submit_Example$1.run(Execute_VS_Submit_Example.java:21)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
	at java.base/java.lang.Thread.run(Thread.java:835)
[총 스레드 개수: 2] 작업 스레드 이름 :pool-1-thread-10
Exception in thread "pool-1-thread-10" java.lang.NumberFormatException: For input string: "삼"
	at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:68)
	at java.base/java.lang.Integer.parseInt(Integer.java:658)
	at java.base/java.lang.Integer.parseInt(Integer.java:776)
	at thread_pool.Execute_VS_Submit_Example$1.run(Execute_VS_Submit_Example.java:21)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
	at java.base/java.lang.Thread.run(Thread.java:835)
