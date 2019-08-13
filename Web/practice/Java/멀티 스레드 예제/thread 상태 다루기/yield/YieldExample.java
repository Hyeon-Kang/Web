package thread_yield;

public class YieldExample {

	public static void main(String[] args) {
		ThreadA threadA = new ThreadA();
		ThreadB threadB = new ThreadB();
		threadA.start();
		threadB.start();

		try {
			System.out.println("main thread sleep");
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // main thread sleep

		threadA.work = false;

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {}

		threadA.work = true;

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {}

		// 모든 스레드 정지
		threadA.stop = true; // stop() 메소드가 아닌 stop boolean 필드의 값을 수정하여 run 종료 유도
		threadB.stop = true;
	}
}
