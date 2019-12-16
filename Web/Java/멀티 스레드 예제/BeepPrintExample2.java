// BeepTask (소리 출력 Task 분리)

public class BeepPrintExample2 {
  public static void main(String[] args) {
    Runnable beepTask = new BeepTask();
    Thread thread = new Thread(beepTask);

    for (int i=0; i<5; i++) {
      System.out.println("띵");
      try {Thread.sleep(500);} catch (Exception e) {}

    }
  }
}
