// 메인 스레드만 이용한 경우

import java.awt.*;

public class BeepPrintExample1 {
  public static void main(Strint[] args) {
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    // toolkit 객체 얻기 (비프음 메소드 호출에 필요)

    for(int i=0; i<5; i++)  {
      toolkit.beep();
      try {Thread.sleep(500);} catch(Exception e) {}

    } // for end : 0.5초의 딜레이를 가지고 beep음 출력

    for(int i =0; i<5; i++) {
      System.out.println("beep!");
      try {Thread.sleep(500);} catch(Exception e) {}
    } // for end : 0.5초의 딜레이를 가지고 beep 텍스트 콘솔창에 출력

  } // main end
} // class end


// 이렇게 메인 스레드에 작성을 하면 beep음만 0.5초 딜레이로 5번 출력 후
// 콘솔창에 beep 텍스트가 0.5초 딜레이로 5번 출력 된다.

// 즉 출력과 소리가 동시에 일어나지 않는다.
