public class ThrowsExample {
  public static void main (String [] args) {

    try {
      findClass();
    } catch (ClassNotFoundException e) {
      System.out.println("클래스가 존재하지 않습니다.");
    }


  }// emd main

  public static void findClass() throws ClassNotFoundException {
    Class clazz = Class.forName("java.lang.String2"); // 존재하지 않는 아무 메소드 제공
    // 다음 코드는 일반예외를 발생
  }
}
