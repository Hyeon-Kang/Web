// Beep 소리 출력 task 분리

public class BeepTask implements Runnable {
  public void run() {
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    for (int i =0; i<5; i++) {
      toolkit.beep();
      try{thread.sleep(500);} cathc(Exception e) {}
    }// for end
  } // run end
} // class end
