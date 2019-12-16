package thread_synchronized_class;

public class User2 extends Thread {
	private Calculator calculator;

	public void setCalculator(Calculator calculator) {
		this.setName("User2");
		this.calculator = calculator;
	} // setter end

	@Override
	public void run() {
		calculator.setMemory(50);
	}


}
