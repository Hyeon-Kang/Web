public class ThreadB extends Thread {

  // constructor 생략
  // 출력 시 스레드 이름은 default 값 지정 (Thread-n)
  public void run() {
    for(int i = 0; i <2; i++) {
      System.out.println(getName() + "가 출력한 내용");
    } // for end
  } // run end
} // ThreadB end
