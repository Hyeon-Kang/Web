// 런타임 예외처리 예제

public class Try_Catch_Finally_RuntimeException_Example {
  public static void main (String [] args) {
    String data1 = null;
    String data2 = null;
    try {
      data1 = args[0];
      data2 = args[1];
    } catch(Try_Catch_Finally_RuntimeException_Example e) {
      System.out.println("실행 매개값의 수가 부족합니다.");
      System.out.println("매개변수 입력 확인!");
      System.out.println("프로그램 매개변수1 매개변수2");
      return;
    }

  }
}
