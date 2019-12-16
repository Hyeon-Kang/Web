//PriorityExample.java 부속

public class CalcThread extends Thread {
  public CalcThread(String name) {
    setName(name); // 입력한 문자열로 스레드 이름 변경
  } // constructor end

  public void run() {
    for(int i =0; i<20000000; i++) {
      // 스레드에 딜레이를 주기 위한 무의미한 연산
    } // for end

    System.out.println(getName());
  } // run end
} // class end
