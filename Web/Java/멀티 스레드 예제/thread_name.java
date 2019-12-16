// 스레드의 구분을 위한 이름 설정 및 운용 예제

// 구성 요소 : ThreadNameExample.java, ThreadA.java, ThreadB.java


public class ThreadNameExample {
  public static void main(String args[]) {
    Thread mainThread = Thread.currentThread();
    System.out.println("프로그램 시작 스레드 이름 : " + mainThread.getName());

    ThreadA threadA = new ThreadA();
    System.out.println("작업 스레드 이름 : " + threadA.getName());
    threadA.start();

    ThreadB threadB = new ThreadB();
    System.out.println("작업 스레드 이름 : " + threadB.getName());
    threadB.start();

  } // main end
} // class end
