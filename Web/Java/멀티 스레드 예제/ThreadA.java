public class ThreadA extends Thread {
  public ThreadA() {
    setName("ThreadA");
    // 생성자 단계에서 이름 설정
  } // constructor end

  public void run () {
    for(int i=0; i<2; i++) {
      System.out.println(getName() + "가 출력한 내용");
    } // for end
  } // run end
} // ThreadA end
