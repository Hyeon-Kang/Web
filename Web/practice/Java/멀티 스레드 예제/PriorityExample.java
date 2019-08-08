// 스레드 우선순위 부여 예제

// CalcThread.java 참조

publicc class PriorityExample {
  public static void main(String args[]) {
    for (int i =0; i<=10; i++) {
      Thread thread = new  CalcThread("thread" + i);
      if (i !=10) {
        thread.setPriority(Thread.MIN_PRIORITY);
        // 가장 낮은 우선순위 설정
      } else {
        thread.setPriority(Thread.MAX_PRIORITY);
      } // if extend

      thread.start();
    }
  }
}
