package wait_notify;

public class WorkObject {
	public synchronized void methodA() { // 메소드 공유객체 주의!
		System.out.println("ThreadA의 methodA() 작업 실행");

		notify(); // 현재 waiting 된 다른 스레드를 실행대기로 변경
		try {
			wait(); //  자신은 일시 정지로 돌아감
		} catch (InterruptedException e) {}
	}

	public synchronized void methodB() {
		System.out.println("ThreadA의 methodB() 작업 실행");

		notify(); // 현재 waiting 된 다른 스레드를 실행대기로 변경
		try {
			wait(); //  자신은 일시 정지로 돌아감
		} catch (InterruptedException e) {}
	}

}
