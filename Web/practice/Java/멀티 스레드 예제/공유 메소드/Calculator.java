package thread_synchronized_class;


public class Calculator {
	private int memory; // 공유 필드

	public int getMemory() {
		return memory;
	} // getMemory end

	public synchronized void setMemory(int memory) {
		this.memory = memory;

		try {
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName() + ":" + this.memory);
		} catch (InterruptedException e) {
			//System.out.println(Thread.currentThread().getName() + ":" + this.memory);
		}
	} // setMemory end

} // class end
