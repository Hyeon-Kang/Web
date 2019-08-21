package thread_yield;

public class ThreadB extends Thread{
	public boolean stop = false;
	public boolean work = true;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!stop) {
			if(work) {
				System.out.println("Thread B 작업 내용");
			} else {
				Thread.yield();
			}
		}
		System.out.println("Thread B 종료");
	}
}
