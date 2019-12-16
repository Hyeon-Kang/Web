package thread_synchronized_class;

public class User1 extends Thread {
	private Calculator calculator;

	public void setCalculator(Calculator calculator) {
		this.setName("User1");
		this.calculator = calculator;
	} // setter end

	@Override
	public void run() {
		calculator.setMemory(100);
	} // run end


}
