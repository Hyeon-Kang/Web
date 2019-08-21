package wait_notify;

public class WaitNotifyExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WorkObject sharedObject = new WorkObject();

		ThreadA threadA = new ThreadA(sharedObject);
		ThreadB threadB = new ThreadB(sharedObject);

		threadA.start();
		threadB.start();
	}

}
